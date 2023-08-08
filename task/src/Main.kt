package encryptdecrypt

import java.io.File

fun main(args: Array<String>) {
    var inputFile: String? = null
    var outputFile: String? = null
    var mode = "enc"
    var key = 0
    var data = ""

    for (i in args.indices step 2) {
        when (args[i]) {
            "-mode" -> mode = args[i + 1]
            "-key" -> key = args[i + 1].toInt()
            "-data" -> data = args[i + 1]
            "-in" -> inputFile = args[i + 1]
            "-out" -> outputFile = args[i + 1]
        }
    }

    val inputText = if (inputFile != null) {
        try {
            File(inputFile).readText()
        } catch (e: Exception) {
            println("Error: Input file not found or could not be read.")
            return
        }
    } else {
        data
    }

    val result = when (mode) {
        "enc" -> enc(inputText, key)
        "dec" -> dec(inputText, key)
        else -> {
            println("Error: Invalid mode specified.")
            return
        }
    }

    if (outputFile != null) {
        try {
            File(outputFile).writeText(result)
        } catch (e: Exception) {
            println("Error: Output file could not be written.")
        }
    } else {
        println(result)
    }
}

fun enc(input: String, key: Int): String {
    return input.map { ch -> (ch.toInt() + key).toChar() }.joinToString("")
}

fun dec(input: String, key: Int): String {
    return input.map { ch -> (ch.toInt() - key).toChar() }.joinToString("")
}