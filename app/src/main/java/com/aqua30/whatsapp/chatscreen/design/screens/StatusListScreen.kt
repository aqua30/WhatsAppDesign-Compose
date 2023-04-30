package com.aqua30.whatsapp.chatscreen.design.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aqua30.whatsapp.chatscreen.design.R
import com.aqua30.whatsapp.chatscreen.design.components.ListHeader
import com.aqua30.whatsapp.chatscreen.design.components.StatusImageSection
import com.aqua30.whatsapp.chatscreen.design.components.StatusUpdateSection
import com.aqua30.whatsapp.chatscreen.design.data.statusList
import com.aqua30.whatsapp.chatscreen.design.domain.StatusUpdateCategory

@Composable
fun StatusListScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
            StatusRowSection(
                isOwner = true,
                header = stringResource(id = R.string.my_status),
                subHeader = stringResource(id = R.string.tap_to_add_status_update),
            )
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            ListHeader(
                stringResource(id = R.string.recent_updates)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(
            items = statusList.filter { it.category == StatusUpdateCategory.RECENT },
            key = { status ->
                status.id
            }
        ) { status ->
            StatusRowSection(
                header = status.userName,
                subHeader = status.timeStamp,
                statusCount = status.statusCount,
                statusImage = status.statusImage
            )
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            ListHeader(
                stringResource(id = R.string.viewed_updates)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(
            items = statusList.filter { it.category == StatusUpdateCategory.VIEWED },
            key = { status ->
                status.id
            }
        ) { status ->
            StatusRowSection(
                header = status.userName,
                subHeader = status.timeStamp,
                statusCount = status.statusCount,
                statusImage = status.statusImage
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        item {
            Spacer(modifier = Modifier.height(75.dp))
        }
    }
}

@Composable
fun StatusRowSection(
    isOwner: Boolean = false,
    statusCount: Int? = null,
    statusImage: String? = null,
    header: String,
    subHeader: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        StatusImageSection(
            isOwner,
            statusCount,
            statusImage
        )
        StatusUpdateSection(header, subHeader)
    }
}
