package com.example.diceorcoin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Coin(modifier: Modifier = Modifier) {

    var result by rememberSaveable { mutableStateOf(1) }
    val coinResult = if (result == 1) {
        R.drawable.heads
    } else {
        R.drawable.tails
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            modifier

                .padding(16.dp)
        ) {
            Box(
                modifier = modifier


            ) {
                Image(
                    painter = painterResource(id = coinResult),
                    contentDescription = "heads",
                    modifier = modifier.size(200.dp),
                    alignment = Alignment.BottomCenter
                )
            }
        }
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { result = (1..2).random() }) {
                Text(text = "Play")
            }
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = modifier.padding(20.dp)) {
                    if (result == 1) {
                        Text(
                            text = "You got Heads",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4EA8E9)

                        )
                    } else {
                        Text(
                            text = "You got Tails",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFCC4357)
                        )
                    }
                }
            }


        }


    }
}


