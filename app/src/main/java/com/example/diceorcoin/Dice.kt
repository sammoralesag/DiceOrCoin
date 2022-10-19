package com.example.diceorcoin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Dice(modifier: Modifier = Modifier) {
    var result by rememberSaveable {
        mutableStateOf(1)
    }
    val diceResult = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
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
                    painter = painterResource(id = diceResult),
                    contentDescription = "heads",
                    modifier = modifier.size(160.dp),
                    alignment = Alignment.BottomCenter
                )
            }
        }
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { result = (1..6).random() }) {
                Text(text = "Play")
            }
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = modifier.padding(20.dp)) {
                    when (result) {
                        1 -> Text(
                            text = "You got 1",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        2 -> Text(
                            text = "You got 2",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        3 -> Text(
                            text = "You got 3",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        4 -> Text(
                            text = "You got 4",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        5 -> Text(
                            text = "You got 5",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        else -> Text(
                            text = "You got 6",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
