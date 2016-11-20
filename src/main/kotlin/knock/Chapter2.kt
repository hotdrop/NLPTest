package knock

import java.io.File

/**
 * 第2章: UNIXコマンドの基礎
 */
class Chapter2 {

    val filePath = System.getProperty("user.dir") + "/src/main/resources/hightemp.txt"

    /**
     * 行数をカウントせよ．
     */
    fun Question10() {
        val source = File(filePath).readText(Charsets.UTF_8)
        println("10. answer=" + source.lines().size)
    }
    
}