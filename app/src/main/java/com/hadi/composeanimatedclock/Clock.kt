package com.hadi.composeanimatedclock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

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
        NumberColumn(0..9, time.hours % 10)

    }

}

@Composable
@Preview
fun ClockPreview() {
    Clock(Time(14, 16, 59))
}