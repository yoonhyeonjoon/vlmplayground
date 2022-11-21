package com.vlmplayground.core.domain.bulletinboard

import com.vlmplayground.core.data.repository.BulletinRepository
import com.vlmplayground.core.data.repository.OfflineFirstBulletinRepository
import com.vlmplayground.core.network.firebase.FirebaseNetworkDataSource
import javax.inject.Inject

class GetBulletinUseCase
@Inject
constructor(
    private val bulletinRepository : BulletinRepository
)
{
//    operator fun invoke() = bulletinRepository.getBulletinStream()
    operator fun invoke() = bulletinRepository.getaBulletinStream()
}