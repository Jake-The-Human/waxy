import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences


//fun createDataStore(): DataStore<Preferences> = createDataStore(
//    producePath = {
//        val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
//            directory = NSDocumentDirectory,
//            inDomain = NSUserDomainMask,
//            appropriateForURL = null,
//            create = false,
//            error = null,
//        )
//        requireNotNull(documentDirectory).path + "/$dataStoreFileName"
//    }
//)

actual class WaxyDataStore actual constructor() {
    actual suspend fun saveThemeToDataStore(value: String) {}
    actual suspend fun readThemeFromDataStore(): String? { return null }
}
