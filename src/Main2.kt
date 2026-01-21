import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {

    val sharedFlow = MutableSharedFlow<Int>()
    val stateFlow = MutableStateFlow(0)

    launch {
        stateFlow.collect {
            println("collect $it")
            delay(1000)
        }
    }

    launch {
        repeat(10) {
            println("emit $it")
            stateFlow.emit(it)
            delay(200)
        }
    }
}