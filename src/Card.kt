    class Card {
        val lines = Array(3) { MutableList<Cell>(9) { Cell.Empty } }
        private val cells = List(9) { index ->
            val start = if (index == 0) 1 else index * 10
            val end = if (index == 8) 90 else index * 10 + 9
            (start..end).shuffled().toMutableList()
        }

        init {
            fillAllLines()
        }

        fun handleNumber(number: Int) {
            for (line in lines) {
                val index = line.indexOf(element = Cell.Number(value = number, isCrossed = false))
                if (index != -1) {
                    line[index] = Cell.Number(value = number, isCrossed = true)
//                    println("Найдено число ${number}, статус изменено на isCrossed = true")
                }
            }
        }


        private fun fillAllLines() {
            for (line in lines) {
                val randomPositions = (0..8).shuffled().take(5)
                for (pos in randomPositions) {
                    if (cells[pos].isNotEmpty()) {
                        val value = cells[pos].removeAt(0)
                        line[pos] = Cell.Number(value = value, isCrossed = false)
                    }
                }
            }
        }

        override fun toString(): String {
            return lines.joinToString(separator = "\n") { line ->
                line.joinToString(separator = " | ") { cell ->
                    when (cell) {
                        is Cell.Empty -> "  "
                        is Cell.Number -> {
                            val ansiColor = if (cell.isCrossed) "\u001B[32m" else "\u001B[31m"
                            val reset = "\u001B[0m"
                            "$ansiColor${cell.value.toString().padStart(2)}$reset"
                        }
                    }
                }
            }
        }

        sealed interface Cell {
            object Empty : Cell
            data class Number(
                val value: Int,
                val isCrossed: Boolean
            ) : Cell

        }
    }





