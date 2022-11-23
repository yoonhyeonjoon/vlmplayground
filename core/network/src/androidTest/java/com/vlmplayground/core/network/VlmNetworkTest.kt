package com.vlmplayground.core.network

import android.support.test.InstrumentationRegistry
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.vlmplayground.core.network.firebase.FirebaseNetworkDataSource
import com.vlmplayground.core.network.model.NetworkBulletin
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
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

        val ff = async {
            delay(5000L)
            val hhh = 1
        }

        dataSource.getBulletinByTimestamp(0).collect {
            getResult = it
            return@collect
        }



        ff.start()


//        dataSourceJob.join()
//        val ff = 1

    }

//
//    @Test
//    fun testFirebaseRead() = runTest {
//        val instrumentationContext = InstrumentationRegistry.getTargetContext()
////        val firebaseApp: FirebaseApp = FirebaseApp.initializeApp(instrumentationContext)!!
//        val dataSource = FirebaseNetworkDataSource(Firebase.firestore)
//        dataSource.getBulletinByTimestamp().collect{ result ->
//            val ff = 1
//
//        }
//        Firebase.firestore.collection("bulletinBoard").get().addOnSuccessListener {
//            it.documents
//        }
//
//        launch{ //to hold the process, set limit of timeout as below mili-seconds.
//            delay(10000)
//        }
//    }

    //TestBulletinBoardDao

}
