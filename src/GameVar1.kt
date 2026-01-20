import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class GameVar1 : BaseViewModel() {
    fun startGame() {
        viewModelScope.launch {
            val firstNum = genNums.first()
            GlobalStorage.firstNumber = firstNum
        }
    }
}

object GlobalStorage {
    var firstNumber: Int = 0
}