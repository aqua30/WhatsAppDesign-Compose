package com.aqua30.whatsapp.chatscreen.design.domain.model

data class ChatListData(
    val chatId: Int,
    val userImage: String? = null,
    val userName: String,
    val deliveryStatus: MessageDeliveryStatus? = null,
    val messageType: MessageType,
    val timeStamp: String,
    val lastMessageSentByMe: Boolean,
    val message: String? = null,
    val unreadCount: Int? = null
)

enum class MessageType {
    TEXT,
    VIDEO,
    IMAGE,
    AUDIO,
    REACTION,
}

enum class MessageDeliveryStatus {
    NOT_SENT,
    PENDING,
    DELIVERED,
    READ
}
