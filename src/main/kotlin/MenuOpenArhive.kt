class MenuOpenArhive : Screen() {
    override fun open() {
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
            when (val line = getInputInt()) {
                arhive.lastIndex + 1 -> {
                    create()
                }

                arhive.lastIndex + 2 -> {
                    Navigator.exit()
                }

                else -> {
                    if (line <= size && line > -1) {
                        Navigator.open(MenuOpenNote(line))
                        break
                    } else {
                        println("Введите число от 0 до ${arhive.lastIndex + 2}")
                    }
                }
            }

        }
    }

    override fun create() {
        while (true) {
            println("Введите имя архива")
            getinputString()?.let { name ->
                Storage.newArhive(name)
                println("Архив $name Успешно создан \n")
                return
            } ?: println("Архив не может не иметь имени")
        }
    }
}