package encryptdecrypt

fun main() {
    val type = readln()
    val input = readln()
    val key = readln().toInt()
    when(type){
        "enc" -> enc(input,key)
        "dec" -> dec(input,key)
    }
}

fun enc(input: String, key: Int) {
    var encrypt = ""
    input.forEach {   ch ->
       val eChar = ch.code + key
        encrypt+= Char(eChar)
    }
    println(encrypt)
}
 fun dec(input: String, key: Int) {
     var decrypt = ""
     input.forEach {   ch ->
         val eChar = ch.code - key
         decrypt+= Char(eChar)
     }
     println(decrypt)
 }