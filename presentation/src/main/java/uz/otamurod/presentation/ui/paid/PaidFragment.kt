package uz.otamurod.presentation.ui.paid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.otamurod.presentation.R
import uz.otamurod.presentation.databinding.FragmentPaidBinding
import kotlin.random.Random

@AndroidEntryPoint
class PaidFragment : Fragment() {

    private val viewModel: PaidViewModel by viewModels()
    private lateinit var binding: FragmentPaidBinding
    private var roomId: Int? = null

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
            FragmentPaidBinding.inflate(LayoutInflater.from(container?.context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigateBackBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.superBtn.setOnClickListener {
            findNavController().navigate(R.id.action_paidFragment_to_hotelFragment)
        }

        val randomOrder = Random.nextInt(100_000, 1_000_000)
        binding.confirmationText.text =
            String.format(
                "Подтверждение заказа №%d может занять некоторое время (от 1 часа до суток). Как только мы получим ответ от туроператора, вам на почту придет уведомление.",
                randomOrder
            )
    }

    companion object {
        fun newInstance() = PaidFragment()
    }
}