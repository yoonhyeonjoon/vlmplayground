package com.vlmplayground.core.network.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.vlmplayground.core.network.VlmPlaygroundDataSource
import com.vlmplayground.core.network.model.NetworkBulletin
import javax.inject.Inject

class FirebaseNetwork @Inject constructor(firebase : FirebaseFirestore) : VlmPlaygroundDataSource {
    override suspend fun getBulletin(): List<NetworkBulletin> {

    }
}