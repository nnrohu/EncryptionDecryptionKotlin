package encryptdecrypt

import java.io.File
import kotlin.math.abs

fun main(args: Array<String>) {

    val alg = args[args.indexOf("-alg") + 1]
    val mode = args[args.indexOf("-mode") + 1]
    val key = args[args.indexOf("-key") + 1].toInt()
    val inFileName = args[args.indexOf("-in") + 1]
    val outFileName = args[args.indexOf("-out") + 1]

    val inFile = File(inFileName)
    val inFileData = inFile.readText()

    val outFile = File(outFileName)

    if (alg == "unicode") {
        if (mode == "dec") outFile.writeText(getUnicodeDecrypt(inFileData, key))
        else outFile.writeText(getUnicodeEncrypt(inFileData, key))
    } else {
        if (mode == "dec") outFile.writeText(getShiftDecrypt(inFileData, key))
        else outFile.writeText(getShiftEncrypt(inFileData, key))
    }
}

fun getUnicodeEncrypt(data: String, key: Int): String {
    var result = ""
    data.forEach { result += it + key }
    return result
}

fun getUnicodeDecrypt(data: String, key: Int): String {
    var result = ""
    data.forEach { result += it - key }
    return result
}

fun getShiftEncrypt(data: String, key: Int): String {
    var result = ""
    val alphabet = "abcdefghijklmnopqrstuvwxyz".toList()
    data.forEach {
        result +=
            if (it.isLetter()) {
                if (alphabet.indexOf(it) + key > alphabet.size)
                    alphabet[abs(alphabet.size - (alphabet.indexOf(it) + key))]
                else alphabet[alphabet.indexOf(it) + key]
            } else it
    }
    return result
}

fun getShiftDecrypt(data: String, key: Int): String {
    var result = ""
    val alphabet = "abcdefghijklmnopqrstuvwxyz".toList()
    data.forEach {
        result +=
            if (it.isLetter()) {
                if (alphabet.indexOf(it) - key < 0)
                    alphabet[alphabet.size - abs(alphabet.indexOf(it) - key)]
                else alphabet[alphabet.indexOf(it) - key]
            } else it
    }
    return result
}





