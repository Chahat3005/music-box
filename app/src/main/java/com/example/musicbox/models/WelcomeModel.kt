package com.example.musicbox.models


data class WelcomeModel(
    val title: String
)

data class SearchItem(
    val title: String
)

data class NotificationItem(
    val title: String,
    val time: String,
    val imageResId: Int? = null
)

data class MusicBand(
    val title: String,
    val text:String,
    val imageResID: Int? = null
)

data class SavedItems(
    val title: String,
    val imageUrl: String,
    val time: String,
    val musicType: String
)

data class TextItems(
    val title: String,
    val imageUrl: String,
    val time: String,
    val address: String,
    val location: String,
    val musicType: String
)

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val data: UserAuthResponseData,

    var message: String? = null,
    var status: Int? = null,
    var success: Boolean = false,
    var badge: Int? = null

)

data class UserAuthResponseData(
    val access_token: String? = null,
    val apple_id: Any? = null,
    val email_token: String? = null,
    val email_resend_time: String? = null,
    val country_code: String? = null,
    val account_type: String? = null,
    val created_at: String? = null,
    val deleted_at: Any? = null,
    val device_token: String? = null,
    val device_type: String? = null,
    val email: String? = null,
    val email_verified_at: Any? = null,
    val facebook_id: Any? = null,
    val first_name: String? = null,
    val google_id: Any? = null,
    var id: Int? = null,
    var image: String? = null,
    val last_name: String? = null,
    val lat: String? = null,
    val lng: String? = null,
    var phone: String? = null,
    var name: Any? = null,
    val status: String? = null,
    val state_name_code: String? = null,
    val updated_at: String? = null,
    val user_type: String? = null,
    val push_notification: String? = null,
    val user_name: Any? = null,
    val is_info: Boolean? = null,
    val description: String? = null,
    val average_rating: String? = null,
    val ratings_count: Int? = null,
    val is_status: Boolean? = null,
    val subscription_traction_id: String? = null,
    val subscription_amount: String? = null,
    val subscription_post_count: String? = null,
    val subscription_days: String? = null,
    val subscription_package_name: String? = null,
    val notification_count: Int? = null,
    val full_name: String? = null,
    val is_background_criminal_check: Boolean? = null,
    val is_blocked_by_me: Boolean? = null,
    val is_reported_by_me: Boolean? = null,
    val is_card: Boolean? = null,
    val is_verify: Boolean? = null,
    val address_line_1: String?,
    val address_line_2: String?,
    val city: String?,
    val country: String?,
    val latitude: String?,
    val longitude: String?,
    val state: String?,
    val zip: String?,
    val user_id: Int?,
    val type: String?,
    val capacity: String?,
    val event_calender: String?,
    val biography: String?,
    val is_transfer_active: Boolean?,
    val social_link: ArrayList<String>,
)