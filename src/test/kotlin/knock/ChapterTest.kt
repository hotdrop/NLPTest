package knock

import org.junit.Test

class ChapterTest {

    @Test
    fun TestQuestion() {
        val prob = Chapter2()
        prob.Question18()
    }

    @Test
    fun TestQuestion14() {
        val prob = Chapter2()
        prob.Question14(1)
        prob.Question14(5)
        prob.Question14(10)
    }

    @Test
    fun TestQuestion15() {
        val prob = Chapter2()
        prob.Question15(1)
        prob.Question15(5)
        prob.Question15(10)
    }

    @Test
    fun TestQuestion16() {
        val prob = Chapter2()
        prob.Question16(1)
        prob.Question16(2)
        prob.Question16(12)
    }
}