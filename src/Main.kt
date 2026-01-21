import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val team = createTeam()
    val scope = CoroutineScope(Dispatchers.Default)

    val gameVar = GameVar1(team)
    sharedFlow.collect {

    }

    scope.launch {
        gameVar.startGame()
    }.join()
}

val genNums = (1..90).shuffled().asFlow()
val sharedFlow = MutableSharedFlow<Int>()
val stateFlow = MutableStateFlow(0)

enum class FlowVariant {
    COLD,
    SHARED,
    STATE
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