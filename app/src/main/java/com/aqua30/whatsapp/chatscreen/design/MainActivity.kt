package com.aqua30.whatsapp.chatscreen.design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.aqua30.whatsapp.chatscreen.design.screens.WhatsappHomeScreen
import com.aqua30.whatsapp.chatscreen.design.ui.theme.WhatsappChatScreenDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsappChatScreenDesignTheme {
                WhatsappHomeScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WhatsappChatScreenDesignTheme {
        WhatsappHomeScreen()
    }
}