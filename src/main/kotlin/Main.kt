fun compressRuns(input: String): String {
    if (input.isEmpty()) return ""
    val sb = StringBuilder()
    var current = input[0]
    var count = 1
    for (i in 1 until input.length){
        val ch = input[i]
        if (ch == current){ count++
        }else{
            sb.append(current)
            if (count>1)
                sb.append(count)
            current = ch
            count = 1
        }
    }
    sb.append(current)
    if (count>1) sb.append(count)
    return sb.toString()
} fun main(){
    val input = "AAADSSSRRTTHAAAA"
    val result = compressRuns(input)
    println(result)
}