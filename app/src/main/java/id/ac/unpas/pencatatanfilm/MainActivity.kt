package id.ac.unpas.pencatatanfilm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.ac.unpas.pencatatanfilm.screen.PendataanFilmScreen
import id.ac.unpas.pencatatanfilm.ui.theme.PencatatanFilmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PencatatanFilmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PendataanFilmScreen()
                }
            }
        }
    }
}

@Preview( showBackground = true)
@Composable
fun DefaultPreview() {
    PencatatanFilmTheme {
        PendataanFilmScreen()
    }
}