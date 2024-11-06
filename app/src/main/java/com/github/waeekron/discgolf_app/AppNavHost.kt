package com.github.waeekron.discgolf_app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.github.waeekron.discgolf_app.ui.gamestart.GameJoin
import com.github.waeekron.discgolf_app.ui.gamestart.GameStart

// Destinations
data object StartGame: AppRoute {
   override val route = "start-game"
}
data object JoinGame: AppRoute {
    override val route = "join-game"
}
interface AppRoute {
    val route: String

}

@Composable
fun Navigation(navController: NavHostController,
               modifier: Modifier = Modifier
) {

    NavHost(navController = navController, startDestination = "new-game", modifier = modifier) {
        navigation(startDestination = StartGame.route, route="new-game") {
            composable(route=StartGame.route) {
                GameStart()
            }
            composable(route=JoinGame.route) {
                GameJoin()
            }
        }

    }
}