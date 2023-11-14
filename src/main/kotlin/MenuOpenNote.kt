class MenuOpenNote(private val arhiveId: Int) : Screen() {

    override fun open() {
        while (true) {
            val arhive = Storage.listArhive()
            println("\n---------------")
            val noteIn = Storage.noteInArhive(arhiveId)
            println("Список заметок:")
            for (i in noteIn.indices) {
                println("$i. ${noteIn[i]}")
            }
            println("--Пункты меню--")
            println("${arhive.lastIndex + 1}. Создать заметку")
            println("${arhive.lastIndex + 2}. Назад")
            println("Введите номер нужной вам заметки или пункт меню")
            println("---------------\n")
            when (val line = getInputInt()) {
                arhive.lastIndex + 1 -> {
                    create()
                }

                arhive.lastIndex + 2 -> {
                    Navigator.goBack()
                }

                else -> {
                    val textIndex = Storage.getNotesSize(arhiveId)
                    if (line in 0..textIndex) {
                        val nameNote = noteIn[line]
                        Navigator.open(MenuOpenTextNote(arhiveId, line, nameNote))
                    } else {
                        println("Введите число от 0 до ${textIndex + 1}")
                    }

                }
            }
        }
    }


    override fun create() {
        var dontHaveName = true
        var dontHaveText = true
        while (dontHaveName) {
            println("\nВведите название заметки")
            getinputString()?.let { name ->
                dontHaveName = false
                while (dontHaveText) {
                    println("Введите текст заметки")
                    getinputString()?.let { text ->
                        dontHaveText = false
                        Storage.addToArhive(arhiveId, name, text)
                        println("Заметка $name добавлена в архив\n")
                    } ?: println("Заметка не может не иметь текст")
                }
            } ?: println("Заметка не может не иметь названия")
        }
    }
}
