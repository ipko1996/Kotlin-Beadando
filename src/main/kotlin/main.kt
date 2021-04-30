import objects.SubjectsObj
import util.getNumber

fun main() {
    var choice = 0
    while (choice != 6){
        choice = mainMenu()
        when (choice) {
            1 -> SubjectsObj.printAll()
            2 -> SubjectsObj.printOne()
            3 -> SubjectsObj.addSub()
            4 -> SubjectsObj.modifyOne()
            5 -> SubjectsObj.removeSub()
            6 -> SubjectsObj.writeToFile()
            else -> println("Something went wrong")
        }
    }
}

private fun mainMenu(): Int {
    println("\n1 - Show all subjects")
    println("2 - Print one")
    println("3 - Add subject")
    println("4 - Modify one")
    println("5 - Delete Subject")
    println("6 - Exit")
    return getNumber("Your choice")
}