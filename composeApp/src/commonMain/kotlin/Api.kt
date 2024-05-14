import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

val DEFAULT_INT = 0
val DEFAULT_LONG = 0L
val DEFAULT_FLOAT = 0F

class Api {
    @Serializable
    data class AlbumListResponse(
        val status: String,
        val version: String,
        val type: String,
        val serverVersion: String,
        val openSubsonic: Boolean,
        val error: OSSError = OSSError(0, ""),
        val albumList2: OSSAlbumList2,
    )

    @Serializable
    data class OSSAlbumList2(
        val album: List<OSSAlbumID3>,
    )

    @Serializable
    data class OSSAlbumID3(
        val id: String,
        val title: String,
        val name: String,
        val album: String? = "",
        val artist: String? = "",
        val artistId: String? = "",
        val coverArt: String? = "",
        val songCount: Int,
        val duration: Int,
        val playCount: Long? = DEFAULT_LONG,
        val created: String,
        val starred: String? = "",
        val year: Int? = DEFAULT_INT,
        val genre: String? = "",
        val played: String? = "",
        val userRating: Int? = DEFAULT_INT,
        val recordLabels: List<String>? = emptyList(), // TODO
        val musicBrainzId: String? = "",
        val genres: List<String>? = emptyList(),
        val artists: List<OSSArtistID3>,
        val displayArtist: String? = "",
        val releaseTypes: List<String>? = emptyList(),
        val moods: List<String>? = emptyList(),
        val sortName: String? = "",
        val originalReleaseDate: String? = "", // TODO
        val releaseDate: String? = "", // TODO
        val isCompilation: Boolean? = false,
        val discTitles: List<String>? = emptyList(), // TODO
    )

    @Serializable
    data class OSSItemGenre(
        val name: String
    )

    @Serializable
    data class OSSArtistID3(
        val id: String,
        val name: String,
        val coverArt: String = "",
        val artistImageUrl: String = "",
        val albumCount: Int = DEFAULT_INT,
        val starred: String = "",
        val musicBrainzId: String = "",
        val sortName: String = "",
        val roles: List<String> = emptyList(),
    )

    @Serializable
    data class OSSContributor(
        val role: String,
        val subRole: String = "",
        val artist: OSSArtistID3 = OSSArtistID3("", "")
    )

    @Serializable
    data class OSSReplayGain(
        val trackGain: Float = DEFAULT_FLOAT,
        val albumGain: Float = DEFAULT_FLOAT,
        val trackPeak: Float = DEFAULT_FLOAT,
        val albumPeak: Float = DEFAULT_FLOAT,
        val baseGain: Float = DEFAULT_FLOAT,
        val fallbackGain: Float = DEFAULT_FLOAT,
    )

    @Serializable
    data class OSSError(
        val code: Int,
        val message: String,
    )

    companion object {
        suspend fun getAlbumList(client: HttpClient): AlbumListResponse {
            @Serializable
            data class OSSResponse(
                @SerialName("subsonic-response") val subsonicResponse: AlbumListResponse,
            )
            val res = client.get("http://localhost:4747/rest/getAlbumList2?u=admin&p=admin&c=test&f=json&type=newest")
                .bodyAsText()
            val resJson: OSSResponse = Json.decodeFromString(res)
            return resJson.subsonicResponse
        }
    }
}
