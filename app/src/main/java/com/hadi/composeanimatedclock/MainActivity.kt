package com.hadi.composeanimatedclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hadi.composeanimatedclock.ui.theme.ComposeAnimatedClockTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimatedClockTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Number(3, false)
                }
            }
        }
    }
}

@Composable
fun Number(value: Int, active: Boolean) {
    val backgroundColor = if (active) {
        MaterialTheme.colors.primary
    } else {
        MaterialTheme.colors.primaryVariant
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(40.dp)
            .background(backgroundColor),
    ) {
        Text(
            text = value.toString(),
            fontSize = 20.sp,
            color = Color.White,
        )
    }
}


@Composable
fun NumberColumn(
    range: IntRange,
    current: Int
) {

    Column(
        modifier = Modifier.clip(RoundedCornerShape(percent = 25))
    ) {
        range.forEach { num ->
            Number(value = num, active = num == current)
        }
    }

}


@Composable
@Preview
fun NumberColumnPreview() {
    NumberColumn(range = 0..9, current = 5)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Column {
        Number(value = 3, active = true)
        Number(value = 7, active = false)
    }
}