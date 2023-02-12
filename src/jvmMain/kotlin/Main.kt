import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import javax.swing.JFileChooser

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Welcome to Envoy") }
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text)
        }
    }
}

fun openFileChooser() {
    JFileChooser().showOpenDialog(null)
}


fun main() = application {
    Window(title = "Envoy",
        onCloseRequest = ::exitApplication,
        state = WindowState(size = DpSize(1440.dp, 768.dp))
    ) {
        MenuBar {
            Menu("File") {
                Item("New Note", enabled = true, onClick = {})
                Item("Open...", enabled = true, onClick = { openFileChooser() })
                RadioButtonItem("Dark Theme", selected = false, onClick = {})
            }
        }
        App()
    }
}
