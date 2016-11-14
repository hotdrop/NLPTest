package utility

class Ngram(n: Int) {

    val n: Int = n

    fun makeWord(wordList: List<String>): List<String> {
        val end = wordList.size - n
        var retList: MutableList<String> = mutableListOf()
        for(i in 0..end) {
            retList.add(wordList[i] + ":" + wordList[i+n-1])
        }
        return retList
    }

    fun makeChar(str: String): List<String> {
        val end = str.length - n
        var retList: MutableList<String> = mutableListOf()
        for(i in 0..end) {
            retList.add(str.substring(i, i+n))
        }
        return retList
    }
}