package com.example.shoppinglist.add_item_screen

import com.example.shoppinglist.data.AddItem

sealed class AddItemEvent {
    data class onDelete(val item: AddItem) : AddItemEvent()
    data class onShowEditDialog(val item: AddItem) : AddItemEvent()
    data class onTextChange(val item: AddItem) : AddItemEvent()
    data class onCheckedChange(val item: AddItem) : AddItemEvent()
    object onItemSave : AddItemEvent()
}
