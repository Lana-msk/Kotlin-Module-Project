package actions

import domain.DomainHandler
import domain.DataTypes
import domain.getIntInputOrNull
import entities.Archive
import java.util.Scanner

class ArchiveActions {

    private val domain = DomainHandler()

    private fun createArchive(archive: MutableMap<Int, Archive>, num: Int) {
        println("Введите заголовок архива")
        val archiveHeader = Scanner(System.`in`).nextLine()
        if (archiveHeader.isEmpty()) println("Введено пустое значение") else archive[num - 1] =
            Archive(archiveHeader, HashMap())
    }

    private fun showArchive(archive: MutableMap<Int, Archive>, input: Int) {
        val notes = NotesActions()
        archive[input - 1]?.let { notes.createNotes(it.header, it.notes) }
            ?: println("Ошибка")
    }

    fun createArchive(archive: MutableMap<Int, Archive>) {
        while (true) {
            val num = domain.menu(DataTypes.ARCHIVES, archive)
            when (val input = Scanner(System.`in`).getIntInputOrNull()) {
                null -> println("Введите цифру!")
                num -> break
                0 -> {
                    createArchive(archive, num)
                    continue
                }

                in 1 until num -> showArchive(archive, input)

                else -> {
                    println("Введите одну из предложенных цифр")
                    continue
                }
            }
        }
    }
}