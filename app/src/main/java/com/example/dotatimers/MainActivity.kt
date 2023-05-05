package com.example.dotatimers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dotatimers.ui.theme.DotaTimersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DotaTimersTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                }
            }
        }
    }
}

@Composable
fun Timer(firstWarning: Int, secondWarning: Int){
    val number = 100
    Surface(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            Box(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            ){
                Text(
                    text = "100",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = if (number >= firstWarning){
                            MaterialTheme.colorScheme.error
                        }else if (number >= secondWarning) {
                            MaterialTheme.colorScheme.error
                        }else{
                            MaterialTheme.colorScheme.onBackground
                        }
                    ),
                    modifier = Modifier.align(Alignment.Center)
                )

            }
            Spacer(modifier= Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = { placeholder() },
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    Text(text = "Button")
                }
            }
        }
    }
}

fun placeholder(){

}

@Composable
@Preview
fun TimerPreview(){
    Timer(500, 50)
}