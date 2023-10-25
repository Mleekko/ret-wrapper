package radix.ret

import org.junit.Test
import kotlin.test.assertEquals

class SborDecoderTest {

    @Test
    fun testDecode() {
        val decoder = SborDecoder()
        val res = decoder.decode("5c21022200000c116465706f7369746f725f75706461746572", 2)
        assertEquals(
            "{\"kind\":\"Tuple\",\"fields\":[{\"kind\":\"Enum\",\"variant_id\":\"0\",\"fields\":[]}" +
                    ",{\"kind\":\"String\",\"value\":\"depositor_updater\"}]}", res
        )

        assertEquals("{\"kind\":\"Tuple\",\"fields\":[{\"kind\":\"Reference\",\"value\":" +
                "\"component_tdx_2_1cqjyxut4jylsfnqr0799xuec76haccmyj5hfpkq68qx3c8rzrad9vg\"}," +
                "{\"kind\":\"String\",\"value\":\"do_mint\"},{\"kind\":\"String\",\"value\":\"abort_mint\"}," +
                "{\"kind\":\"Enum\",\"variant_id\":\"0\",\"fields\":[]},{\"kind\":\"Decimal\",\"value\":\"0\"}," +
                "{\"kind\":\"U32\",\"value\":\"1\"}]}",
            decoder.decode("5c210680c024437175913f04cc037f8a537338f6afdc6364952e90d81a380d1c1c620c07646f5f6d696e740c0a61626f72745f6d696e74220000a00000000000000000000000000000000000000000000000000901000000", 2)
        )

        assertEquals("{\"kind\":\"Tuple\",\"fields\":[{\"kind\":\"Reference\",\"value\":" +
                "\"component_tdx_2_1cqmlqduxqcpj3xxtuvr2x4p924chqrsnwcvd7nhnl22t9v4wty0uz3\"}," +
                "{\"kind\":\"String\",\"value\":\"assign_loot\"},{\"kind\":\"String\",\"value\":\"reverse_reveal\"}," +
                "{\"kind\":\"Enum\",\"variant_id\":\"1\",\"fields\":[{\"kind\":\"Reference\",\"value\":" +
                "\"resource_tdx_2_1t462h2zj25t9h58pxzqu3utkker8p4sc6xzk6tl69k7l387qrk7fyd\"}]}," +
                "{\"kind\":\"Decimal\",\"value\":\"1\"},{\"kind\":\"U32\",\"value\":\"2\"}]}",
            decoder.decode("5c210680c037f0378606032898cbe306a354255571700e137618df4ef3fa94b2b2ae0c0b61737369676e5f6c6f6f740c0e726576657273655f72657665616c220101805d74aba85255165bd0e13081c8f176b64670d618d1856d2ffa2dbdf89fc0a0000064a7b3b6e00d000000000000000000000000000000000902000000", 2)
        )

        assertEquals("{\"kind\":\"U32\",\"value\":\"4294967295\"}",
            decoder.decode("5c09ffffffff", 2)
        )
    }
}
