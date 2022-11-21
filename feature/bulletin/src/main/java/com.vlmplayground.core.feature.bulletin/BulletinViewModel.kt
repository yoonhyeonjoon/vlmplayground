package com.vlmplayground.core.feature.bulletin

import androidx.lifecycle.ViewModel
import com.vlmplayground.core.data.repository.BulletinRepository
import com.vlmplayground.core.domain.bulletinboard.GetBulletinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BulletinViewModel @Inject constructor(
    private val bulletinRepository : BulletinRepository,
    private val getBulletinStream : GetBulletinUseCase
) : ViewModel() {

    val getState = getBulletinStream()
    val ff = 1
}