import java.util.Scanner

class MenuOpenNote(private val arhiveId: Int) : Screen {

    override fun open() {
        val scaner = Scanner(System.`in`)
        while (true) {
            val arhive = Storage.listArhive()
            println("\n---------------")
            val arhiveIndex = arhiveId
            val noteIn = Storage.noteInArhive(arhiveIndex)
            println("Список заметок:")
            for (i in noteIn.indices) {
                println("$i. ${noteIn[i]}")
            }
            println("--Пункты меню--")
            println("${arhive.lastIndex + 1}. Создать заметку")
            println("${arhive.lastIndex + 2}. Назад")
            println("Введите номер нужной вам заметки или пункт меню")
            println("---------------\n")
            val line = scaner.nextLine()
            if (!line.isNullOrBlank() && line.isDigit()) {
                when (line.toInt()) {
                    arhive.lastIndex + 1 -> {
                        create()
                    }

                    arhive.lastIndex + 2 -> {
                        Navigator.goBack()
                    }

                    else -> {
                        val textIndex = Storage.getNotesSize(arhiveId)
                        val answer = line.toInt()
                        if (answer >= 0 && answer <= textIndex) {
                            val nameNote = noteIn[answer]
                            Navigator.open(MenuOpenTextNote(arhiveId, answer, nameNote))
                        } else {
                            println("Введите число от 0 до ${textIndex + 1}")
                        }

                    }
                }
            } else {
                println("Введите число!")
            }
        }
    }


    override fun create() {
        val scaner = Scanner(System.`in`)
        val index = arhiveId
        while (true) {
            println("\nВведите название заметки")
            val name = scaner.nextLine()
            if (!name.isNullOrBlank()) {
                while (true) {
                    println("Введите текст заметки")
                    val text = scaner.nextLine()
                    if (!text.isNullOrBlank()) {
                        Storage.addToArhive(index, name, text)
                        println("Заметка $name добавлена в архив\n")
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