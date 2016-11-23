package utility

class Ngram(n: Int) {

    val n: Int = n

    fun makeWord(wordList: List<String>): List<String> {
        val end = wordList.size - n
        var retList: MutableList<String> = mutableListOf()
        // TODO I feel wrong..umm
        (0..end).mapTo(retList) { wordList[it] + ":" + wordList[it +n-1] }
        return retList
    }

    fun makeChar(str: String): List<String> {
        val end = str.length - n
        var retList: MutableList<String> = mutableListOf()
        (0..end).mapTo(retList) { str.substring(it, it +n) }
        return retList
    }
}