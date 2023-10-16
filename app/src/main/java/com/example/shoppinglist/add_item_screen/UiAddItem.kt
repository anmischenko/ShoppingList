package com.example.shoppinglist.add_item_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppinglist.R
import com.example.shoppinglist.data.AddItem

@Composable
fun UiAddItem(
    item: AddItem,
    onEvent: (AddItemEvent) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp)
            .clickable {
                onEvent(AddItemEvent.onShowEditDialog(item))
            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp),
                text = item.name,
                fontSize = 12.sp
            )
            Checkbox(
                checked = item.isCheck,
                onCheckedChange = { isChecked ->
                    onEvent(AddItemEvent.onCheckedChange(item.copy(isCheck = isChecked)))
                }
            )
            IconButton(onClick = {
                onEvent(AddItemEvent.onDelete(item))
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.delete_icon),
                    contentDescription = "Delete item"
                )
            }
        }
    }
}