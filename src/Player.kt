class Player(var name: String, amount: Int) {
    private var cards: List<Card> = List(amount) { Card() }

    fun handleNumber(number: Int) {
        cards.forEach {
            it.handleNumber(number)
        }
    }

    fun showCards() = cards.forEach { println(it) }

    companion object {
        fun createFromConsole(fixedAmount: Int): Player {
            val name = askPlayerName()
            return Player(name, fixedAmount)
        }

        private fun askPlayerName(): String {
            println("Введите имя игрока:")
            return readln().ifBlank { "Аноним" }
        }

        fun askCommonAmount(): Int {
            while (true) {
                println("Введите количество карточек для каждого игрока:")
                val amount = readln().toIntOrNull() ?: 0
                if (amount > 0) return amount
                println("Ошибка! Введите число больше 0.")
            }
        }
    }

    override fun toString(): String {
        return "Игрок: $name\nЕго карточки:\n" +
                 cards.joinToString("\n" + "-".repeat(43) + "\n")
    }
}