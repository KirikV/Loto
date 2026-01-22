import kotlin.random.Random

class Card {
    val lines = Array(3) { MutableList<Cell>(9) { Cell.Empty } }
    private val cells = List(9) { index ->
        val start = if (index == 0) 1 else index * 10
        val end = if (index == 8) 90 else index * 10 + 9
        (start..end).shuffled().toMutableList()
    }
//    private val cells = List(9) { index ->
//        val start = if (index == 0) 1 else index * 10
//        val end = if (index == 8) 90 else index * 10 + 9
//        (start..end).toMutableList().apply { shuffle() }
//    }

    init {
        fillAllLines()
    }

    private fun fillAllLines() {
        for (line in lines) {
            val randomPositions = (0..8).shuffled().take(5)
            for (pos in randomPositions) {
                val value = cells[pos].removeAt(0)
                line[pos] = Cell.Number(value = value, isCrossed = false)
            }
        }
    }

    override fun toString(): String {
        return lines.joinToString(separator = "\n") { line ->
            line.joinToString(separator = " | ") { cell ->
                when (cell) {
                    is Cell.Empty -> "  "
                    is Cell.Number -> cell.value.toString().padStart(2)
                }
            }
        }
    }

    sealed interface Cell {
        object Empty : Cell
        data class Number(val value: Int, val isCrossed: Boolean) : Cell
    }
}



