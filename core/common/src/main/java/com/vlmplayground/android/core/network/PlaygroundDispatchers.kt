
package com.vlmplayground.android.core.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME


@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val niaDispatcher: PlaygroundDispatchers)

enum class PlaygroundDispatchers {
    IO
}
