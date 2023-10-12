package com.example.shoppinglist.main_screen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shoppinglist.ui.theme.BlueLight
import com.example.shoppinglist.ui.theme.GreyLight

@Composable
fun BottomNav(navController: NavHostController) {
    val listItems = listOf(
        BottomNavItem.ListItem,
        BottomNavItem.NoteItem,
        BottomNavItem.AboutItem,
        BottomNavItem.SettingsItem
    )
    BottomNavigation(backgroundColor = Color.White) {
        listItems.forEach {
            // Какой экран в данный момент открыт
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            // Экран, который в данный момент выбран
            val currentRoute = navBackStackEntry?.destination?.route
            BottomNavigationItem(
                selected = currentRoute == it.route,
                onClick = {
                          navController.navigate(it.route)
                },
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