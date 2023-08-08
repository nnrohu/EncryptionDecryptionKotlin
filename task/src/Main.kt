package encryptdecrypt


fun main(args: Array<String>) {

    var mode = "enc"
    var key = 0
    var data = ""
    mode = args[args.indexOf("-mode") + 1]
    key = args[args.indexOf("-key") + 1].toInt()
    data = args[args.indexOf("-data") + 1]

    when (mode) {
        "enc" -> enc(data, key)
        "dec" -> dec(data, key)
    }
}

fun enc(input: String, key: Int) {
    var encrypt = ""
    input.forEach { ch ->
        val eChar = ch.code + key
        encrypt += Char(eChar)
    }
    println(encrypt)
}

fun dec(input: String, key: Int) {
    var decrypt = ""
    input.forEach { ch ->
        val eChar = ch.code - key
        decrypt += Char(eChar)
    }
    println(decrypt)
}