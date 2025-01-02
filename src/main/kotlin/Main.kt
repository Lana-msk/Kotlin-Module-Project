import actions.ArchiveActions
import entities.Archive

fun main() {
    val archive: MutableMap<Int, Archive> = HashMap()
    val actions = ArchiveActions()
    actions.createArchive(archive)
}