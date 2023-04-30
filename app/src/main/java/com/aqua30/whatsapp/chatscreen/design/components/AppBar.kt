package com.aqua30.whatsapp.chatscreen.design.components

import androidx.annotation.DimenRes
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aqua30.whatsapp.chatscreen.design.R
import com.aqua30.whatsapp.chatscreen.design.ui.theme.PrimaryGray_A101
import com.aqua30.whatsapp.chatscreen.design.ui.theme.White

@Composable
fun AppBar(
    @DimenRes height: Int = R.dimen.app_bar_height,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(height))
            .background(MaterialTheme.colors.primary)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.whatsapp_title),
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (isSystemInDarkTheme()) PrimaryGray_A101 else White
            )
        )

        Spacer(modifier = Modifier.weight(1f))
        ActionIcon(id = R.drawable.ic_camera_outline)
        Spacer(modifier = Modifier.width(20.dp))
        ActionIcon(id = R.drawable.ic_search_outline)
        Spacer(modifier = Modifier.width(16.dp))
        ActionIcon(id = R.drawable.ic_overflow_filled)

    }
}

@Composable
fun ActionIcon(id: Int) {
    Icon(
        painter = painterResource(id),
        contentDescription = "",
        tint = if (isSystemInDarkTheme()) PrimaryGray_A101 else White
    )
}