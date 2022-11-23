package com.vlmplayground.core.network

import android.support.test.InstrumentationRegistry
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.vlmplayground.core.network.firebase.FirebaseNetworkDataSource
import com.vlmplayground.core.network.model.NetworkBulletin
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.test.runTest
import okhttp3.internal.wait
import org.junit.Test
import kotlin.test.assertTrue


class VlmNetworkTest {


    //Firestore approaching
    @Test
    fun testFirebaseFirestore() = runTest {
        val instrumentationContext = InstrumentationRegistry.getTargetContext()
        val firebaseApp: FirebaseApp = FirebaseApp.initializeApp(instrumentationContext)!!
        var aDocument = Firebase.firestore.collection("bulletinBoard").limit(1).get().addOnSuccessListener {
            it.documents
        }.await()

        val getData = aDocument.documents.first().data
        getData?.let { assertTrue(it.isNotEmpty()) }?:assertTrue(false)
    }

    //Firestore-NetworkDataSource approaching
    @Test
    fun testFirebaseNetworkDataSource() = runTest {
        val dataSource = FirebaseNetworkDataSource(Firebase.firestore)
        var getResult = listOf<NetworkBulletin>()

        runBlocking {

            val dataSourceJob: Job =
                launch {  dataSource.getBulletinByTimestamp(0).collect {
                        getResult = it
                    }
                }
            launch {
                delay(5000L)
                dataSourceJob.cancel()
            }
        }


    }


}
