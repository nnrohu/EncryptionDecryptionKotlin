package encryptdecrypt

fun main() {
    //('z' - (ch - 'a'))
    var str = "we found a treasure!"
    str.forEach {   ch ->
        if(ch == ' ' || ch == '!') print( ch)
       else  print(('z' - (ch - 'a')))
     }
}