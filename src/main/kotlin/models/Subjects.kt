package models

import java.io.FileReader
import com.google.gson.Gson
import java.io.File

class Subjects : ArrayList<Subjects.Subject>(){
    fun write(){ File("src/data.json").writeText(Gson().toJson(this))
    }

    companion object {
        fun read(): Subjects? = Gson().fromJson(FileReader("src/data.json"), Subjects::class.java)
    }
    data class Subject(
        val code: String?,
        val credit: Int,
        val date: Date?,
        val deadlines: List<Deadline>?,
        val interval: Double?,
        val links: List<String>?,
        val name: String,
        val requirements: String?,
        val teachers: List<String>?,
        val mark: Int?
    ) {
        data class Date(
            val day: String,
            val hour: Int,
            val minutes: Int
        )
    
        data class Deadline(
            val name: String,
            val time: String//string because it can be end of the year, next week, etc...
        )
    }
}