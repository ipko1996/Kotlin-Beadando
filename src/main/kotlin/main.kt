import objects.SubjectsObj
import util.getNumber

fun main() {
    var choice = 0
    while (choice != 7){
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
    println("5 - Modify one")
    println("6 - Delete Subject")
    println("7 - Exit")
    return getNumber("Your choice")
}