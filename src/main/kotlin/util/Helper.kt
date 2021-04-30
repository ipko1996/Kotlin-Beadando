package util

import java.lang.NumberFormatException

fun getNumber(str: String): Int {
    print("$str: ")
    val number = readLine()
    return try {
        number?.toInt() ?: -1
    }catch (e: NumberFormatException){
        print("Only numbers allowed!: ")
        getNumber(str)
    }
}

fun getString(str: String): String {
    print("$str: ")
    val result = readLine()
    return result ?: ""
}
