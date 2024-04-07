package com.example.enfer.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.enfer.randomColor

@Composable
fun Cellule(modifier: Modifier = Modifier) {
    var nbClic: Int by remember { mutableStateOf(0) }
    val backgroundColor by remember(nbClic) {
        mutableStateOf(
            if (nbClic % 2 == 0) Color.White else randomColor()
        )
    }
    Box(modifier = modifier
        .fillMaxHeight()
        .border(1.dp, Color.Black)
        .clickable {
            nbClic++
        }
        .background(backgroundColor)
    )

}