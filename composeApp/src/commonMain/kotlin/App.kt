import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import korlibs.audio.sound.AudioData
import korlibs.audio.sound.AudioSamples
import korlibs.audio.sound.AudioStream
import korlibs.audio.sound.NativeSoundProviderNew
import korlibs.audio.sound.PlatformAudioOutput
import korlibs.audio.sound.await
import korlibs.audio.sound.nativeSoundProvider
import korlibs.audio.sound.toSound
import korlibs.math.clamp
import korlibs.time.TimeSpan
import kotlinx.coroutines.runBlocking
import kotlin.math.PI
import kotlin.math.sin

val emptySong = Api.OSChild(id = "", isDir = false, title = "")

fun generateSineWave(durationInSeconds: Double, sampleRate: Int): ShortArray {
    val numSamples = durationInSeconds * sampleRate.toDouble()
    val samples = mutableListOf<Short>()

    for (i in 0 until numSamples.toInt()) {
        val t = i / sampleRate // Time variable for the sine calculation
        val sineValue = sin(2 * PI * 440 * t) // Generate sine wave at 440 Hz

        // Scale the sine value to the range of Short (-32768 to 32767)
        val scaledValue = (sineValue * Short.MAX_VALUE).toInt().toShort()

        samples.add(scaledValue)
    }

    // Convert the list of shorts to an array of shorts
    return samples.toShortArray()
}

@Composable
fun App(openSettings: (Boolean) -> Unit, settings: Settings) {
    val currentProfile by remember { mutableStateOf(UserProfile.waxyProfile) }
    val songQueue = remember { mutableStateListOf<Api.OSChild>() }
    var currentSong: Api.OSChild by remember { mutableStateOf(emptySong) }

    runBlocking {
        Api.stream(HttpClient(CIO), "tr-1").onSuccess {
//            val audioOutput: PlatformAudioOutput = nativeSoundProvider.createPlatformAudioOutput(44100)
//            audioOutput.start()

            val channel1 = mutableListOf<Short>()
            val channel2 = mutableListOf<Short>()
            for (i in 668155 until (it.size - 4 * 2) step 4 * 2) {
                var b1 = it[i].toUByte().toInt()
                var b2 = it[i+1].toUByte().toInt()
                var b3 = it[i+2].toUByte().toInt()
                var b4 = it[i+3].toUByte().toInt()
                var intBytes = (b1 shl 24) or (b2 shl 16) or (b3 shl 8) or b4
                channel1.add(intBytes.toShort())

                b1 = it[i+4].toUByte().toInt()
                b2 = it[i+5].toUByte().toInt()
                b3 = it[i+6].toUByte().toInt()
                b4 = it[i+7].toUByte().toInt()
                intBytes = (b1 shl 24) or (b2 shl 16) or (b3 shl 8) or b4
                channel2.add(intBytes.toShort())
            }
            val channels = arrayOf(channel1.toShortArray(), channel2.toShortArray())
//
            val sinwav = generateSineWave(5.0, 44100)
            val samps = AudioSamples(1, sinwav.size, arrayOf(sinwav))
            val da = AudioData(44100, samps)
//            val channel = da.toSound().play()
//            channel.await { current: TimeSpan, total: TimeSpan ->
//                println("$current/$total")
//            }
//            audioOutput.add(da)
//            audioOutput.start()
            da.toSound().play()
        }
    }

    MaterialTheme(colorScheme = settings.getTheme()) {
        Surface {
            Column {
                Row(
                    modifier = Modifier.wrapContentSize()
                ) {

                    userProfileView(currentProfile, Modifier.weight(9F))
                    Button(
                        onClick = { openSettings(true) },
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .weight(1F)
                            .padding(8.dp)
                    ) {
                        Icon(Icons.Default.Settings, "settings")
                    }
                }
                Row {

                        Card(
                            modifier = Modifier
                                .padding(16.dp)
                                .weight(3F)
                        ) {
                            fileListView(onSongChange = { currentSong = it }, addSongToQueue = { songQueue.add(it) }, Modifier)
                        }

                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .weight(1F)
                    ) {
                        songQueueView(songQueue)
                    }
                }
            }
        }
    }
}
