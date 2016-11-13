package utility

/**
 * String for knock question
 */
class KnockString(targetStr: String) {

    val str: String = targetStr

    /**
     * Acquire String at specified intervals
     * e.x "abcde" interval 1 = "abcde"
     *     "abcde" interval 2 = "ace"
     *     "abcde" interval 3 = "ad"
     */
    fun intervalSubstring(interval: Int): String {
        var returnStr = ""
        for(i in 0..str.length - 1) {
            if(i%interval == 0 && i%interval <= str.length - 1) {
                returnStr += str[i]
            }
        }
        return returnStr
    }
}
