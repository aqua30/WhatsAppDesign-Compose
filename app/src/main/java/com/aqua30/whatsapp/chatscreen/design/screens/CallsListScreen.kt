package com.aqua30.whatsapp.chatscreen.design.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aqua30.whatsapp.chatscreen.design.R
import com.aqua30.whatsapp.chatscreen.design.components.ListHeader
import com.aqua30.whatsapp.chatscreen.design.components.RemoteImage
import com.aqua30.whatsapp.chatscreen.design.components.StatusUpdateSection
import com.aqua30.whatsapp.chatscreen.design.data.CallData
import com.aqua30.whatsapp.chatscreen.design.data.CallStatus
import com.aqua30.whatsapp.chatscreen.design.data.CallStatus.*
import com.aqua30.whatsapp.chatscreen.design.data.CallType
import com.aqua30.whatsapp.chatscreen.design.data.callsList
import com.aqua30.whatsapp.chatscreen.design.ui.theme.*

@Composable
fun CallsListScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
            CallHeaderRowSection(
                header = stringResource(id = R.string.create_call_link),
                subHeader = stringResource(id = R.string.share_link_for_call),
            )
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            ListHeader(
                stringResource(id = R.string.recent)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(
            items = callsList,
            key = { call ->
                call.id
            }
        ) { call ->
            CallRowSection(call)
            Spacer(modifier = Modifier.height(24.dp))
        }
        item {
            Spacer(modifier = Modifier.height(75.dp))
        }
    }
}

@Composable
fun CallRowSection(call: CallData) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        RemoteImage(call.userImage)
        CallerDetailsSection(
            Modifier.weight(1f),
            call)
        CallStatus(call.type)
    }
}

@Composable
fun CallStatus(type: CallType) {
    Image(
        modifier = Modifier.size(18.dp),
        painter = painterResource(
            if (type == CallType.VIDEO) {
                R.drawable.ic_video
            } else {
                R.drawable.ic_phone
            }
        ),
        contentDescription = "call status",
        colorFilter = ColorFilter.tint(PrimaryGreen_A102)
    )
}

@Composable
fun CallerDetailsSection(
    modifier: Modifier,
    call: CallData
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = call.userName,
            style = TextStyle(
                color = if (isSystemInDarkTheme()) White else Black,
                fontSize = 18.sp,
            )
        )

        Spacer(modifier = Modifier.height(2.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(18.dp),
                painter = painterResource(id = callStatusIcon(call.status)),
                contentDescription = "call status",
                colorFilter = ColorFilter.tint(
                    if (call.status == OUTGOING) {
                        PrimaryGreen
                    } else {
                        RED_100
                    }
                )
            )
            Text(
                text = callDetailSubHeader(call),
                style = TextStyle(
                    color = if (isSystemInDarkTheme()) OffWhite_Dark else OffWhite_Light,
                    fontSize = 16.sp,
                )
            )
        }
    }
}

fun callStatusIcon(status: CallStatus): Int {
    return when (status) {
        OUTGOING -> R.drawable.ic_arrow_top_right
        DECLINED, MISSED -> R.drawable.ic_arrow_bottom_left
    }
}

fun callDetailSubHeader(call: CallData): String {
    val callCountString = call.callCount?.let {
        if (it > 0) {
            "($it)"
        } else {
            ""
        }
    } ?: ""

    return "$callCountString ${call.timeStamp}"
}

@Composable
fun CallHeaderRowSection(
    header: String,
    subHeader: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        CallImageSection()
        StatusUpdateSection(header, subHeader)
    }
}

@Composable
fun CallImageSection() {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(PrimaryGreen_A102),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.rotate(135f),
            painter = painterResource(id = R.drawable.ic_hyperlink),
            contentDescription = "create link",
            colorFilter = ColorFilter.tint(White)
        )
    }
}
