package com.vlmplayground.core.domain.bulletinboard

import com.vlmplayground.core.data.repository.BulletinRepository
import javax.inject.Inject

class SyncBulletinBoardUseCase
@Inject
constructor(
    private val bulletinRepository : BulletinRepository
)
{
    operator fun invoke() = bulletinRepository.syncBulletinBoard()
}