package com.aqua30.whatsapp.chatscreen.design.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aqua30.whatsapp.chatscreen.design.R
import com.aqua30.whatsapp.chatscreen.design.components.AppBar
import com.aqua30.whatsapp.chatscreen.design.components.TabBar
import com.aqua30.whatsapp.chatscreen.design.ui.theme.PrimaryGreen_A102
import com.aqua30.whatsapp.chatscreen.design.ui.theme.WhatsappChatScreenDesignTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WhatsappHomeScreen() {
    val viewPagerState = rememberPagerState(0)
    val scope = rememberCoroutineScope()
    var actionButtonDrawable by remember {
        mutableStateOf(R.drawable.ic_chat_filled)
    }

    WhatsappChatScreenDesignTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column {
                AppBar()
                TabBar(
                    initialIndex = 0,
                    pagerState = viewPagerState
                ) { selectedTab ->
                    scope.launch {
                        when (selectedTab) {
                            0 -> actionButtonDrawable = R.drawable.ic_chat_filled
                            1 -> actionButtonDrawable = R.drawable.ic_camera
                            2 -> actionButtonDrawable = R.drawable.ic_add_call
                        }
                        viewPagerState.animateScrollToPage(selectedTab)
                    }
                }
                HorizontalPager(
                    pageCount = 3,
                    beyondBoundsPageCount = 3,
                    state = viewPagerState,
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .fillMaxSize(),
                ) { page ->
                    when (page) {
                        0 -> ChatListScreen()
                        1 -> StatusListScreen()
                        2 -> CallsListScreen()
                    }
                }
            }
            FloatingActionButton(
                onClick = {},
                modifier = Modifier
                    .padding(16.dp)
                    .size(60.dp)
                    .align(Alignment.BottomEnd),
                shape = CircleShape,
            backgroundColor = PrimaryGreen_A102
            ) {
                Icon(
                    painter = painterResource(actionButtonDrawable),
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    }
}