import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class GameVar1(val team: List<Player>) : BaseViewModel() {
    suspend fun startGame() {
        genNums.collect { number ->
            delay(300)
            println("DDD $number")
            for (player in team) {
                player.handleNumber(number)
                player.showCards()
            }
        }
    }
}
