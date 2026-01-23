import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val team = createTeam()
    println(team.joinToString(separator = "\n"))

    val gameVar = GameVar1(team)
    gameVar.startGame()
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