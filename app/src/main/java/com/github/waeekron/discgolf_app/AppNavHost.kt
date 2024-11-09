package com.github.waeekron.discgolf_app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.github.waeekron.discgolf_app.ui.newgame.JoinGame
import com.github.waeekron.discgolf_app.ui.newgame.CreateGame

// Destinations
data object CreateGame: AppRoute {
   override val route = "create-game"
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
        navigation(startDestination = CreateGame.route, route="new-game") {
            composable(route=CreateGame.route) {
                CreateGame()
            }
            composable(route=JoinGame.route) {
                JoinGame()
            }
        }

    }
}