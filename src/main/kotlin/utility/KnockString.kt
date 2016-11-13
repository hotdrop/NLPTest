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
        var retStr = ""
        for(i in 0..str.length - 1) {
            if(i%interval == 0 && i%interval <= str.length - 1) {
                retStr += str[i]
            }
        }
        return retStr
    }

    fun union(afterStr: String): String {
        var sb = StringBuilder()
        val unionLength = if(str.length <= afterStr.length) str.length else afterStr.length

        for(i in 0..unionLength - 1) {
            sb.append(str[i])
            sb.append(afterStr[i])
        }

        when {
            str.length > afterStr.length -> sb.append(str.substring(unionLength))
            str.length < afterStr.length -> sb.append(afterStr.substring(unionLength))
        }

        return sb.toString()
    }
}
