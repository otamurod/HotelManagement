package uz.otamurod.presentation.ui.number

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
import uz.otamurod.domain.api.model.Room
import uz.otamurod.domain.api.model.Rooms
import uz.otamurod.domain.util.DataState
import uz.otamurod.presentation.R
import uz.otamurod.presentation.databinding.FragmentNumberBinding

@AndroidEntryPoint
class NumberFragment : Fragment() {

    private lateinit var roomNumber: Room
    private val viewModel: NumberViewModel by viewModels()
    private lateinit var binding: FragmentNumberBinding
    private var snackBar: Snackbar? = null
    private var roomId: Int? = null
    private lateinit var imageUrls: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            roomId = it?.getInt("roomId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentNumberBinding.inflate(LayoutInflater.from(container?.context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.rooms.observe(viewLifecycleOwner) { result ->
            val isLoading = when (result.status) {
                DataState.Status.SUCCESS -> {
                    result.data?.let { rooms ->
                        updateUI(rooms)
                    }
                    false
                }
                DataState.Status.ERROR -> {
                    result.message?.let {
                        showError(it) {
                            viewModel.fetchHotelRooms()
                        }
                    }
                    false
                }
                DataState.Status.LOADING -> true
            }

            if (isLoading) {
                startShimmerAnimation()
            }
        }

        binding.navigateBackBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.selectNumberBtn.setOnClickListener {
            val bundle = bundleOf("roomId" to roomId)
            findNavController().navigate(R.id.action_numberFragment_to_bookingFragment, bundle)
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

    private fun updateUI(rooms: Rooms) {
        roomId.let {

            for (room in rooms.rooms) {
                if (room.id == roomId) {
                    roomNumber = room
                }
            }
            val name = roomNumber.name
            val price = roomNumber.price
            val pricePer = roomNumber.pricePer
            imageUrls = roomNumber.imageUrls as ArrayList<String>

            binding.apply {
                toolbarTitle.text = getString(R.string.sample_hotel_name)

                hotelViewDescription.text = name
                peculiarities1.text = roomNumber.peculiarities[0]
                peculiarities2.text = roomNumber.peculiarities[1]
                peculiarities3.text =
                    if (roomNumber.peculiarities.size == 3) roomNumber.peculiarities[2] else ""
                hotelCost.text = String.format("%,d ₽", price).replace(",", " ")
                hotelCostDetail.text = pricePer

                carouselView.setImageListener(imageListener)
                carouselView.pageCount = imageUrls.size

                Picasso.get().load(imageUrls[imageUrls.size - 1])
                    .fit()
                    .transform(
                        RoundedTransformationBuilder()
                            .cornerRadiusDp(12f)
                            .oval(false)
                            .build()
                    )
                    .into(hotelImage)
            }

            stopShimmerAnimation()
            binding.progressBar.isVisible = false
        }
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
        fun newInstance() = NumberFragment()
    }

}