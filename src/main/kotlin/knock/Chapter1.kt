package knock

import utility.Ngram
import java.util.*

/**
 * 第1章: 準備運動
 */
class Chapter1 {

    /**
     * 文字列の逆順
     * 文字列"stressed"の文字を逆に（末尾から先頭に向かって）並べた文字列を得よ
     */
    fun Question0() {
        val questionStr = "stressed"
        println("00. answer=" + questionStr.reversed())
    }

    /**
     * 「パタトクカシーー」
     * 「パタトクカシーー」という文字列の1,3,5,7文字目を取り出して連結した文字列を得よ
     */
    fun Question1() {

        fun String.intervalSubstring(interval: Int): String {
            var retStr = ""
            (0..this.length - 1)
                    .filter { it %interval == 0 && it %interval <= this.length - 1 }
                    .forEach { retStr += this[it] }
            return retStr
        }

        val questionStr = "パタトクカシーー"
        println("01. answer=" + questionStr.intervalSubstring(2))
    }

    /**
     * 「パトカー」＋「タクシー」＝「パタトクカシーー」
     * 「パトカー」＋「タクシー」の文字を先頭から交互に連結して文字列「パタトクカシーー」を得よ
     */
    fun Question2() {

        fun String.union(afterStr: String): String {
            val unionLength = if(this.length <= afterStr.length) this.length else afterStr.length
            var sb = StringBuilder()
            for(i in 0..unionLength - 1) {
                sb.append(this[i])
                sb.append(afterStr[i])
            }
            when {
                this.length > afterStr.length -> sb.append(this.substring(unionLength))
                this.length < afterStr.length -> sb.append(afterStr.substring(unionLength))
            }
            return sb.toString()
        }

        val questionStr = "パトカー"
        println("02. answer=" + questionStr.union("タクシー"))
    }

    /**
     * 円周率
     * "Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics."
     * という文を単語に分解し，各単語の（アルファベットの）文字数を先頭から出現順に並べたリストを作成せよ
     */
    fun Question3() {
        val questionStr = "Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics."
        val wordList = questionStr.replace(",", "").replace(".", "").split(" ")
        val answerList = wordList.map(String::length)
        println("03. answer=" + answerList)
    }

    /**
     * 元素記号
     * "Hi He Lied Because Boron Could Not Oxidize Fluorine.
     *  New Nations Might Also Sign Peace Security Clause.
     *  Arthur King Can."
     *  という文を単語に分解し，1, 5, 6, 7, 8, 9, 15, 16, 19番目の単語は先頭の1文字
     *  それ以外の単語は先頭の2文字を取り出し，取り出した文字列から単語の位置（先頭から何番目の単語か）への
     *  連想配列（辞書型もしくはマップ型）を作成せよ
     */
    fun Question4() {
        val oneCharIndexList = listOf(1, 5, 6, 7, 8, 9, 15, 16, 19)
        val questionStr = "Hi He Lied Because Boron Could Not Oxidize Fluorine. " +
                "New Nations Might Also Sign Peace Security Clause. Arthur King Can."

        val wordList = questionStr.replace(".", "").split(" ")
        var answerMap = mutableMapOf<String, Int>()

        for(i in 1..wordList.size) {
            when(i) {
                in oneCharIndexList -> answerMap.put(wordList[i-1].take(1), i)
                else -> answerMap.put(wordList[i-1].take(2), i)
            }
        }
        println("04. answer=" + answerMap.keys)
    }

    /**
     * n-gram
     * 与えられたシーケンス（文字列やリストなど）からn-gramを作る関数を作成せよ.
     * この関数を用い"I am an NLPer"という文から単語bi-gram，文字bi-gramを得よ.
     */
    fun Question5() {
        val questionStr = "I am an NLPer"
        val biGram = Ngram(2)
        println("05. answer ")
        println("  word bi-gram= " + biGram.makeWord(questionStr.split(" ")))
        println("  char bi-gram= " + biGram.makeChar(questionStr))
    }

    /**
     * 集合
     * "paraparaparadise"と"paragraph"に含まれる文字bi-gramの集合を
     * それぞれ, XとYとして求め，XとYの和集合，積集合，差集合を求めよ.
     * さらに，'se'というbi-gramがXおよびYに含まれるかどうかを調べよ．
     */
    fun Question6() {
        val biGram = Ngram(2)
        val xGram = biGram.makeChar("paraparaparadise")
        val yGram = biGram.makeChar("paragraph")

        println("06. answer ")
        // 和集合
        val mutableXGram = xGram.toMutableList().addAll(yGram)
        println("  union X and Y = " + mutableXGram)
        // 積集合
        println("  intersection X and Y = " + xGram.filter { x -> yGram.contains(x) })
        // 差集合
        println("  difference set X and Y = " + xGram.filterNot { x -> yGram.contains(x) })
        println("  se contains X bi-gram = " + xGram.contains("se"))
        println("  se contains Y bi-gram = " + yGram.contains("se"))

    }

    /**
     * テンプレートによる文生成
     * 引数x, y, zを受け取り「x時のyはz」という文字列を返す関数を実装せよ.
     * さらに，x=12, y="気温", z=22.4として，実行結果を確認せよ
     */
    fun Question7() {

        fun template(x: Any, y: Any, z: Any): String {
            return x.toString() + "時の" + y.toString() + "は" + z.toString()
        }

        println("07. answer=" + template(12, "気温", 22.4))

    }

    /**
     * 暗号文
     * 与えられた文字列の各文字を，以下の仕様で変換する関数cipherを実装せよ．
     *   英小文字ならば(219 - 文字コード)の文字に置換
     *   その他の文字はそのまま出力
     * この関数を用い，英語のメッセージを暗号化・復号化せよ．
     */
    fun Question8() {

        fun cipher(target: String): String {
            return target.toList()
                    .map { c -> if(c >= 'a' && c <= 'z') c.plus(219 - (c.toByte() * 2)) else c }
                    .joinToString(separator = "")
        }

        val originalStr = "This is a Pen."
        println("08. answer. Original string=" + originalStr)
        val encryptionStr = cipher(originalStr)
        println("  Encryption string = " + encryptionStr)
        println("  Decryption string = " + cipher(encryptionStr))
    }

    /**
     * Typoglycemia
     * スペースで区切られた単語列に対して，各単語の先頭と末尾の文字は残し
     * それ以外の文字の順序をランダムに並び替えるプログラムを作成せよ．
     * ただし，長さが４以下の単語は並び替えないこととする．
     * 適当な英語の文（例えば"I couldn't believe that I could actually understand
     *                     what I was reading : the phenomenal power of the human mind ."）
     * を与え，その実行結果を確認せよ．
     */
    fun Question9() {

        fun randSort(target: String): String {

            if(target.length <= 4) {
                return target
            }

            val charMap = mutableMapOf<Int, Char>()
            val rand = Random()

            target.toList().forEachIndexed { index, c ->
                when(index) {
                    0 -> charMap.put(-1, c)
                    target.length - 1 -> charMap.put(100, c)
                    else -> charMap.put(rand.nextInt(99), c)
                }
            }

            val results = charMap.toSortedMap().values
            return results.joinToString(separator = "")
        }

        val originalStr = "I couldn't believe that I could actually understand what I was reading : the phenomenal power of the human mind ."
        val resultList = originalStr.split(" ").map(::randSort)
        // TODO Sometimes one character disappears.. why?
        println("09. answer. ")
        println("  Original string= " + originalStr)
        println("      Make string= " + resultList.joinToString(separator = " "))
    }
}