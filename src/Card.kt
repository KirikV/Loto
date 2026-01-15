class Card {
    var line1: MutableList<Any?> = MutableList(9) { null }
    var line2: MutableList<Any?> = MutableList(9) { null }
    var line3: MutableList<Any?> = MutableList(9) { null }

    private var listOfNumbers = (1..90).toMutableList().apply { shuffle() }

    fun fillLine(list: MutableList<Any?>) {
        val positions = (0..8).shuffled().take(5)
        for (pos in positions) {
            val randomNum = listOfNumbers.removeAt(0)
            list[pos] = randomNum
        }
    }

    fun fillAllLines() {
        fillLine(line1)
        fillLine(line2)
        fillLine(line3)
    }
}


