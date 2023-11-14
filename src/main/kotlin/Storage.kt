object Storage {
    private val arhive: MutableList<Arhive> = mutableListOf()

    fun newArhive(name: String) {
        arhive.add(Arhive(name, mutableListOf()))
    }

    fun listArhive(): List<String> {
        return arhive.map { it.name }
    }

    fun addToArhive(indexArhive: Int, name: String, text: String) {
        arhive[indexArhive].note.add(Notes(name, text))
    }

    fun noteInArhive(numberArhive: Int): List<String> {
        return arhive[numberArhive].note.map { it.name }
    }

    fun textInNote(numberArhive: Int, numberNotes: Int): String {
        return arhive[numberArhive].note[numberNotes].text
    }


    fun getArhiveSize() = arhive.size

    fun getNotesSize(arhiveId: Int) = arhive[arhiveId].note.size

    fun clear() {
        arhive.clear()
    }


}