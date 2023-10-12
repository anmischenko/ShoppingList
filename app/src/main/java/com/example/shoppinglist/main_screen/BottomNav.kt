package com.example.shoppinglist.main_screen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.shoppinglist.ui.theme.BlueLight
import com.example.shoppinglist.ui.theme.GreyLight

@Composable
fun BottomNav() {
    val listItems = listOf(
        BottomNavItem.ListItem,
        BottomNavItem.NoteItem,
        BottomNavItem.AboutItem,
        BottomNavItem.SettingsItem
    )
    BottomNavigation(backgroundColor = Color.White) {
        listItems.forEach {
            BottomNavigationItem(
                selected = false,
                onClick = { },
                icon = {
                    Icon(
                        painter = painterResource(id = it.iconId),
                        contentDescription = "icon"
                    )
                },
                label = {
                    Text(text = it.title)
                },
                // Выбранный элемент
                selectedContentColor = BlueLight,
                // Все элементы, которые не выбраны
                unselectedContentColor = GreyLight,
                // Показывать заголовок только выбранного
                alwaysShowLabel = false

            )
        }
    }
}