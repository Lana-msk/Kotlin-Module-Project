package entities

class Note(val header: String, val body: String) {
    override fun toString(): String {
        return header
    }
}