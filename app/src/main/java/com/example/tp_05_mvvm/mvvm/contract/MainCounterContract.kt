package com.example.tp_05_mvvm.mvvm.contract

import androidx.lifecycle.LiveData
import com.example.tp_05_mvvm.mvvm.viewmodel.MainCounterViewModel

interface MainCounterContract {
    interface Model {
        var counter: Int
        fun increment(inputValue: Int)
        fun decrement(inputValue: Int)
        fun reset()
    }
    interface ViewModel {
        fun getValue(): LiveData<MainCounterViewModel.MainData>
        fun resetValue()
        fun incrementValue(inputValue: Int)
        fun decrementValue(inputValue: Int)
    }
}