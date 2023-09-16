package uz.otamurod.presentation.ui.hotel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.ImageListener
import dagger.hilt.android.AndroidEntryPoint
import uz.otamurod.domain.model.Hotel
import uz.otamurod.domain.model.HotelResponse
import uz.otamurod.presentation.R
import uz.otamurod.presentation.databinding.FragmentHotelBinding

@AndroidEntryPoint
class HotelFragment : Fragment() {
    private val viewModel: HotelViewModel by viewModels()
    private lateinit var binding: FragmentHotelBinding
    private var snackBar: Snackbar? = null
    private lateinit var imageUrls: ArrayList<String>
    private var roomId: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentHotelBinding.inflate(
                LayoutInflater.from(
                    container?.context
                ), container, false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startShimmerAnimation()
        viewModel.hotel.observe(viewLifecycleOwner) { result ->
            val isLoading = when (result.status) {
                HotelResponse.Status.SUCCESS -> {
                    result.data?.let { hotel ->
                        updateUI(hotel)
                    }
                    false
                }
                HotelResponse.Status.ERROR -> {
                    result.message?.let {
                        showError(it) {
                            viewModel.fetchHotel()
                        }
                    }
                    false
                }
                HotelResponse.Status.LOADING -> true
            }
            if (isLoading) {
                startShimmerAnimation()
            }
        }

        binding.selectRoomBtn.setOnClickListener {
            val bundle = bundleOf("roomId" to roomId)
            findNavController().navigate(R.id.action_hotelFragment_to_numberFragment, bundle)
        }
    }

    private var imageListener: ImageListener =
        ImageListener { position, imageView ->
            // You can use Picasso here
            Picasso.get().load(imageUrls[position])
                .fit()
                .transform(
                    RoundedTransformationBuilder()
                        .cornerRadiusDp(12f)
                        .oval(false)
                        .build()
                )
                .into(imageView)
        }

    private fun startShimmerAnimation() {
        binding.shimmerLayout.startShimmer()
    }

    private fun stopShimmerAnimation() {
        binding.shimmerLayout.stopShimmer()
        binding.shimmerLayout.visibility = View.GONE
    }

    private fun updateUI(hotel: Hotel) {
        val aboutTheHotel = hotel.aboutTheHotel
        val address = hotel.address
        roomId = hotel.id
        imageUrls = hotel.imageUrls as ArrayList<String>
        val minimalPrice = hotel.minimalPrice
        val name = hotel.name
        val priceForIt = hotel.priceForIt
        val rating = hotel.rating
        val ratingName = hotel.ratingName

        binding.apply {
            carouselView.setImageListener(imageListener)
            carouselView.pageCount = imageUrls.size

            hotelStar.text = String.format("%d %s", rating, ratingName)
            hotelName.text = String.format("%s", name)
            hotelAddress.text = String.format("%s", address)
            hotelCost.text = String.format("от %,d ₽", minimalPrice).replace(",", " ")
            hotelCostDetail.text = String.format("%s", priceForIt)

            hotelWiFi.text = String.format("%s", aboutTheHotel.peculiarities[0])
            hotelDistanceToBeach.text = String.format("%s", aboutTheHotel.peculiarities[1])
            hotelFitnessClub.text = String.format("%s", aboutTheHotel.peculiarities[2])
            hotelDistanceToPort.text = String.format("%s", aboutTheHotel.peculiarities[3])

            hotelDescription.text = String.format("%s", aboutTheHotel.description)
        }

        stopShimmerAnimation()
        binding.progressBar.isVisible = false
    }

    private fun showError(msg: String, onRetry: () -> Unit) {
        view?.let {
            snackBar = Snackbar.make(it, msg, Snackbar.LENGTH_INDEFINITE)
            snackBar?.setAction("RETRY") {
                snackBar?.dismiss()
                onRetry.invoke()
            }
            snackBar?.show()
        }
    }

    companion object {
        fun newInstance() = HotelFragment()
    }
}