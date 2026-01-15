fun main() {
    val card = Card()
    card.fillAllLines()
    val newCard = listOf(card.line1, card.line2, card.line3)
println(newCard)
}