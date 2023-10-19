package com.example.shoppinglist.about_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppinglist.R
import com.example.shoppinglist.ui.theme.BlueLight

@Preview(showBackground = true)
@Composable
fun AboutScreen() {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.smile_icon),
            contentDescription = "Smile",
            tint = Color.DarkGray,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "The application is made according\n" +
                    "to the course from \"N.E.C.O\" \n" +
                    "Version - 1.0\n",
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
        Text(
            modifier = Modifier
                .padding(10.dp)
                .clickable {
                    uriHandler.openUri("https://github.com/anmischenko")
                },
            text = "github - anmischenko",
            color = BlueLight,
            fontSize = 20.sp
        )
    }
}