import java.util.Scanner

class MenuOpenNote(private val arhiveId: Int) : Screen {

    override fun open() {
        val scaner = Scanner(System.`in`)
        while (true) {
            println("_____Меню_____")
            println("1. Создать заметку")
            println("2. Выбрать заметку")
            println("3. Назад")
            println("--------------")
            val line = scaner.nextLine()
            if (!line.isNullOrEmpty() && line.isDigit()) {
                when (line.toInt()) {
                    1 -> createTextNote()
                    2 -> Navigator.open(MenuOpenTextNote(arhiveId))
                    3 -> Navigator.goBack()
                    else -> println("Введите число от 1 до 3")
                }
            } else {
                println("Введите число!")
            }
        }
    }

    private fun createTextNote() {
        val scaner = Scanner(System.`in`)
        val index = arhiveId
        while (true) {
            println("Введите название заметки")
            val name = scaner.nextLine()
            if (!name.isNullOrEmpty()) {
                while (true) {
                    println("Введите текст заметки")
                    val text = scaner.nextLine()
                    if (!text.isNullOrEmpty()) {
                        Storage.addToArhive(index, name, text)
                        println("Заметка $name добавлена в архив")
                        break
                    } else {
                        println("Заметка не может не иметь текст")
                    }
                }
                break
            } else {
                println("Заметка не может не иметь названия")
            }
        }
    }
}