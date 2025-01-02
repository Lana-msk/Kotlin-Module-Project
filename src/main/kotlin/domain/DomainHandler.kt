package domain

import java.util.Scanner

enum class DataTypes {
    ARCHIVES,
    NOTES;

    fun fromTypeToString(input: Int): String {
        val result = when (this) {
            ARCHIVES -> {
                when (input) {
                    1 -> "Список архивов:\n"
                    2 -> "Создать архив"
                    else -> "архива"
                }
            }

            NOTES -> {
                when (input) {
                    1 -> "Вы выбрали архив: "
                    else -> "Создать заметку"
                }
            }
        }
        return result
    }
}

class DomainHandler {

    fun <T> menu(type: DataTypes, archive: MutableMap<Int, T>, archiveHeader: String = ""): Int {
        var num = 0
        if (type == DataTypes.ARCHIVES) {
            println("${type.fromTypeToString(1)}0.${type.fromTypeToString(2)}")
        } else println("${type.fromTypeToString(1)}$archiveHeader.\n0.${type.fromTypeToString(2)}")

        if (archive.isNotEmpty()) {
            for ((key, value) in archive) {
                println("${key + 1}.${value.toString()}.")
                num++
            }
        }
        println("${++num}.Выход")
        return num
    }
}

fun Scanner.getIntInputOrNull(): Int? {
    return when (val input = this.nextLine().toIntOrNull()) {
        null -> {
            null
        }

        else -> input
    }
}