package radix.ret

import com.radixdlt.ret.*

class Manifest {
    companion object {
        @JvmStatic
        fun build(builder: ManifestBuilder, networkId: Int): TransactionManifest {
            return builder.build(networkId.toUByte())
        }

        @JvmStatic
        fun header(
            networkId: Int, startEpoch: Long, endEpoch: Long, nonce: Int, notaryPublicKey: PublicKey,
            notaryIsSignatory: Boolean, tipPercentage: Short
        ): TransactionHeader {
            return TransactionHeader(
                networkId.toUByte(),
                startEpoch.toULong(),
                endEpoch.toULong(),
                nonce.toUInt(),
                notaryPublicKey,
                notaryIsSignatory,
                tipPercentage.toUShort()
            )
        }

    }

    object Value {
        @JvmStatic
        fun u8(value: Byte): ManifestBuilderValue {
            return ManifestBuilderValue.U8Value(value.toUByte())
        }

        @JvmStatic
        fun u16(value: Short): ManifestBuilderValue {
            return ManifestBuilderValue.U16Value(value.toUShort())
        }

        @JvmStatic
        fun u32(value: Int): ManifestBuilderValue {
            return ManifestBuilderValue.U32Value(value.toUInt())
        }

        @JvmStatic
        fun u64(value: Long): ManifestBuilderValue {
            return ManifestBuilderValue.U64Value(value.toULong())
        }
        @JvmStatic
        fun decimal(value: String): ManifestBuilderValue {
            return ManifestBuilderValue.DecimalValue(Decimal(value))
        }
        @JvmStatic
        fun address(value: String): ManifestBuilderValue {
            return ManifestBuilderValue.AddressValue(ManifestBuilderAddress.Static(Address(value)))
        }
    }
}
