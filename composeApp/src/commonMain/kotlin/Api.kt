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
    class Response {
        @Serializable
        data class AlbumList(
            val status: String,
            val version: String,
            val type: String,
            val serverVersion: String,
            val openSubsonic: Boolean,
            val error: OSError? = OSError(0, ""),
            val albumList2: OSAlbumList2
        )

        @Serializable
        data class RandomSongs(
            val status: String,
            val version: String,
            val type: String,
            val serverVersion: String,
            val openSubsonic: Boolean,
            val error: OSError? = OSError(0, ""),
            val randomSongs: OSRandomSong
        )

        @Serializable
        data class Search3(
            val status: String,
            val version: String,
            val type: String,
            val serverVersion: String,
            val openSubsonic: Boolean,
            val error: OSError? = OSError(0, ""),
            val searchResult3: OSSearchResult3
        )
    }

    @Serializable
    data class OSSearchResult3(
        val artist: List<OSArtistID3>? = emptyList(),
        val album: List<OSAlbumID3>? = emptyList(),
        val song: List<OSChild>? = emptyList()
    )

    @Serializable
    data class OSRandomSong(
        val song: List<OSChild>
    )

    @Serializable
    data class OSChild(
        val id: String,
        val parent: String? = "",
        val isDir: Boolean,
        val title: String,
        val album: String? = "",
        val artist: String? = "",
        val track: Int? = DEFAULT_INT,
        val year: Int? = DEFAULT_INT,
        val genre: String? = "",
        val coverArt: String? = "",
        val size: Long? = DEFAULT_LONG,
        val contentType: String? = "",
        val suffix: String? = "",
        val transcodedContentType: String? = "",
        val transcodedSuffix: String? = "",
        val duration: Int? = DEFAULT_INT,
        val bitRate: Int? = DEFAULT_INT,
        val bitDepth: Int? = DEFAULT_INT,
        val samplingRate: Int? = DEFAULT_INT,
        val channelCount: Int? = DEFAULT_INT,
        val path: String? = "",
        val isVideo: Boolean? = false,
        val userRating: Int? = DEFAULT_INT,
        val averageRating: Float? = DEFAULT_FLOAT,
        val playCount: Long? = DEFAULT_LONG,
        val discNumber: Int? = DEFAULT_INT,
        val created: String? = "",
        val starred: String? = "",
        val albumId: String? = "",
        val artistId: String? = "",
        val type: String? = "",
        val mediaType: String? = "",
        val bookmarkPosition: Long? = DEFAULT_LONG,
        val originalWidth: Int? = DEFAULT_INT,
        val originalHeight: Int? = DEFAULT_INT,
        val played: String? = "",
        val bpm: Int? = DEFAULT_INT,
        val comment: String? = "",
        val sortName: String? = "",
        val musicBrainzId: String? = "",
        val genres: List<OSItemGenre>? = emptyList(),
        val artists: List<OSArtistID3>? = emptyList(),
        val displayArtist: String? = "",
        val albumArtists: List<OSArtistID3>? = emptyList(),
        val displayAlbumArtist: String? = "",
        val contributors: List<OSContributor>? = emptyList(),
        val displayComposer: String? = "",
        val moods: List<String>? = emptyList(),
        val replayGain: OSReplayGain? = null
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
        private suspend fun makeRequest(client: HttpClient, reqUrl: String): Result<String> {
            val res: HttpResponse
            try {
                res = client.get(reqUrl)
            } catch (e: Throwable) {
                return Result.failure(Exception("Failed http: ${e.message}"))
            }
            if (res.status != HttpStatusCode.OK) {
                return Result.failure(Exception("Failed http, status: ${res.status}"))
            }

            val stringBody = res.bodyAsText()
            return Result.success(stringBody)
        }

        suspend fun getAlbumList(client: HttpClient): Result<Response.AlbumList> {
            @Serializable
            data class OSResponse(
                @SerialName("subsonic-response") val subsonicResponse: Response.AlbumList,
            )

            val reqUrl = "http://localhost:4747/rest/getAlbumList2?u=admin&p=admin&c=test&f=json&type=newest"
            val stringBody = makeRequest(client, reqUrl).getOrElse { return Result.failure(it) }
            val resJson: OSResponse = Json.decodeFromString(stringBody)
            return Result.success(resJson.subsonicResponse)
        }

        suspend fun getRandomSongs(client: HttpClient): Result<Response.RandomSongs> {
            @Serializable
            data class OSResponse(
                @SerialName("subsonic-response") val subsonicResponse: Response.RandomSongs,
            )

            val reqUrl = "http://localhost:4747/rest/getRandomSongs?u=admin&p=admin&c=test&f=json&type=newest"
            val stringBody = makeRequest(client, reqUrl).getOrElse { return Result.failure(it) }
            val resJson: OSResponse = Json.decodeFromString(stringBody)
            return Result.success(resJson.subsonicResponse)
        }
    }
}
