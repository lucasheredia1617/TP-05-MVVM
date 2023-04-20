package com.example.tp_05_mvvm.activity // ktlint-disable package-name

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tp_05_mvvm.databinding.ActivityMainBinding
import com.example.tp_05_mvvm.mvvm.model.MainCounterModel
import com.example.tp_05_mvvm.mvvm.viewmodel.MainCounterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainCounterViewModel: MainCounterViewModel = MainCounterViewModel(MainCounterModel())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.IncreaseButton.setOnClickListener { mainCounterViewModel.incrementValue(getInput()) }
        binding.DecreaseButton.setOnClickListener { mainCounterViewModel.decrementValue(getInput()) }
        binding.ResetButton.setOnClickListener { mainCounterViewModel.resetValue() }

        mainCounterViewModel.resetValue()
        mainCounterViewModel.getValue().observe({ lifecycle }, ::updateUI)
    }

    private fun updateUI(data: MainCounterViewModel.MainData) {
        when (data.state) {
            MainCounterViewModel.MainState.INITIAL -> {
                binding.Counter.text = data.value.toString()
                clearText()
                showToast(getString(R.string.reset_button_text))
            }
            MainCounterViewModel.MainState.INC -> {
                binding.Counter.text = data.value.toString()
            }
            MainCounterViewModel.MainState.DEC -> {
                binding.Counter.text = data.value.toString()
            }
        }
    }
    private fun getInput(): Int {
        return Integer.parseInt(binding.CounterValue.text.toString())
    }

    private fun clearText() {
        binding.CounterValue.text.clear()
    }
    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val Zero = 0
    }
}
