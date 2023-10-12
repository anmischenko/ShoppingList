package com.example.shoppinglist.main_screen

import android.annotation.SuppressLint
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.example.shoppinglist.R
import com.example.shoppinglist.navigation.NavigationGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNav(navController)
        },
        floatingActionButton = {
            // Круглая кнопка
            FloatingActionButton(onClick = { }) {
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
        NavigationGraph(navController)
    }
}