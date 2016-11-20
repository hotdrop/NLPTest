package knock

import org.junit.Test

class ChapterTest {

    @Test
    fun TestQuestion() {
        val prob = Chapter2()
        prob.Question13()
    }

    @Test
    fun TestQuestion14() {
        val prob = Chapter2()
        prob.Question14(1)
        prob.Question14(5)
        prob.Question14(10)
    }
}