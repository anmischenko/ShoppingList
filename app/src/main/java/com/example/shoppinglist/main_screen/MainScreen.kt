package com.example.shoppinglist.main_screen

import android.annotation.SuppressLint
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.shoppinglist.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = {
            BottomNav()
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

    }
}