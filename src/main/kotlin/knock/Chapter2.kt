package knock

import java.io.File
import java.nio.charset.Charset

/**
 * 第2章: UNIXコマンドの基礎
 */
class Chapter2 {

    val filePath = System.getProperty("user.dir") + "/src/main/resources/hightemp.txt"

    /**
     * 行数のカウント
     * 行数をカウントせよ．
     */
    fun Question10() {
        val readText = File(filePath).readText(Charsets.UTF_8)
        println("10. answer=" + readText.lines().size)
    }

    /**
     * タブをスペースに置換
     * タブ1文字につきスペース1文字に置換せよ
     */
    fun Question11() {
        println("11. answer ")
        File(filePath).absoluteFile.forEachLine {println("  " + it.replace("\t", " "))}
    }
}