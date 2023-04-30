package com.aqua30.whatsapp.chatscreen.design.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aqua30.whatsapp.chatscreen.design.R
import com.aqua30.whatsapp.chatscreen.design.ui.theme.PrimaryGreen
import com.aqua30.whatsapp.chatscreen.design.ui.theme.White

@Composable
fun StatusImageSection(
    isOwner: Boolean = false,
    statusCount: Int? = null,
    statusImage: String? = null
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        // status image
        if (isOwner) {
            Image(
                painter = painterResource(id = R.drawable.img_default_user),
                contentDescription = "default user image",
                modifier = Modifier
                    .size(50.dp)
                    .border(1.dp, White, CircleShape)
                    .clip(CircleShape),
            )
        } else {
            RemoteImage(
                imageUrl = statusImage,
                hasBorder = true
            )
        }

        // status indicator or add icon
        statusCount?.let {
            StatusIndicator()
        } ?: if (isOwner) {
            AddIcon(
                modifier = Modifier.align(Alignment.BottomEnd),
            )
        } else { /*show nothing*/
            Log.e("Tag","status not shown")
        }
    }
}

@Composable
fun StatusIndicator() {
    Box(modifier = Modifier
        .background(Color.Transparent)
        .size(50.dp)
        .border(2.dp, PrimaryGreen, CircleShape)
        .clip(CircleShape),
    )
}

@Composable
private fun AddIcon(
    modifier: Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_plus),
        contentDescription = "Add Status",
        modifier = modifier
            .size(20.dp)
            .border(1.dp, White, CircleShape)
            .clip(CircleShape)
            .background(PrimaryGreen),
        tint = White
    )
}

@Preview
@Composable
fun AddMyStatusPreview() {
    StatusImageSection()
}