import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

fun createDataStore(context: Context): DataStore<Preferences> = createDataStore(
    producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
)
actual class WaxyDataStore {
    actual suspend fun saveThemeToDataStore(value: String) {}
    actual suspend fun readThemeFromDataStore(): String? { return null }
}