package com.example.shoppinglist.settings_screen

import androidx.compose.ui.graphics.Color
import com.example.shoppinglist.ui.theme.Green
import com.example.shoppinglist.ui.theme.Orange
import com.example.shoppinglist.ui.theme.Red

object ColorUtils {
    val colorList = listOf(
        "#03A9F4",
        "#F4039C",
        "#03F453",
        "#668096",
        "#041CF6",
        "#774080"
    )

    fun getProgressColor(progress: Float): Color {
        return when(progress) {
            in 0.0..0.339 -> Red
            in 0.34..0.669 -> Orange
            in 0.67..1.0 -> Green
            else -> Red
        }
    }
}