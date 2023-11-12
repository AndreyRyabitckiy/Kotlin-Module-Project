import java.util.Scanner

class MenuOpenTextNote(private val arhiveId: Int) : Screen {

    override fun open() {
        val scaner = Scanner(System.`in`)
        while (true) {
            println("_____Меню_____")
            println("1. Список заметок")
            println("2. Текст заметки")
            println("3. Назад")
            println("--------------")
            val line = scaner.nextLine()
            if (!line.isNullOrEmpty() && line.isDigit()) {
                when (line.toInt()) {
                    1 -> listTextNote()
                    2 -> openText()
                    3 -> Navigator.goBack()
                    else -> println("Введите число от 1 до 3")
                }
            } else {
                println("Введите число!")
            }
        }
    }

    private fun listTextNote() {

        val arhiveIndex = arhiveId

        val noteIn = Storage.noteInArhive(arhiveIndex)
        println("Список заметок:")
        for (i in noteIn.indices) {
            println("$i. ${noteIn[i]}")
        }
    }

    private fun openText() {

        val textIndex = Storage.getNotesSize(arhiveId)
        val arhiveIndex = arhiveId
        val scaner = Scanner(System.`in`)
        while (true) {
            println("Введите номер заметки")
            val line = scaner.nextLine()
            if (!line.isNullOrEmpty() && line.isDigit()) {
                val answer = line.toInt()
                if (answer >= 0 && answer <= textIndex) {
                    val note = Storage.textInNote(arhiveIndex, answer)
                    println("Текст в заметке: $note")
                    break
                } else {
                    println("Введите число от 0 до ${textIndex - 1}")
                }
            } else {
                println("Введите число!")
            }
        }
    }
}