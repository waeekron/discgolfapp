package com.github.waeekron.discgolf_app

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.waeekron.discgolf_app.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            val currentBackStack by navController.currentBackStackEntryAsState()
            val currentDestination = currentBackStack?.destination

           AppTheme {
                Scaffold( modifier = Modifier.fillMaxSize(), bottomBar = { BottomNavigation(navController)
               }) { innerPadding ->
                    Navigation(navController = navController, modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf("Start", "Join")
    var selectedIdx by rememberSaveable { mutableIntStateOf(0) }


    NavigationBar() {
        items.forEachIndexed {idx, item ->
            NavigationBarItem(
                selected = selectedIdx ==-1,
                onClick = {
                    selectedIdx = idx
                     if(idx == 0) navController.navigate("start-game")
                    if(idx == 1) navController.navigate("join-game")
                          },
                label = { Text(item, fontSize = 20.sp, fontWeight = if (selectedIdx == idx) FontWeight.Bold else FontWeight.Light)},
                icon = {}
            )
        }
    }
}