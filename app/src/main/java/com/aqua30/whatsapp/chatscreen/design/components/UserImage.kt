package com.aqua30.whatsapp.chatscreen.design.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aqua30.whatsapp.chatscreen.design.R

@Composable
fun RemoteImage(
    imageUrl: String? = null,
    hasBorder: Boolean = false,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .placeholder(R.drawable.img_default_user)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = null,
        modifier = Modifier
            .size(50.dp)
            .padding(if (hasBorder) 4.dp else 0.dp)
            .clip(CircleShape)
    )
}