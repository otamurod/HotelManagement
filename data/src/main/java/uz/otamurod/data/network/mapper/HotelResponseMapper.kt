package uz.otamurod.data.network.mapper

import uz.otamurod.data.network.api.entities.HotelResponse as HotelDto
import uz.otamurod.domain.api.model.Hotel as HotelBo

object HotelResponseMapper {
    class Hotel internal constructor(private val dto: HotelDto){
        operator fun invoke(): HotelBo = with(dto){
            HotelBo(
                AboutHotelResponseMapper.AboutHotel(aboutHotel).invoke(),
                address,
                id,
                imageUrls,
                minimalPrice,
                name,
                priceForIt,
                rating,
                ratingName
            )
        }
    }
}