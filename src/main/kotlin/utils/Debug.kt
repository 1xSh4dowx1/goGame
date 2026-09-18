package utils

inline fun errorLogs(code: () -> Unit) {
    try {
        code()
    } catch (e: Exception) {
        println(e)
    }
}
