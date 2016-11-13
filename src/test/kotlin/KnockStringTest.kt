import org.junit.Assert
import org.junit.Test
import utility.KnockString

class KnockStringTest {

    @Test
    fun intervalSubstringTest() {
        val test1 = KnockString("abcde")
        Assert.assertEquals("abcde", test1.intervalSubstring(1))
        Assert.assertEquals("ace", test1.intervalSubstring(2))
        Assert.assertEquals("ad", test1.intervalSubstring(3))
    }

    @Test
    fun unionTest() {
        val test1 = KnockString("abcde")
        Assert.assertEquals("atbecde", test1.union("te"))
        Assert.assertEquals("aabbccddee", test1.union("abcde"))
        Assert.assertEquals("aabbccddeefg", test1.union("abcdefg"))
    }
}