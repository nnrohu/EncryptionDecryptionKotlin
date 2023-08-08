package encryptdecrypt

fun main() {
    //('z' - (ch - 'a'))
    var str = "abcdefghijklmnopqrstuvwxyz".toCharArray()

    val input = readln()
    val key = readln().toInt()
    var encrypt = ""
    input.forEach {   ch ->
        if(str.contains(ch)) {
          val eIndex =  ( str.indexOf(ch) + key ) % 26
            encrypt += str[eIndex]
        }
       else encrypt+=ch
     }
    println(encrypt)
}