package jp.co.atsutama2.app_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background,
//                ) {
//                    Greeting("Android & iOS")
//                }
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = MaterialTheme.colorScheme.primary) {
        Text (text = "Hello $name!", Modifier.padding(24.dp))
    }
}

@Composable
private fun MyApp(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting("Android TV")
    }
}

@Preview(showBackground = true , name = "Text Android")
@Composable
fun GreetingAndroidPreview() {
    App_androidTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true, name = "Text iOS")
@Composable
fun GreetingIosPreview() {
    App_androidTheme {
        Greeting("iOS")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App_androidTheme {
        MyApp()
    }
}