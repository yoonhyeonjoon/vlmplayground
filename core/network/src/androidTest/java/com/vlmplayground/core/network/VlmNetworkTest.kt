package com.vlmplayground.core.network

import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.vlmplayground.core.network.firebase.FirebaseNetworkDataSource
import com.vlmplayground.core.network.model.NetworkBulletin
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertTrue


class VlmNetworkTest {

    //Firestore approaching
    @Test
    fun testFirebaseFirestore() = runTest {
//        val instrumentationContext = InstrumentationRegistry.getTargetContext()
//        val firebaseApp: FirebaseApp = FirebaseApp.initializeApp(instrumentationContext)!!
        val aDocument = Firebase.firestore.collection("bulletinBoard").limit(1).get().addOnSuccessListener {
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

            val gg: List<NetworkBulletin> = dataSource.getBulletinByTimestamp(1507593600L*3).first()
//            dataSource.insertOrIgnoreBulletins()
//            val dataSourceJob: Job =
//                launch {  dataSource.getBulletinByTimestamp(1507593600L*3)
//
//                    .collect {
//                        getResult = it
//                    }
//                }
//            launch {
//                delay(5000L)
//                dataSourceJob.cancel()
//            }
        }


    }

    @Test
    fun testFirebaseNetworkDataSource() = runTest {
        val dataSource = FirebaseNetworkDataSource(Firebase.firestore)
        var getResult = listOf<NetworkBulletin>()

        runBlocking {

            val gg: List<NetworkBulletin> = dataSource.getBulletinByTimestamp(1507593600L*3).first()

        }


    }


}
