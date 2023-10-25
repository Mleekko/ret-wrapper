package radix.ret

import com.radixdlt.ret.SerializationMode
import com.radixdlt.ret.scryptoSborDecodeToStringRepresentation

class SborDecoder {

    fun decode(hex: String, networkId: Int): String {
        return scryptoSborDecodeToStringRepresentation(
            getBytes(hex),
            SerializationMode.PROGRAMMATIC,
            networkId = networkId.toUByte(),
            schema = null
        )
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    private fun getBytes(hex: String): List<UByte> {
        val bytes = UByteArray(hex.length / 2);

        for (i in 0 until hex.length / 2) {
            val idx = i * 2
            val s = hex.substring(idx, idx + 2)
            bytes[i] = s.toUByte(16)
        }
        return bytes.asList()
    }
}
