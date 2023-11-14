class MenuOpenTextNote(
    private val arhiveId: Int,
    private val noteId: Int,
    private val nameNote: String
) : Screen() {

    override fun open() {
        while (true) {
            println("\n---------------")
            println("Выбрана заметка с именем $nameNote")
            println("1. Назад")
            println("2. Показать текст заметки")
            println("---------------\n")

            when (getInputInt()) {
                1 -> {
                    Navigator.goBack()
                }

                2 -> {
                    create()
                }

                else -> {
                    println("Введите число от 1 до 2")
                }
            }
        }
    }


    override fun create() {


        val note = Storage.textInNote(arhiveId, noteId)
        println("Текст в заметке: $note")


    }
}