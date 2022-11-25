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
import kotlinx.coroutines.tasks.await
import java.util.*
import javax.inject.Inject

class FirebaseNetworkDataSource @Inject constructor(private val firebase : FirebaseFirestore)
    : VlmPlaygroundDataSource {

    //collectionRef.where("startTime", ">=", "1506816000").where("startTime", "<=", "1507593600")
    override fun getBulletinByTimestamp(movePoint: Long): Flow<List<NetworkBulletin>> = callbackFlow {
        var eventsCollection: CollectionReference? = null
        try
        {
            eventsCollection = firebase.collection("bulletinBoard")
        }
        catch (e: Throwable)
        {
            // If Firebase cannot be initialized, close the stream of data
            // flow consumers will stop collecting and the coroutine will resume
            close(e)
        }

        val subscription = eventsCollection
            ?.whereGreaterThan("date", Date(Date().time - movePoint))
            ?.addSnapshotListener { snapshot, _ ->
                if (snapshot == null) { return@addSnapshotListener }
                try {
                    val bulletinList = mutableListOf<NetworkBulletin>()
                    for (i in snapshot.documentChanges) {
                        if (i.type == DocumentChange.Type.ADDED || i.type == DocumentChange.Type.MODIFIED || i.type == DocumentChange.Type.REMOVED) {
                            bulletinList.add(i.document.toObject(NetworkBulletin::class.java))
                        }
                    }
                    trySend(bulletinList.toList()).isSuccess
                    bulletinList.clear()
                }
                catch (e: Throwable)
                {
                    println(e.toString())
                }
            }
            awaitClose {
                subscription?.remove()
            }
    }

    override fun insertOrIgnoreBulletins(entities: List<NetworkBulletin>): Boolean {

        var eventsCollection: CollectionReference? = null
        try
        {
            eventsCollection = firebase.collection("bulletinBoard")
        }
        catch (e: Throwable)
        {
            return false
        }

//        suspend fun insertFBRoomDataToMyCol(
//            userId : String,
//            networkRoomData: NetworkRoomData,
//            roomFid: String,
//            success : (Boolean) -> Unit
//        ){
//            val col = userCol.document(userId).collection("room").document(roomFid)
//            col.set(networkRoomData).addOnSuccessListener {
//                success(true)
//            }.addOnFailureListener{
//                success(false)
//            }.await()
//
//        }
//
        firebase.runBatch{ batch ->
            entities.subList(0,499).forEach { aEntry -> //the reason why under 500, because of firestore limitation
                batch.set(aEntry.fid, eventsCollection)
            }
        }


        eventsCollection.document()
        eventsCollection.ad
        val subscription = eventsCollection
            ?.whereGreaterThan("date", Date(Date().time - movePoint))
            ?.addSnapshotListener { snapshot, _ ->
                if (snapshot == null) { return@addSnapshotListener }
                try {
                    val bulletinList = mutableListOf<NetworkBulletin>()
                    for (i in snapshot.documentChanges) {
                        if (i.type == DocumentChange.Type.ADDED || i.type == DocumentChange.Type.MODIFIED || i.type == DocumentChange.Type.REMOVED) {
                            bulletinList.add(i.document.toObject(NetworkBulletin::class.java))
                        }
                    }
                    trySend(bulletinList.toList()).isSuccess
                    bulletinList.clear()
                }
                catch (e: Throwable)
                {
                    println(e.toString())
                }
            }


    }

    override fun deleteBulletin(fid: String) {
        TODO("Not yet implemented")
    }



}