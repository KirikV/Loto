class Player(var name: String, amount: Int) {
    var cards: List<Card> = List(amount) { Card() }

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