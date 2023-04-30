package com.aqua30.whatsapp.chatscreen.design.data

val callsList = listOf(
    CallData(
        1,
        CallType.VIDEO,
        CallStatus.OUTGOING,
        "https://fastly.picsum.photos/id/723/200/200.jpg?hmac=_sO25hgEAx99R1W5nOFsCmrSDTpHGmXIEXDywKpjfXE",
        "James",
        timeStamp = "Today, 11:00 am"
    ),
    CallData(
        2,
        CallType.AUDIO,
        CallStatus.MISSED,
        "https://fastly.picsum.photos/id/1076/200/200.jpg?hmac=KTOq4o7b6rXzwd8kYN0nWrPIeKI97mzxBdWhnn-o-Nc",
        "David Warner",
        callCount = 2,
        timeStamp = "Today, 11:20 am"
    )
)

data class CallData(
    val id: Int,
    val type: CallType,
    val status: CallStatus,
    val userImage: String? = null,
    val userName: String,
    val callCount: Int? = null,
    val timeStamp: String,
)

enum class CallType {
    VIDEO,
    AUDIO
}

enum class CallStatus {
    OUTGOING,
    DECLINED,
    MISSED,
}