package objects

import models.Subjects
import util.getNumber
import util.getString
import java.lang.IndexOutOfBoundsException

object SubjectsObj {
    private var subjects:Subjects = Subjects()
    init {
        try {  subjects = Subjects.read()!! }
        catch (e : Exception) { println("Something went wrong: $e.message") }
    }

    fun printAll(){
        println("All subjects:")
            subjects.iterator().withIndex().forEach { (index, value) ->
            println("${index+1} - ${value.name}")
        }
    }

    fun modifyOne(){
        printAll()
        val name = getString("Which subject do you want to modify (name)")
        printOne(name)
        modify(name)
    }

    private fun modify(name: String) {
        val chosen = subjects.first { it.name == name }


        subjects.removeIf { it.name == name }
    }

    private fun printOne(one: String){
        try {
            val chosen = subjects.first { it.name == one }
            println("Name: ${chosen.name} (${chosen.code} - ${chosen.credit} credit)")
            println("Date: ${chosen.date?.day} ${chosen.date?.hour}:${chosen.date?.minutes}")
        } catch (e: NoSuchElementException) {
            println("No element found")
        }
    }

    fun printOne(){
        printAll()
        val chosen = getString("Which subject would you like to expand")
        printOne(chosen)
    }

    fun addSub(){
        println("Adding new subject (to leave a filed empty, press Enter):")
        val name = getString("Name of new subject")
        val code = getString("Subject code")
        val credit = getNumber("How much credit is it")
        val day = getString("What day is it")
        val time = getString("When (e.g. 14:30)")

        val toDouble : (String)->Double={x: String -> x.toDouble()}
        print("How long is it: ")
        val interval = readLine()?.let { toDouble(it) }

        println("Later you can add additional information!")

        subjects.add(Subjects.Subject(
            code,
            credit,
            Subjects.Subject.Date(
                day,
                time.split(':')[0].toInt(),
                time.split(':')[1].toInt()),
            null,
            interval,
            null,
            name,
            null,
            null,
            null)
        )
    }

    fun writeToFile(){
        println("Saving changes...")
        try { subjects.write() } catch (e: Exception) {println("Something went wrong: $e.message")}
        println("Exiting...")
    }

    fun removeSub(){
        printAll()
        val idx = getNumber("Which subject do you wish to remove (number, 0 if none)")
        try {
            if(idx != 0) {
                subjects.removeAt(idx - 1)
                println("Item removed successfully")
            }
        }catch (e: IndexOutOfBoundsException){
            println("Subject not found!")
            removeSub()
        }
    }
}

