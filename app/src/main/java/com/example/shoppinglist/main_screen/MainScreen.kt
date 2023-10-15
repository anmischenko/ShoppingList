package com.example.shoppinglist.main_screen

import android.annotation.SuppressLint
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shoppinglist.R
import com.example.shoppinglist.dialog.MainDialog
import com.example.shoppinglist.navigation.NavigationGraph
import com.example.shoppinglist.shopping_list_screen.ShoppingListViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    mainNavHostController: NavHostController,
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNav(navController)
        },
        floatingActionButton = {
            // Круглая кнопка
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(MainScreenEvent.OnShowEditDialog)
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "Add",
                    tint = Color.White
                )

            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        // Поверх bottomNav
        isFloatingActionButtonDocked = true
    ) {
        // Отвечает за то, какой экран показать
        NavigationGraph(navController) { route ->
            mainNavHostController.navigate(route)
        }
        MainDialog(viewModel)
    }
}