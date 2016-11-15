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
    fun intersection() {
        val test1 = listOf("1", "4", "3", "7")
        val test2 = listOf("1", "2", "5", "3")
        println(test1.filterNot { x -> test2.contains(x) })
    }

}