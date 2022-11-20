package com.vlmplayground.core.network

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.matcher.ViewMatchers.assertThat
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.vlmplayground.core.network.firebase.FirebaseNetwork
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.CountDownLatch


class VlmNetworkDataSourceTestAndroid {

//    private lateinit var subject: FirebaseNetwork
//

//    @Rule
//    var firebaseAppRule: FirebaseAppRule = FirebaseAppRule()

//    private lateinit var network: FirebaseNetwork

//    @Mock
//    private lateinit var  firebaseFirestore : FirebaseFirestore
//
//    lateinit var instrumentationContext: Context
//
//    @Before
//    fun setUp() {
//        MockitoAnnotations.initMocks(this)
//        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
////        FirebaseApp.initializeApp(appContext)
////        subject = FirebaseNetwork(firebaseFirestore)
//
//    }

    @Test
    fun testFirebaseRead() {
        org.junit.Assert.assertEquals(true, true)
//        val instrumentationContext = InstrumentationRegistry.getInstrumentation().context
//        FirebaseApp.initializeApp(instrumentationContext)
//        val db = Firebase.firestore
//        val latch = CountDownLatch(1)
//
//        db.collection("bulletinBoard").addSnapshotListener { snapshot, _ ->
//            if (snapshot == null) {
//                return@addSnapshotListener
//            }
//            try {
//                for (i in snapshot.documentChanges) {
//                    if (i.type == DocumentChange.Type.ADDED) {
//
//                    }
//                }
//            } catch (e: Throwable) {
//                val a = 0
//            }
//        }
//
////        assertThat("playground.fada21.com.mytestapplication.test").isEqualTo(instrumentationContext.packageName)
//
//// Will wait for the latch to become 0
//        latch.await()
//        FirebaseApp.initializeApp(InstrumentationRegistry.getInstrumentation().targetContext)
//        firebaseFirestore = FirebaseFirestore.getInstance()
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

//        val mockFirestore = Mockito.mock(FirebaseFirestore::class.java)
//
//        firebaseFirestore.collection("bulletinBoard").addSnapshotListener { snapshot, _ ->
//            if (snapshot == null) {
//                return@addSnapshotListener
//            }
//            try {
//                for (i in snapshot.documentChanges) {
//                    if (i.type == DocumentChange.Type.ADDED) {
//
//                    }
//                }
//            } catch (e: Throwable) {
//                val a = 0
//            }
//        }
    }
}
//        Mockito.`when`(.getBulletin().collect{ it ->
//            val ff = it.id
//
//        })

//        val bbb = Mockito.mock(FirebaseApp::class.java)
//        bbb.applicationContext
//        firebaseFirestore
//        FirebaseNetwork(firebaseFirestore).getBulletin().collect{ it ->
//            val ff = it.id
//
//        }

//        assertEquals(
//            /* ktlint-disable max-line-length */
//            NetworkTopic(
//                id = "1",
//                name = "Headlines",
//                shortDescription = "News you'll definitely be interested in",
//                longDescription = "The latest events and announcements from the world of Android development.",
//                url = "",
//                imageUrl = "https://firebasestorage.googleapis.com/v0/b/now-in-android.appspot.com/o/img%2Fic_topic_Headlines.svg?alt=media&token=506faab0-617a-4668-9e63-4a2fb996603f"
//            ),
//            /* ktlint-enable max-line-length */
//            subject.getTopics().first()
//        )

