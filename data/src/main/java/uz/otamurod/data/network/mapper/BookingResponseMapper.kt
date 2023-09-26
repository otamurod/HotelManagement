package uz.otamurod.data.network.mapper

import uz.otamurod.data.network.api.entities.BookingResponse as BookingDto
import uz.otamurod.domain.api.model.Booking as BookingBo

object BookingResponseMapper {
    class Booking internal constructor(private val dto: BookingDto){
        operator fun invoke(): BookingBo = with(dto){
            BookingBo(
                arrivalCountry,
                departure,
                fuelCharge,
                hotelRating,
                hotelAddress,
                hotelName,
                id,
                numberOfNights,
                nutrition,
                ratingName,
                room,
                serviceCharge,
                tourDateStart,
                tourDateStop,
                tourPrice
            )
        }
    }
}