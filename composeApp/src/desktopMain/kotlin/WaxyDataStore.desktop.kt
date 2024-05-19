import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import okio.Path.Companion.toPath


internal fun createDataStore(producePath: () -> String): DataStore<Preferences> =
    PreferenceDataStoreFactory.createWithPath(
        produceFile = { producePath().toPath() }
    )

actual class WaxyDataStore {
    private val dataStore: DataStore<Preferences> = createDataStore { dataStoreFileName }
    private val USER_THEME = stringPreferencesKey("user_theme")

    actual suspend fun saveThemeToDataStore(value: String) {
        dataStore.edit { settings ->
            settings[USER_THEME] = value
        }
    }

    actual suspend fun readThemeFromDataStore(): String? {
        val theme = dataStore.data.map { preferences ->
            preferences[USER_THEME] ?: "System"
        }
        return theme.firstOrNull()
    }
}
