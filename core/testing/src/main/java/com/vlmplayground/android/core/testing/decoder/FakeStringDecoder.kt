
package com.vlmplayground.android.core.testing.decoder


import com.vlmplayground.android.core.decoder.StringDecoder
import javax.inject.Inject

class FakeStringDecoder @Inject constructor() : StringDecoder {
    override fun decodeString(encodedString: String): String = encodedString
}
