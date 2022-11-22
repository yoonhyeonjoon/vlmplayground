package com.vlmplayground.core.domain.bulletinboard

import com.vlmplayground.core.data.repository.BulletinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBulletinUseCase
@Inject
constructor(
    private val bulletinRepository : BulletinRepository
)
{
    operator fun invoke() = bulletinRepository.syncBulletinBoard()
}