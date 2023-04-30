package com.aqua30.whatsapp.chatscreen.design.domain.model

import com.aqua30.whatsapp.chatscreen.design.domain.StatusUpdateCategory

data class StatusListData(
    val id: Int,
    val category: StatusUpdateCategory,
    val statusImage: String? = null,
    val statusCount: Int? = null,
    val userName: String,
    val timeStamp: String,
)