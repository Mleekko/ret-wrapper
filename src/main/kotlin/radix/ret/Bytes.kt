package radix.ret

class Bytes {
    companion object {
        @OptIn(ExperimentalUnsignedTypes::class)
        fun getBytes(hex: String): List<UByte> {
            val bytes = UByteArray(hex.length / 2);

            for (i in 0 until hex.length / 2) {
                val idx = i * 2
                val s = hex.substring(idx, idx + 2)
                bytes[i] = s.toUByte(16)
            }
            return bytes.asList()
        }
    }

}
