package knock

import utility.KnockString
import utility.Ngram

/**
 * 第1章: 準備運動
 */
class Chapter1 {

    fun run() {
        Question0()
        Question1()
        Question2()
        Question3()
        Question4()
        Question5()
        Question6()
    }

    /**
     * 文字列の逆順
     * 文字列"stressed"の文字を逆に（末尾から先頭に向かって）並べた文字列を得よ
     */
    fun Question0() {
        println("00. answer=" + "stressed".reversed())
    }

    /**
     * 「パタトクカシーー」
     * 「パタトクカシーー」という文字列の1,3,5,7文字目を取り出して連結した文字列を得よ
     */
    fun Question1() {
        val kStr = KnockString("パタトクカシーー")
        println("01. answer=" + kStr.intervalSubstring(2))
    }

    /**
     * 「パトカー」＋「タクシー」＝「パタトクカシーー」
     * 「パトカー」＋「タクシー」の文字を先頭から交互に連結して文字列「パタトクカシーー」を得よ
     */
    fun Question2() {
        val kStr = KnockString("パトカー")
        println("02. answer=" + kStr.union("タクシー"))
    }

    /**
     * 円周率
     * "Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics."
     * という文を単語に分解し，各単語の（アルファベットの）文字数を先頭から出現順に並べたリストを作成せよ
     */
    fun Question3() {
        val questionStr = "Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics."
        val wordList = questionStr.replace(",", "").replace(".", "").split(" ")
        println("03. answer=" + wordList.map(String::length))
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
        var answer = mutableMapOf<String, Int>()

        for(i in 1..wordList.size) {
            when(i) {
                in oneCharIndexList -> answer.put(wordList[i-1].take(1), i)
                else -> answer.put(wordList[i-1].take(2), i)
            }
        }
        println("04. answer=" + answer.keys)
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

    }

    /**
     * 暗号文
     * 与えられた文字列の各文字を，以下の仕様で変換する関数cipherを実装せよ．
     *   英小文字ならば(219 - 文字コード)の文字に置換
     *   その他の文字はそのまま出力
     * この関数を用い，英語のメッセージを暗号化・復号化せよ．
     */
    fun Question8() {

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

    }
}