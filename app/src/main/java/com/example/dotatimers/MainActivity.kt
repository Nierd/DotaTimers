package com.example.dotatimers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
fun TimerCard(firstWarning: Int, secondWarning: Int){
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
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Dota Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.align(Alignment.TopCenter)

                )
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
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.BottomCenter)
                )

            }
            Spacer(modifier= Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { placeholder() },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end=4.dp)
                ) {
                    Text(text = "Reset")
                }
                Button(
                    onClick = {placeholder()},
                    modifier = Modifier
                        .weight(1f)
                        .padding(end=4.dp)
                ){
                    Text(text = "Start")
                }
            }
        }
    }
}

fun placeholder(){

}

@Composable
@Preview
fun TimerCardPreview(){
    TimerCard(500, 50)
}