package actions

import domain.DataTypes
import domain.DomainHandler
import domain.getIntInputOrNull
import entities.Note
import java.util.Scanner

class NotesActions {

    private val domain = DomainHandler()

    private fun createNote(notes: MutableMap<Int, Note>) {
        println("Введите заголовок заметки")
        val header = Scanner(System.`in`).nextLine()
        if (header.isEmpty()) println("Введено пустое значение") else {
            println("Введите заметку")
            val body = Scanner(System.`in`).nextLine()
            if (body.isEmpty()) println("Введено пустое значение") else {
                val nextIndex = if (notes.isEmpty()) 0 else notes.size
                notes[nextIndex] = Note(header, body)
            }
        }
    }

    private fun showNotes(notes: MutableMap<Int, Note>, input: Int) {
        println("Заметка: ${notes[input - 1]?.header}\nТекст: ${notes[input - 1]?.body}")
        println("0.Выход")
        while (true) {
            val testInput = Scanner(System.`in`).nextLine()
            if (testInput == "0") break else println("Для выхода введите 0")
        }
    }

    fun createNotes(archiveName: String, notes: MutableMap<Int, Note>) {
        while (true) {
            val num = domain.menu(DataTypes.NOTES, notes, archiveName)
            when (val input = Scanner(System.`in`).getIntInputOrNull()) {
                null -> println("Введите цифру!")
                num -> break
                0 -> createNote(notes)
                in 1 until num -> showNotes(notes, input)
                else -> println("Введите одну из предложенных цифр")
            }
        }
    }
}