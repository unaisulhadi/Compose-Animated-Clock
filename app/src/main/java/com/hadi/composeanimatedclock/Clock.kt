package com.hadi.composeanimatedclock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import java.util.*

@Composable
fun Clock(time: Time) {

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        NumberColumn(0..2, time.hours / 10)
        NumberColumn(0..9, time.hours % 10)
        NumberColumn(0..5, time.minutes / 10)
        NumberColumn(0..9, time.minutes % 10)
        NumberColumn(0..5, time.seconds / 10)
        NumberColumn(0..9, time.seconds % 10)

    }

}

@Composable
@Preview
fun ClockScreen() {
    fun currentTime(): Time {
        val cal = Calendar.getInstance()
        return Time(
            hours = cal.get(Calendar.HOUR_OF_DAY),
            minutes = cal.get(Calendar.MINUTE),
            seconds = cal.get(Calendar.SECOND),
        )
    }

    var time by remember { mutableStateOf(currentTime()) }
    LaunchedEffect(0) {
        while (true) {
            time = currentTime()
            delay(1000)
        }
    }

    Clock(time)
}