package uz.otamurod.hotelmanagement.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.otamurod.hotelmanagement.R
import uz.otamurod.hotelmanagement.databinding.ActivityMainBinding


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        if (binding.container.findNavController().currentDestination?.id == R.id.hotelFragment) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}