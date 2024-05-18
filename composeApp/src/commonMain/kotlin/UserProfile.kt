data class UserProfile(
    val userName: String,
    val numberAlbums: Int,
    val numberSongs: Int,
) {
    companion object {
        val waxyProfile = UserProfile("Waxy", 0, 0)
    }
}