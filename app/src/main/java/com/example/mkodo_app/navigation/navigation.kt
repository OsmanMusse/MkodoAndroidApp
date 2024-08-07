package com.example.mkodo_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.mkodo_app.domain.DrawModelClass
import com.example.mkodo_app.presentation.drawsList.DrawListScreen
import com.example.mkodo_app.presentation.drawsListDetail.DrawsListDetailScreen
import kotlin.reflect.typeOf

@Composable
fun Navigation(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = NavRoute.MainScreen){
        composable<NavRoute.MainScreen>(){
            DrawListScreen(
                onButtonClick = { drawData ->
                    navigationController.navigate(NavRoute.DetailScreen(drawData))
                }
            )
        }

        composable<NavRoute.DetailScreen>(
            typeMap = mapOf(typeOf<DrawModelClass>() to NavType.fromCustom<DrawModelClass>())
        ){
            val args = it.toRoute<NavRoute.DetailScreen>()
            val draw = args.draw
            DrawsListDetailScreen(
                onBackClick = { navigationController.popBackStack() },
                draw = draw
            )
        }
    }
}