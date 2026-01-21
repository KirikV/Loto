class Card {
    val lines = Array(3) { MutableList<Int?>(9) { null } }
    private val cells = List(9) { index ->
        val start = if (index == 0) 1 else index * 10
        val end = if (index == 8) 90 else index * 10 + 9
        (start..end).toMutableList().apply { shuffle() }
    }

    init {
        fillAllLines()
    }


    fun handleNumber(number: Int) {
        for (line in lines) {
            val index = line.indexOf(number)
            if (index != -1) {
                line[index] = null
                println("Найдено число ${number}, заменил в карточке на null")
            }
        }
    }

    private fun fillAllLines() {
        for (line in lines) {
            val positions = (0..8).shuffled().take(5)
            for (pos in positions) {
                if (cells[pos].isNotEmpty()) {
                    line[pos] = cells[pos].removeAt(0)
                }
            }
        }
    }

    override fun toString(): String {
        return lines.joinToString("\n") { line ->
            line.joinToString(" | ") { cell ->
                (cell?.toString() ?: "  ").padStart(2)
            }
        }
    }
}

interface Cell {
    object Empty: Cell
    class Number(val value: Int, val isCrossed: Boolean): Cell
}
