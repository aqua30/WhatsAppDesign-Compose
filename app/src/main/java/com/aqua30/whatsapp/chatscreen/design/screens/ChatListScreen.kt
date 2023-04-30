package com.aqua30.whatsapp.chatscreen.design.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aqua30.whatsapp.chatscreen.design.components.RemoteImage
import com.aqua30.whatsapp.chatscreen.design.components.UserAndMessageDetails
import com.aqua30.whatsapp.chatscreen.design.data.chatListItems
import com.aqua30.whatsapp.chatscreen.design.domain.model.ChatListData

@Composable
fun ChatListScreen() {

    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        item {
            Spacer(modifier = Modifier.height(4.dp))
        }
        items(
            items = chatListItems,
            key = { chatData ->
                chatData.chatId
            }
        ) { chatData ->
            ChatListItem(chatData)
        }
        item {
            Spacer(modifier = Modifier.height(75.dp))
        }
    }
}

@Composable
fun ChatListItem(chatData: ChatListData) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RemoteImage(chatData.userImage)
        UserAndMessageDetails(chatData)
    }
}