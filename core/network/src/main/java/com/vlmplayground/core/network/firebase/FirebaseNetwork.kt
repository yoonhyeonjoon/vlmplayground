package com.vlmplayground.core.network.firebase

import android.util.Log
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
import javax.inject.Inject

class FirebaseNetwork @Inject constructor(private val firebase : FirebaseFirestore)
    : VlmPlaygroundDataSource {


    override suspend fun getBulletin(): Flow<NetworkBulletin> = callbackFlow {

            var eventsCollection: CollectionReference? = null
            try {
                eventsCollection = firebase
                    .collection("bulletinBoard")
            } catch (e: Throwable) {
                // If Firebase cannot be initialized, close the stream of data
                // flow consumers will stop collecting and the coroutine will resume
                close(e)
            }

            val subscription = eventsCollection?.addSnapshotListener { snapshot, _ ->
                if (snapshot == null) { return@addSnapshotListener }
                try {
                    for (i in snapshot.documentChanges){
                        if(i.type == DocumentChange.Type.ADDED){
                            trySend(i.document.toObject(NetworkBulletin::class.java)).isSuccess
                        }
                    }
                } catch (e: Throwable) {
                    val a = 0
                }
            }
            awaitClose {
                subscription?.remove()
            }
        }.flowOn(Dispatchers.IO)

}