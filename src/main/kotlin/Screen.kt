import java.util.Scanner

abstract class Screen {

    private val scanner = Scanner(System.`in`)
    abstract fun open()

    abstract fun create()

    fun getInputInt(): Int {
        val line = scanner.nextLine()
        return if (!line.isNullOrBlank() && line.isDigit()) {
            line.toInt()
        } else {
            -1
        }
    }

    fun getinputString(): String? {
        val line = scanner.nextLine()
        return if (!line.isNullOrBlank()) {
            line
        } else {
            null
        }
    }
}
