package knock

import org.junit.Assert
import org.junit.Test

class Chapter1Test {

    @Test
    fun TestQuestion1() {
        val prob = Chapter1()
        Assert.assertEquals("パトカー", prob.Question1())
    }


}