package jp.co.atsutama2.app_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jp.co.atsutama2.app_android.components.CompanySection
import jp.co.atsutama2.app_android.components.DetailSection
import jp.co.atsutama2.app_android.ui.theme.App_androidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_androidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_profile),
            contentDescription = "プロフィール",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(100.dp)),
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Atsutama",
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "職業：Androidエンジニア",
            color = Color.Gray,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.height(20.dp))

        CompanySection()
        Spacer(modifier = Modifier.height(20.dp))

        var isShowDetail by remember { mutableStateOf(false) }
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFF85F6A),
            ),
            onClick = { isShowDetail = !isShowDetail },
        ) {
            Text(
                text = "詳細を表示",
                color = Color.White,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        if (isShowDetail) {
            DetailSection()
        }
    }
}
