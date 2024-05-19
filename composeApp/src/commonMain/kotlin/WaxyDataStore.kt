const val dataStoreFileName = "waxy.preferences_pb"

expect class WaxyDataStore {
    suspend fun saveThemeToDataStore(value: String)
    suspend fun readThemeFromDataStore(): String?
}
