package com.example.tp_05_mvvm.mvvm.model

import com.example.tp_05_mvvm.mvvm.contract.MainCounterContract

class MainCounterModel : MainCounterContract.Model {
    override var counter: Int = Zero

    override fun increment(inputValue: Int) {
        counter += inputValue
    }

    override fun decrement(inputValue: Int) {
        counter -= inputValue
    }

    override fun reset() {
        counter = Zero
    }

    companion object {
        private const val Zero = 0
    }
}