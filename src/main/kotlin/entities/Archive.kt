package entities

class Archive(val header: String, var notes: MutableMap<Int, Note>) {
    override fun toString(): String {
        return header
    }
}