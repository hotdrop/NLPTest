package knock

import utility.KnockString

/**
 * 問題クラス
 */
class Chapter1 {

    /**
     * 文字列"stressed"の文字を逆に（末尾から先頭に向かって）並べた文字列を得よ
     */
    fun Question0(): String {
        return "stressed".reversed()
    }

    /**
     * パタトクカシーー」という文字列の1,3,5,7文字目を取り出して連結した文字列を得よ
     */
    fun Question1(): String {
        val kStr = KnockString("パタトクカシーー")
        return kStr.intervalSubstring(2)
    }

    /**
     * 「パトカー」＋「タクシー」の文字を先頭から交互に連結して文字列「パタトクカシーー」を得よ
     */
    fun Question2(): String {
        val kStr = KnockString("パトカー")
        return kStr.union("タクシー")
    }

    /**
     * "Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics."
     * という文を単語に分解し，各単語の（アルファベットの）文字数を先頭から出現順に並べたリストを作成せよ
     */
    fun Question3(): List<Int> {
        val questionStr = "Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics."
        val wordList = questionStr.replace(",", "").replace(".", "").split(" ")
        return wordList.map(String::length)
    }

    /**
     * "Hi He Lied Because Boron Could Not Oxidize Fluorine.
     *  New Nations Might Also Sign Peace Security Clause.
     *  Arthur King Can."
     *  という文を単語に分解し，1, 5, 6, 7, 8, 9, 15, 16, 19番目の単語は先頭の1文字
     *  それ以外の単語は先頭の2文字を取り出し，取り出した文字列から単語の位置（先頭から何番目の単語か）への
     *  連想配列（辞書型もしくはマップ型）を作成せよ
     */
    fun Question4(): Map<String, Int> {
        val oneCharIndexList = listOf(1, 5, 6, 7, 8, 9, 15, 16, 19)
        val questionStr = "Hi He Lied Because Boron Could Not Oxidize Fluorine. New Nations Might Also Sign Peace Security Clause. Arthur King Can."

        val wordList = questionStr.replace(".", "").split(" ")
        var retMap = mutableMapOf<String, Int>()

        for(i in 1..wordList.size) {
            when(i) {
                in oneCharIndexList -> retMap.put(wordList[i-1].take(1), i)
                else -> retMap.put(wordList[i-1].take(2), i)
            }
        }
        return retMap
    }
}