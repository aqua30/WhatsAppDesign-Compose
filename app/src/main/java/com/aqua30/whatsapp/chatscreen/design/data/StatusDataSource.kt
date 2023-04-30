package com.aqua30.whatsapp.chatscreen.design.data

import com.aqua30.whatsapp.chatscreen.design.domain.StatusUpdateCategory
import com.aqua30.whatsapp.chatscreen.design.domain.model.StatusListData

val statusList = listOf(
    StatusListData(
        1,
        StatusUpdateCategory.RECENT,
        userName = "Saurabh",
        timeStamp = "21 minutes ago",
        statusCount = 1,
        statusImage = "https://fastly.picsum.photos/id/723/200/200.jpg?hmac=_sO25hgEAx99R1W5nOFsCmrSDTpHGmXIEXDywKpjfXE"
    ),
    StatusListData(
        2,
        StatusUpdateCategory.VIEWED,
        userName = "James",
        timeStamp = "55 minutes ago",
        statusCount = 1,
        statusImage = "https://fastly.picsum.photos/id/268/200/200.jpg?hmac=I5JAWzISJc5x0jlDhEngvCIwyM0zxRh22iIIzHqOT80"
    ),
    StatusListData(
        3,
        StatusUpdateCategory.VIEWED,
        userName = "Rico",
        timeStamp = "Today, 5:00 am",
        statusCount = 1,
        statusImage = "https://fastly.picsum.photos/id/1018/200/200.jpg?hmac=uHjw5VeUXsbJBBE5Ywaumr-fxWyViVwI_GRwrA3AQ2Q"
    ),
    StatusListData(
        4,
        StatusUpdateCategory.VIEWED,
        userName = "Michael",
        timeStamp = "Today, 8:32 am",
        statusCount = 1,
        statusImage = "https://fastly.picsum.photos/id/1043/200/200.jpg?hmac=i7xbST4bM6KMg5XsUaVYvDgwvsZ3VskoXKRqGf1BjcU"
    )
)