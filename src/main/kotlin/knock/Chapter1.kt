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
        val wordList = questionStr.split(" ")
        return wordList.map { w -> w.replace(",", "").replace(".", "").length }
    }

    
}