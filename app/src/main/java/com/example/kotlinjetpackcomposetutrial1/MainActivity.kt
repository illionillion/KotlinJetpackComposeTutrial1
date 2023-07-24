package com.example.kotlinjetpackcomposetutrial1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinjetpackcomposetutrial1.ui.theme.KotlinJetpackComposeTutrial1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinJetpackComposeTutrial1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Text("Hello World")
                    MessageCard(Message("Android", "Hello, Jetpack Compose"))
                }
            }
        }
    }
}

data class Message (val author: String, val body: String)

@Composable // @Composableでコンポーズ可能な関数を作成
fun MessageCard (msg: Message, dir: String = "Column") {
//    Text(text = "Hi $name")
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.my_profile_picture),
            contentDescription = "My Profile Picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Box {
            when (dir) {
                "Column" -> {
                    // これで2列にして被らないようにする
                    Column {
                        Text(msg.author)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(msg.body)
                    }
                }
                "Row" -> {
                    Row {
                        Text(msg.author)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(msg.body)
                    }
                }
                else -> {
                    Box {
                        Text(msg.author)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(msg.body)
                    }
                }
            }
        }
    }


}

@Preview
@Composable
fun PreviewMessageCard () { // MessageCardをラッパーしただけ？
    MessageCard(Message("Kotlin", "Hello, I am Kotlin"), "Column")
}

@Preview
@Composable
fun PreviewMessageCardRow () { // MessageCardをラッパーしただけ？
    MessageCard(Message("Kotlin", "Hello, I am Kotlin"), "Row")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinJetpackComposeTutrial1Theme {
        Greeting("Android")
    }
}