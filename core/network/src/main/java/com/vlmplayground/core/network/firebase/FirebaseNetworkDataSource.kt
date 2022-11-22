package com.vlmplayground.core.network.firebase

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.vlmplayground.core.network.VlmPlaygroundDataSource
import com.vlmplayground.core.network.model.NetworkBulletin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import java.util.*
import javax.inject.Inject

class FirebaseNetworkDataSource @Inject constructor(private val firebase : FirebaseFirestore)
    : VlmPlaygroundDataSource {

    //collectionRef.where("startTime", ">=", "1506816000").where("startTime", "<=", "1507593600")
    override fun getBulletinByTimestamp(movePoint: Long): Flow<NetworkBulletin> = callbackFlow {

            var eventsCollection: CollectionReference? = null
            try {
                eventsCollection = firebase.collection("bulletinBoard")
            } catch (e: Throwable) {
                // If Firebase cannot be initialized, close the stream of data
                // flow consumers will stop collecting and the coroutine will resume
                close(e)
            }

            val subscription = eventsCollection?.whereGreaterThan("date", Date(Date().time - movePoint))?.addSnapshotListener { snapshot, _ ->
                if (snapshot == null) { return@addSnapshotListener }
                try
                {
                    for (i in snapshot.documentChanges) {
                        if (i.type == DocumentChange.Type.ADDED || i.type == DocumentChange.Type.MODIFIED || i.type == DocumentChange.Type.REMOVED) {
                            trySend(i.document.toObject(NetworkBulletin::class.java)).isSuccess
                        }
                    }
                }
                catch (e: Throwable)
                {
                    val a = 0
                }
            }
            awaitClose {
                subscription?.remove()
            }

    }.flowOn(Dispatchers.IO)


//    override fun getBulletinByTimestamp(currentPoint: Date): Flow<NetworkBulletin>  = callbackFlow {
//        TODO("Not yet implemented")
////        var eventsCollection: CollectionReference? = null
////        try {
////            eventsCollection = firebase.collection("bulletinBoard")
////        } catch (e: Throwable) {
////            close(e)
////        }
////
////
////        val subscription = eventsCollection?.whereLessThan("date", Date(currentPoint.time + 432000_000))?.addSnapshotListener { snapshot, _ ->
////            if (snapshot == null) {
////                return@addSnapshotListener
////            }
////            try {
////                for (i in snapshot.documentChanges) {
////                    if (i.type == DocumentChange.Type.ADDED) {
////                        trySend(i.document.toObject(NetworkBulletin::class.java)).isSuccess
////                    }
////                }
////            } catch (e: Throwable) {
////                val a = 0
////            }
////        }
////        awaitClose {
////            subscription?.remove()
////        }
//    }


    override fun deleteBulletin(fid: String) {
        TODO("Not yet implemented")
    }

    override fun insertOrIgnoreBulletin(topicEntities: NetworkBulletin): Long {
        TODO("Not yet implemented")
    }
}