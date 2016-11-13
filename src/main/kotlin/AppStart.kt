import knock.Chapter1

fun main(args: Array<String>) {
    runChapter1()
}

private fun runChapter1() {
    val test = Chapter1()
    println("00. answer=" + test.Question0())
    println("01. answer=" + test.Question1())
    println("02. answer=" + test.Question2())
    println("03. answer=" + test.Question3())
}