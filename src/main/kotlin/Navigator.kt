import kotlin.system.exitProcess

object Navigator {

    private val stack = mutableListOf<Screen>()

    fun goBack() {
        if (stack.isEmpty()) {
            exit()
        } else {
            stack.removeAt(stack.lastIndex)
            openOld(stack[stack.lastIndex])

        }
    }

    fun open(screen: Screen) {
        stack.add(screen)
        screen.open()
    }

    private fun openOld(screen: Screen) {
        screen.open()
    }

    fun exit() {
        Storage.clear()
        stack.clear()
        exitProcess(0)
    }


}