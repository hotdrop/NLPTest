package knock

import java.io.File
import java.io.FileInputStream
import java.io.BufferedWriter

/**
 * 第2章: UNIXコマンドの基礎
 */
class Chapter2 {

    val filePath = System.getProperty("user.dir") + "/src/main/resources/hightemp.txt"

    fun BufferedWriter.writeLine(line : String) {
        this.write(line)
        this.newLine()
    }

    /**
     * 行数のカウント
     * 行数をカウントせよ．
     */
    fun Question10() {
        val readText = File(filePath).readText()
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

    // use question12 and question13
    val col1TextPath = System.getProperty("user.dir") + "/src/main/resources/col1.txt"
    val col2TextPath = System.getProperty("user.dir") + "/src/main/resources/col2.txt"

    /**
     * 1列目をcol1.txtに，2列目をcol2.txtに保存
     * 各行の1列目だけを抜き出したものをcol1.txtに,
     * 2列目だけを抜き出したものをcol2.txtとしてファイルに保存せよ.
     */
    fun Question12() {
        makeCol1AndCol2()
        if(!File(col1TextPath).exists() || !File(col2TextPath).exists()) {
            println("Question12 failed. not exist file. Please review the program")
        }
        println("12. answer ")
        println("  col1.txt ")
        File(col1TextPath).absoluteFile.forEachLine { println("    " + it) }
        println("  col2.txt ")
        File(col2TextPath).absoluteFile.forEachLine { println("    " + it) }
    }

    /**
     * col1.txtとcol2.txtをマージ
     * Question12で作ったcol1.txtとcol2.txtを結合し，元のファイルの1列目と2列目をタブ区切りで
     * 並べたテキストファイルを作成せよ
     */
    fun Question13() {
        makeCol1AndCol2()
        val col1TextLines = File(col1TextPath).readLines()
        val col2TextLines = File(col2TextPath).readLines()
        var unionList = mutableListOf<String>()
        col1TextLines.forEachIndexed { index, line ->
            if(index <= col2TextLines.size) {
                unionList.add(line + "\t" + col2TextLines[index])
            } else {
                unionList.add(line)
            }
        }

        val unionFilePath = System.getProperty("user.dir") + "/src/main/resources/unionCol1Col2.txt"
        File(unionFilePath).bufferedWriter().use { out ->
            unionList.forEach { out.writeLine(it) }
        }

        println("13. answer ")
        println("  col1.txt union col2.txt ")
        File(unionFilePath).absoluteFile.forEachLine { println("    " + it) }
    }

    private fun makeCol1AndCol2() {

        var col1Lines = mutableListOf<String>()
        var col2Lines = mutableListOf<String>()
        File(filePath).absoluteFile.forEachLine {
            val columns = it.replace("\t", " ").split(" ")
            col1Lines.add(columns[0])
            col2Lines.add(columns[1])
        }

        val col1TextFile = File(col1TextPath)
        if(col1TextFile.exists()) col1TextFile.delete()
        col1TextFile.bufferedWriter().use { out ->
            col1Lines.forEach { out.writeLine(it) }
        }

        val col2TextFile = File(col2TextPath)
        if(col2TextFile.exists()) col2TextFile.delete()
        col2TextFile.bufferedWriter().use { out ->
            col2Lines.forEach { out.writeLine(it) }
        }
    }


}