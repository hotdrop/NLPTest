import knock.Chapter1

fun main(args: Array<String>) {
    runChapter1()
}

private fun runChapter1() {
    val test = Chapter1()
    print("00. answer=" + test.Question0())
    print("01. answer=" + test.Question1())
    print("02. answer=" + test.Question1())
}