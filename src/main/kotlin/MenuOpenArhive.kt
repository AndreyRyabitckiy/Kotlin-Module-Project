import java.util.Scanner

class MenuOpenArhive : Screen {
    override fun open() {
        val scanner = Scanner(System.`in`)
        while (true) {
            val arhive = Storage.listArhive()
            val size = Storage.getArhiveSize()
            println("\n---------------")
            println("Сохраненные архивы")
            for (i in arhive.indices) {
                println("$i. ${arhive[i]}")
            }
            println("--Пункты меню--")
            println("${arhive.lastIndex + 1}. Создать архив")
            println("${arhive.lastIndex + 2}. Выход")
            println("Введите номер нужного вам архива или пункт меню")
            println("---------------\n")
            val line = scanner.nextLine()
            if (!line.isNullOrBlank() && line.isDigit()) {
                when (line.toInt()) {
                    arhive.lastIndex + 1 -> {
                        create()
                    }

                    arhive.lastIndex + 2 -> {
                        Navigator.exit()
                    }

                    else -> {
                        if (line.toInt() <= size && line.toInt() > -1) {
                            Navigator.open(MenuOpenNote(line.toInt()))
                            break
                        } else {
                            println("Введите число от 0 до ${arhive.lastIndex + 2}")
                        }
                    }
                }
            } else {
                println("Введите число! \n")
            }
        }
    }

    override fun create() {
        while (true) {
            println("Введите имя архива")
            val scanner = Scanner(System.`in`)
            val name = scanner.nextLine()
            if (!name.isNullOrBlank()) {
                Storage.newArhive(name)
                println("Архив $name Успешно создан \n")
                break
            } else {
                println("Архив не может не иметь имени")
            }
        }
    }
}




