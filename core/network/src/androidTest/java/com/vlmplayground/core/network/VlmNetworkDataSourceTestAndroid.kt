package com.vlmplayground.core.network

import android.support.test.InstrumentationRegistry
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.test.runTest
import org.junit.Test


class VlmNetworkDataSourceTestAndroid {
    @Test
    fun testFirebaseRead() = runTest {
        val instrumentationContext = InstrumentationRegistry.getTargetContext()
        val firebaseApp: FirebaseApp = FirebaseApp.initializeApp(instrumentationContext)!!
        Firebase.firestore.collection("bulletinBoard").get().addOnSuccessListener {
            it.documents
        }.await()
    }
}
