package com.example.diceorcoin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.diceorcoin.ui.theme.DiceOrCoinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceOrCoinTheme {
                val vm: MainViewModel = viewModel()
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Header(modifier = Modifier.fillMaxWidth(), vm = vm)
                    Title()
                    Spacer(modifier = Modifier.size(60.dp))
                    Body(modifier = Modifier, vm)
                }

            }
        }
    }
}

@Composable
fun Title() {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Lucky Game",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5C5E5C),
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Composable
fun Header(modifier: Modifier = Modifier, vm: MainViewModel) {
    val viewState = remember { vm.containerState }

    Row(modifier = modifier) {
        Tabs(
            title = "First View", modifier = Modifier
                .weight(1f)
                .background(Color.DarkGray), isSelected = viewState.value == MainViewState.Coin
        ) {
            vm.switchView(MainViewState.Coin)
        }
        Tabs(
            title = "Second View", modifier = Modifier
                .weight(1f)
                .background(Color.DarkGray), isSelected = viewState.value == MainViewState.Dice

        ) {
            vm.switchView(MainViewState.Dice)
        }
    }

}

@Composable
private fun Body(modifier: Modifier = Modifier, vm: MainViewModel) {
    val viewState = remember { vm.containerState }
    Box(modifier = modifier) {
        when (viewState.value) {
            MainViewState.Coin -> {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    verticalArrangement = Arrangement.Center
                ) {
                    Coin()
                }
            }
            MainViewState.Dice -> {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    verticalArrangement = Arrangement.Center
                ) {
                    Dice()
                }
            }
        }
    }
}


@Composable
fun Tabs(
    modifier: Modifier = Modifier,
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    Box(modifier = modifier
        .clickable {
            onClick.invoke()
        }
        .background(if (isSelected) Color.DarkGray else Color.LightGray)
        .height(60.dp)) {
        Text(text = title, modifier = Modifier.align(Alignment.Center), color = Color.White)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiceOrCoinTheme {

    }
}
