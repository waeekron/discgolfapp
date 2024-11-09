package com.github.waeekron.discgolf_app.ui.newgame

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JoinGame() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface) {
        var gameCode by remember { mutableStateOf("18") }
        Column(verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.CenterHorizontally) {
            Column {
                Spacer(Modifier.height(88.dp))
                Text("JOIN GAME", fontSize = 44.sp, fontWeight = FontWeight.Bold , textAlign = TextAlign.Start, color = MaterialTheme.colorScheme.inverseSurface,modifier = Modifier.fillMaxWidth(0.8f))
                Spacer(Modifier.height(44.dp))
                OutlinedTextField(value = gameCode, onValueChange = {
                    gameCode = it
                },
                    label = { Text("Game code") },
                    supportingText = { Text("Enter the game code to join", fontWeight = FontWeight.Bold) },
                    modifier = Modifier.fillMaxWidth(0.8f), colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.secondaryContainer))

            }
            Button({}, modifier = Modifier.fillMaxWidth(.8f), colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer, contentColor = MaterialTheme.colorScheme.onPrimaryContainer), contentPadding = PaddingValues(24.dp, 18.dp) ) {
                Text("Join game", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }

    }

}