package radix.ret

import com.radixdlt.ret.SerializationMode
import com.radixdlt.ret.scryptoSborDecodeToStringRepresentation

class SborDecoder {

    fun decode(hex: String, networkId: Int): String {
        return scryptoSborDecodeToStringRepresentation(
            Bytes.getBytes(hex),
            SerializationMode.PROGRAMMATIC,
            networkId = networkId.toUByte(),
            schema = null
        )
    }


}
