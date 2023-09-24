package uz.otamurod.domain.api.model

data class Hotel(
    val aboutHotel: AboutHotel,
    val address: String,
    val id: Int,
    val imageUrls: List<String>,
    val minimalPrice: Int,
    val name: String,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String
)