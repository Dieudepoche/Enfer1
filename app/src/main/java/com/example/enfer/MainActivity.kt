package com.example.enfer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.enfer.ui.composables.Cellule
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
    var textColonnes: Int? by remember { mutableStateOf(2) }
    var textLignes: Int? by remember { mutableStateOf(2) }

    var safeTextColonnes by remember {
        mutableIntStateOf(2)
    }
    var safeTextLignes by remember {
        mutableIntStateOf(2)
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
                        Cellule(modifier = Modifier.weight(1f))

                    }

                }

            }

        }



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        ) {
            Row(

                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {



                    OutlinedTextField(
                        label = {
                            Text(
                                text = "Nombre de colonnes",
                                fontSize = 15.sp
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.75f),
                        value = textColonnes?.toString() ?: "",
                        onValueChange = {
                            textColonnes = it.toIntOrNull()

                        },
                        placeholder = {
                            Text("Entrer le nombre de colonnes")
                        },
                        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

                    )


                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {


                    OutlinedTextField(
                        label = {
                            Text(
                                "Nombre de lignes",
                                fontSize = 15.sp
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.75f),
                        value = textLignes?.toString() ?: "",
                        onValueChange = {
                            textLignes = it.toIntOrNull()
                        },
                        placeholder = {
                            Text("Entrer le nombre de lignes")
                        },
                        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)


                    )


                }


            }


        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxWidth()
        ) {
            OutlinedButton(onClick = {
                safeTextColonnes = textColonnes ?: 1
                safeTextLignes = textLignes ?: 1
                Modifier.background(Color.DarkGray)
            })
            {
                Text(text = "Rafraîchir")
            }

        }

    }

}


fun randomColor() = Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256), 255)


