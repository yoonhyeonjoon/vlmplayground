package com.vlmplayground.core.feature.bulletin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vlmplayground.core.data.repository.BulletinRepository
import com.vlmplayground.core.domain.bulletinboard.SyncBulletinBoardUseCase
import com.vlmplayground.core.domain.bulletinboard.UploadBulletinUseCase
import com.vlmplayground.core.model.data.Bulletin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BulletinViewModel @Inject constructor(
    private val bulletinRepository : BulletinRepository,
    private val getBulletinStream : SyncBulletinBoardUseCase,
    private val uploadBulletinUseCase : UploadBulletinUseCase

) : ViewModel() {

    fun bulletinBoardInitializing() {
        viewModelScope.launch {
            getBulletinStream().collect()
        }
    }

    fun bulletinUploading(newBulletin : Bulletin) {
        viewModelScope.launch { uploadBulletinUseCase(newBulletin)
            val process1 = 1
        }
    }

}