import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.takeWhile

class GameVar1(val team: List<Player>) {
    private var isGameOver = false
    suspend fun startGame() {
        println("ПОГНАЛИ")
        genNums.takeWhile { !isGameOver }.collect { number ->
            delay(300)
            println("\n---------На бочонке $number---------")
            for (player in team) {
                player.handleNumber(number)
                println(player)
                delay(700)
                if (player.checkWin()){
                    println("СТОП ИГРА \n"+ "-".repeat(43) +"\nПоздравляем игрока ${player.name} с победой! ")
                    isGameOver = true
                    break
                }
            }
            if (isGameOver) return@collect
        }
    }
}