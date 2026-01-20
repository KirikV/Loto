import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

val team = createTeam()
println("Игроки до замены")
    println(team.toString())
    val viewModel = GameVar1()
    viewModel.startGame()
    delay(3000)
    println(GlobalStorage.firstNumber)
    for(players in team) {
        for (card in players.cards) {
            for (line in card.lines) {
                val index = line.indexOf(GlobalStorage.firstNumber)
                if (index != -1) {
                    line[index] = null
                    println("Найдено число ${GlobalStorage.firstNumber}, заменил в карточке на null")
                }

            }
        }
    }
    println(team)
    viewModel.clear()


}

val genNums = (1..90).shuffled().asFlow()


fun createTeam(): List<Player> {
    println("--- Участники ---")

    val commonAmount = Player.askCommonAmount()

    var countPlayers = 0
    while (countPlayers < 2) {
        println("Введите количество игроков (минимум 2):")
        countPlayers = readln().toIntOrNull() ?: 0
        if (countPlayers < 2) {
            println("Ошибка! Количество участников не может быть меньше 2.")
        }
    }

    val team = mutableListOf<Player>()
    for (i in 1..countPlayers) {
        println("\nИмя для участника №$i:")
        val player = Player.createFromConsole(commonAmount)
        team.add(player)
    }

    return team
}