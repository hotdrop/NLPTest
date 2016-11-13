package knock

import org.junit.Assert
import org.junit.Test

class Chapter1Test {

    @Test
    fun TestQuestion1() {
        val prob = Chapter1()
        Assert.assertEquals("パトカー", prob.Question1())
    }

    @Test
    fun TestQuestion2() {
        val prob = Chapter1()
        Assert.assertEquals("パタトクカシーー", prob.Question2())
    }

    @Test
    fun TestQuestion3() {
        val prob = Chapter1()
        val answer = listOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9)
        Assert.assertEquals(answer, prob.Question3())
    }
}