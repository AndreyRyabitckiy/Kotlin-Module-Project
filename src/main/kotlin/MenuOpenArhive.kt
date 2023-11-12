import java.util.Scanner

class MenuOpenArhive : Screen {
    override fun open() {
        val scanner = Scanner(System.`in`)
        while (true) {
            println("_____Меню_____")
            println("1. Создать архив")
            println("2. Выбрать архив")
            println("3. Выход")
            println("--------------")
            val line = scanner.nextLine()
            if (!line.isNullOrEmpty() && line.isDigit())
                when (line.toInt()) {
                    1 -> createArhive()
                    2 -> openArhive()
                    3 -> Navigator.exit()
                    else -> println("Введите число от 1 до 3")
                } else {
                println("Введите число!")
            }
        }
    }

    private fun createArhive() {
        while (true) {
            println("Введите имя архива")
            val scanner = Scanner(System.`in`)
            val name = scanner.nextLine()
            if (!name.isNullOrEmpty()) {
                Storage.newArhive(name)
                println("Архив $name Успешно создан")
                break
            } else {
                println("Архив не может не иметь имени")
            }
        }
    }

    private fun openArhive() {
        while (true) {
            val arhive = Storage.listArhive()
            val size = Storage.getArhiveSize()
            println("Сохраненные архивы")
            for (i in arhive.indices) {
                println("$i. ${arhive[i]}")
            }
            println("Введите номер нужного вам архива")
            val scanner = Scanner(System.`in`)
            val index = scanner.nextLine()
            if (!index.isNullOrEmpty() && index.isDigit()) {
                val answer = index.toInt()
                if (answer <= size && answer > -1) {
                    Navigator.open(MenuOpenNote(answer))
                    break
                } else {
                    println("Введите число от 0 до ${size - 1}")
                }
            } else {
                println("Введите корректное число")
            }
        }
    }
}


