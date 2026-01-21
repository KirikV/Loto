import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class GameVarShared(val team: List<Player>) : BaseViewModel() {
    private val sharedFlow = MutableSharedFlow<Int>()
    suspend fun startGame() {
        CoroutineScope(currentCoroutineContext()).launch {
            (1..90).shuffled().forEach { sharedFlow.emit(it)}
        }
        sharedFlow.collect { number ->
            delay(300)
            println("DDD $number")
            for (player in team) {
                player.handleNumber(number)
                player.showCards()
            }
        }
    }
}
