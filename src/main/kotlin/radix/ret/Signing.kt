package radix.ret

import com.radixdlt.ret.*

class Signing {
    companion object {
        fun newSecp256k1(hex: String): PrivateKey {
            return PrivateKey.newSecp256k1(Bytes.getBytes(hex))
        }
        fun newEd25519(hex: String): PrivateKey {
            return PrivateKey.newEd25519(Bytes.getBytes(hex))
        }

        fun deriveVirtualAccountAddress(publicKey: PublicKey, networkId: Int): Address {
            return deriveVirtualAccountAddressFromPublicKey(publicKey, networkId.toUByte())
        }

        fun address(bech: String): Address {
            return Address(bech)
        }


    }
}
