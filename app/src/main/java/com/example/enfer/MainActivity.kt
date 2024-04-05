package com.example.lenfer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.enfer.ui.theme.EnferTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnferTheme {
                grille()


            }
        }
    }
}


@Composable


fun grille() {
    var textColonnes: Int? by remember { mutableStateOf(7) }
    var textLignes: Int? by remember { mutableStateOf(5) }

    val safeTextColonnes by remember(textColonnes) {
        mutableIntStateOf(textColonnes ?: 1)
    }
    val safeTextLignes by remember(textLignes) {
        mutableIntStateOf(textLignes ?: 1)
    }

    Column(
        Modifier.fillMaxSize()
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        ) {
            (1..safeTextLignes).forEach {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    (1..safeTextColonnes).forEach {
                        var clik by remember { mutableStateOf(Color.White) }
                        Box(
                            Modifier
                                .fillMaxHeight()
                                .weight(1f)
                                .clickable {
                                    clik = Color(
                                        Random.nextInt(256),
                                        Random.nextInt(256),
                                        Random.nextInt(256),
                                        255
                                    )
                                }
                                .background(clik)
                                .border(1.dp, Color.Black)
                        )

                    }

                }

            }

        }



        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        ) {
            Row(

                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Column(
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "Nombre de colonnes",
                        Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    )


                    TextField(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        value = textColonnes?.toString() ?: "",
                        onValueChange = {
                            textColonnes = it.toIntOrNull()

                        },
                        placeholder = {
                            Text("Entrer le nombre de colonnes")
                        },

                        )


                }

                Column(
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "Nombre de lignes",
                        Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    )


                    TextField(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        value = textLignes?.toString() ?: "",
                        onValueChange = {
                            textLignes = it.toIntOrNull()
                        },
                        placeholder = {
                            Text("Entrer le nombre de lignes")
                        },

                        )


                }


            }


        }

    }

}

@Composable

fun Cell() {
    var nbClic : Int by remember { mutableStateOf(0) }
    val backgroundColor by remember(nbClic){
        mutableStateOf(
            if(nbClic % 2 == 0) Color.White else randomColor()
        )
    }
}

fun randomColor() = Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256), 255)

