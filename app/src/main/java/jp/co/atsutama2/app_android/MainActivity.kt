package jp.co.atsutama2.app_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.atsutama2.app_android.ui.theme.App_androidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_androidTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            ElevatedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}


@Preview
@Composable
fun GreetingPreview() {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = "Atsutama!")
            }
            ElevatedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Surface(color = MaterialTheme.colorScheme.primary) {
//        Text (text = "Hello $name!", Modifier.padding(24.dp))
//    }
//}

//@Composable
//private fun MyApp(modifier: Modifier = Modifier) {
//    Surface(
//        modifier = modifier,
//        color = MaterialTheme.colorScheme.background
//    ) {
//        Greeting("Android TV")
//    }
//}

//@Preview(showBackground = true , name = "Text Android")
//@Composable
//fun GreetingAndroidPreview() {
//    App_androidTheme {
//        Greeting("Android")
//    }
//}

//@Preview(showBackground = true, name = "Text iOS")
//@Composable
//fun GreetingIosPreview() {
//    App_androidTheme {
//        Greeting("iOS")
//    }
//}

//@Preview(showBackground = true, widthDp = 320)
//@Composable
//fun Default1Preview() {
//    App_androidTheme {
//        MyApp()
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun Default2Preview() {
//    App_androidTheme {
//        MyApp()
//    }
//}