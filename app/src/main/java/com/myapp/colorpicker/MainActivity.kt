package com.myapp.colorpicker

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.myapp.colorpicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.hsView.setOnColorChange {
            Log.v("tag111", "color change: $it")
            binding.resultView.setBackgroundColor(it)
        }

        binding.hsView.setupWith(binding.vView)
        binding.vView.setOnValueChange {
            binding.hsView.setValue(it)
        }
    }
}