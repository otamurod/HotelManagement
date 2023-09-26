package uz.otamurod.data.network.mapper

import uz.otamurod.data.network.api.entities.AboutHotelResponse as AboutHotelDto
import uz.otamurod.domain.api.model.AboutHotel as AboutHotelBo

object AboutHotelResponseMapper {
    class AboutHotel internal constructor(private val dto: AboutHotelDto){
        operator fun invoke(): AboutHotelBo = with(dto){
            AboutHotelBo(description, peculiarities)
        }
    }
}