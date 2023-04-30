package com.aqua30.whatsapp.chatscreen.design.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColors(
    primary = PrimaryGray,
    secondary = SecondaryGray,
    background = SecondaryGray,
)

private val LightColorScheme = lightColors(
    primary = PrimaryGreen,
    secondary = SecondaryGreen,
    background = White,
)

@Composable
fun WhatsappChatScreenDesignTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        val systemUiController = rememberSystemUiController()
        val statusBarColor = if (isSystemInDarkTheme()) {
            PrimaryGray
        } else {
            PrimaryGreen
        }
        val navigationBarColor = if (isSystemInDarkTheme()) {
            SecondaryGray_10
        } else {
            White_100
        }
        SideEffect {
            systemUiController.setStatusBarColor(
                statusBarColor
            )
            systemUiController.setNavigationBarColor(
                navigationBarColor
            )
        }
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}