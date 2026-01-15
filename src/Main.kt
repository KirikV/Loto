fun main() {
    val myTeam = createTeam()

    println("\n Участники готовы!")
    myTeam.forEach { player ->
        println(player)
    }
}

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