package com.example.shoppinglist.note_list_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppinglist.R
import com.example.shoppinglist.data.NoteItem
import com.example.shoppinglist.ui.theme.BlueLight
import com.example.shoppinglist.ui.theme.LightText
import com.example.shoppinglist.ui.theme.Red
import com.example.shoppinglist.utils.Routes
import com.example.shoppinglist.utils.UiEvent

@Composable
fun UiNoteItem(
    titleColor: String,
    item: NoteItem,
    onEvent: (NoteListEvent) -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(
            start = 3.dp,
            top = 3.dp,
            end = 3.dp
        )
        .clickable {
            onEvent(
                NoteListEvent.OnItemClick(
                    Routes.NEW_NOTE + "/${item.id}"
                )
            )
        }) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .padding(
                            top = 10.dp,
                            start = 10.dp
                        )
                        .weight(1f),
                    text = item.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(android.graphics.Color.parseColor(titleColor))
                )
                Text(
                    modifier = Modifier.padding(
                        top = 10.dp,
                        end = 10.dp
                    ),
                    text = item.time,
                    color = BlueLight,
                    fontSize = 12.sp
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .padding(
                            start = 10.dp,
                            top = 5.dp,
                            bottom = 10.dp
                        )
                        .weight(1f),
                    text = item.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = LightText
                )
                IconButton(onClick = {
                    onEvent(NoteListEvent.OnShowDeleteDialog(item))
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.delete_icon),
                        contentDescription = "Delete note",
                        tint = Red
                    )
                }
            }
        }

    }
}