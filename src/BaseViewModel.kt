import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

open class BaseViewModel {
    val viewModelScope = CoroutineScope(Dispatchers.Default + Job())
    fun clear(){
        viewModelScope.cancel()
    }
}