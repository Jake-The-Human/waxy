import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
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
        val error: OSError = OSError(0, ""),
        val albumList2: OSAlbumList2,
    )

    @Serializable
    data class RandomSongsResponse(
        val status: String,
        val version: String,
        val type: String,
        val serverVersion: String,
        val openSubsonic: Boolean,
        val error: OSError = OSError(0, ""),
        val randomSongs: OSRandomSong,
    )

    @Serializable
    data class OSRandomSong(
        val song: List<OSSong>
    )

    @Serializable
    data class OSSong(
        val id: String,
        val parent: String? = "",
        val isDir: Boolean,
        val title: String,
        val album: String? = "",
        val albumId: String? = "",
        val artist: String? = "",
        val artistId: String? = "",
        val artists: List<OSArtistID3>? = emptyList(),
        val displayArtist: String? = "",
        val albumArtists: List<OSArtistID3>? = emptyList(),
        val displayAlbumArtist: String? = "",
        val bitRate: Int? = DEFAULT_INT,
        val contentType: String? = "",
        val coverArt: String? = "",
        val created: String? = "",
        val duration: Int? = DEFAULT_INT,
        val path: String? = "",
        val size: Long = DEFAULT_LONG,
        val suffix: String? = "",
        val track: Int? = DEFAULT_INT,
        val type: String,
        val year: Int? = DEFAULT_INT,
        val musicBrainzId: String? = "",
        val isVideo: Boolean? = false,
    )

    @Serializable
    data class OSAlbumList2(
        val album: List<OSAlbumID3>,
    )

    @Serializable
    data class OSAlbumID3(
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
        val artists: List<OSArtistID3>,
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
    data class OSItemGenre(
        val name: String
    )

    @Serializable
    data class OSArtistID3(
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
    data class OSContributor(
        val role: String,
        val subRole: String = "",
        val artist: OSArtistID3 = OSArtistID3("", "")
    )

    @Serializable
    data class OSReplayGain(
        val trackGain: Float = DEFAULT_FLOAT,
        val albumGain: Float = DEFAULT_FLOAT,
        val trackPeak: Float = DEFAULT_FLOAT,
        val albumPeak: Float = DEFAULT_FLOAT,
        val baseGain: Float = DEFAULT_FLOAT,
        val fallbackGain: Float = DEFAULT_FLOAT,
    )

    @Serializable
    data class OSError(
        val code: Int,
        val message: String,
    )

    companion object {
        suspend fun getAlbumList(client: HttpClient): Result<AlbumListResponse> {
            @Serializable
            data class OSResponse(
                @SerialName("subsonic-response") val subsonicResponse: AlbumListResponse,
            )

            val res: HttpResponse
            try {
                res = client.get("http://localhost:4747/rest/getAlbumList2?u=admin&p=admin&c=test&f=json&type=newest")
            } catch (e: Throwable) {
                return Result.failure(Exception("Failed http: ${e.message}"))
            }
            if (res.status != HttpStatusCode.OK) {
                return Result.failure(Exception("Failed http, status: ${res.status}"))
            }

            val stringBody = res.bodyAsText()
            val resJson: OSResponse = Json.decodeFromString(stringBody)
            return Result.success(resJson.subsonicResponse)
        }

        suspend fun getRandomSongs(client: HttpClient): Result<RandomSongsResponse> {
            @Serializable
            data class OSResponse(
                @SerialName("subsonic-response") val subsonicResponse: RandomSongsResponse,
            )
            val res: HttpResponse
            try {
                res = client.get("http://localhost:4747/rest/getRandomSongs?u=admin&p=admin&c=test&f=json&type=newest")
            } catch (e: Throwable) {
                return Result.failure(Exception("Failed http: ${e.message}"))
            }
            if (res.status != HttpStatusCode.OK) {
                return Result.failure(Exception("Failed http, status: ${res.status}"))
            }

            val stringBody = res.bodyAsText()
            val resJson: OSResponse = Json.decodeFromString(stringBody)
            return Result.success(resJson.subsonicResponse)
        }
    }
}
