package com.shmulik.newsiron.navigaion


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.shmulik.newsiron.ui.page.feed.FeedPage


@Composable
fun MainGraph(
    mainNavController: NavHostController
) {

    NavHost(
        navController = mainNavController,
        startDestination = Route.MainNewsRoute,
        route = Graph.Main::class

    ) {
        navigation<Route.MainNewsRoute>(startDestination = Route.FeedRoute) {
            composable<Route.FeedRoute> {
                FeedPage()
            }


        }
    }
}