package com.vlmplayground.core.domain.bulletinboard

import com.vlmplayground.core.data.repository.BulletinRepository
import com.vlmplayground.core.model.data.Bulletin
import javax.inject.Inject

class UploadBulletinUseCase
@Inject
constructor(
    private val bulletinRepository : BulletinRepository
)
{
    suspend operator fun invoke(newBulletin : Bulletin) {
        bulletinRepository.uploadToBulletinBoard(newBulletin)
    }
}