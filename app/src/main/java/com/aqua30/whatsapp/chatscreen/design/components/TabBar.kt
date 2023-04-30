package com.aqua30.whatsapp.chatscreen.design.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aqua30.whatsapp.chatscreen.design.R
import com.aqua30.whatsapp.chatscreen.design.data.Tabs
import com.aqua30.whatsapp.chatscreen.design.data.homeTabs
import com.aqua30.whatsapp.chatscreen.design.ui.theme.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabBar(
    initialIndex: Int = 0,
    pagerState: PagerState,
    onTabSelected: (Int) -> Unit,
) {

    var selectedPage by remember {
        mutableStateOf(initialIndex)
    }

    var isTabClicked by remember {
        mutableStateOf(false)
    }

    var statusIndicatorVisible by remember {
        mutableStateOf(true)
    }

    var callIndicatorVisible by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { currentPage ->
            if (isTabClicked) {
                isTabClicked = false
                return@collect
            }
            onTabSelected(currentPage)
            selectedPage = currentPage
            if (statusIndicatorVisible && selectedPage == 1) {
                statusIndicatorVisible = false
            }

            if (callIndicatorVisible && selectedPage == 2) {
                callIndicatorVisible = false
            }
        }
    }

    TabRow(
        modifier = Modifier.fillMaxWidth(),
        selectedTabIndex = selectedPage,
        backgroundColor = MaterialTheme.colors.primary,
        divider = {},
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[selectedPage]),
                color = if (isSystemInDarkTheme()) PrimaryGreen else White,
                height = 2.5.dp
            )
        }
    ) {
        homeTabs.forEachIndexed { index, tabData ->
            Tab(
                selected = index == selectedPage,
                onClick = {
                    selectedPage = index
                    onTabSelected(selectedPage)
                    isTabClicked = true
                    if (statusIndicatorVisible && selectedPage == 1) {
                        statusIndicatorVisible = false
                    }

                    if (callIndicatorVisible && selectedPage == 2) {
                        callIndicatorVisible = false
                    }
                },
                modifier = Modifier.height(dimensionResource(id = R.dimen.tab_bar_height)),
                selectedContentColor = if (isSystemInDarkTheme()) PrimaryGreen else White,
                unselectedContentColor = if (isSystemInDarkTheme()) PrimaryGray_A101 else PrimaryGreen_A101,
            ) {

                tabData.unreadCount?.let { count ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = tabData.tab.value,
                            style = TextStyle(
                                fontSize = 16.sp,
                            )
                        )
                        if (tabData.tab.sameAs(Tabs.MESSAGE_STATUS)) {
                            AnimatedVisibility(visible = statusIndicatorVisible) {
                                TabIndicator()
                            }
                        } else {
                            AnimatedVisibility(visible = callIndicatorVisible) {
                                UnreadCountIndicator(count)
                            }
                        }
                    }
                }?: Text(
                    text = tabData.tab.value,
                    style = TextStyle(
                        fontSize = 16.sp,
                    )
                )
            }
        }
    }
}

@Composable
fun TabIndicator() {
    Box(
        modifier = Modifier
            .padding(start = 4.dp)
            .size(5.dp)
            .clip(CircleShape)
            .background(
                if (isSystemInDarkTheme()) {
                    PrimaryGray_A101
                } else {
                    PrimaryGreen_A101
                },
            )
    )
}

@Composable
fun UnreadCountIndicator(count: Int) {
    Text(
        text = count.toString(),
        style = TextStyle(
            fontSize = 12.sp,
            color = if (isSystemInDarkTheme()) PrimaryGray else SecondaryGray_20,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier
            .padding(4.dp)
            .size(16.dp)
            .clip(CircleShape)
            .background(
                if (isSystemInDarkTheme()) {
                    PrimaryGray_A101
                } else {
                    PrimaryGreen_A101
                },
            ),
    )
}