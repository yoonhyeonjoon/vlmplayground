package com.vlmplayground.core.data.repository.fake

import com.vlmplayground.android.core.network.Dispatcher
import com.vlmplayground.android.core.network.PlaygroundDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class FakeBulletinRepository @Inject constructor(
    @Dispatcher(PlaygroundDispatchers.IO) private val isDispatcher: CoroutineDispatcher
){
}