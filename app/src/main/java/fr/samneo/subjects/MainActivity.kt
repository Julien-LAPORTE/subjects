package fr.samneo.subjects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.samneo.subjects.ui.MainWindow
import fr.samneo.subjects.ui.theme.SubjectsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SubjectsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SubjectsApp()
                }
            }
        }
    }
}

@Composable
fun SubjectsApp(modifier: Modifier = Modifier) {
    MainWindow(modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun SubjectAppPreview() {
    SubjectsTheme {
        SubjectsApp()
    }
}