package com.vlmplayground.core.network.fake

import com.google.firebase.firestore.FirebaseFirestore
import com.vlmplayground.core.network.firebase.FirebaseNetwork
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class FakeNiaNetworkDataSourceTest {

    private lateinit var subject: FirebaseNetwork
    private lateinit var  firebaseFirestore : FirebaseFirestore
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        firebaseFirestore = FirebaseFirestore.getInstance()
        subject = FirebaseNetwork(firebaseFirestore)
    }

    @Test
    fun testDeserializationOfTopics() = runTest(testDispatcher) {
        assertEquals(
            /* ktlint-disable max-line-length */
            NetworkTopic(
                id = "1",
                name = "Headlines",
                shortDescription = "News you'll definitely be interested in",
                longDescription = "The latest events and announcements from the world of Android development.",
                url = "",
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/now-in-android.appspot.com/o/img%2Fic_topic_Headlines.svg?alt=media&token=506faab0-617a-4668-9e63-4a2fb996603f"
            ),
            /* ktlint-enable max-line-length */
            subject.getTopics().first()
        )
    }

    @Test
    fun testDeserializationOfNewsResources() = runTest(testDispatcher) {
        assertEquals(
            /* ktlint-disable max-line-length */
            NetworkNewsResource(
                id = "125",
                title = "Android Basics with Compose",
                content = "We released the first two units of Android Basics with Compose, our first free course that teaches Android Development with Jetpack Compose to anyone; you do not need any prior programming experience other than basic computer literacy to get started. ",
                url = "https://android-developers.googleblog.com/2022/05/new-android-basics-with-compose-course.html",
                headerImageUrl = "https://developer.android.com/images/hero-assets/android-basics-compose.svg",
                authors = listOf("25"),
                publishDate = LocalDateTime(
                    year = 2022,
                    monthNumber = 5,
                    dayOfMonth = 4,
                    hour = 23,
                    minute = 0,
                    second = 0,
                    nanosecond = 0
                ).toInstant(TimeZone.UTC),
                type = Codelab,
                topics = listOf("2", "3", "10"),
            ),
            /* ktlint-enable max-line-length */
            subject.getNewsResources().find { it.id == "125" }
        )
    }
}