package com.example.tp_05_mvvm.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp_05_mvvm.mvvm.contract.MainCounterContract

class MainCounterViewModel(private val model: MainCounterContract.Model) : ViewModel(), MainCounterContract.ViewModel {

    private val mutableLiveData: MutableLiveData<MainData> = MutableLiveData()
    val data: LiveData<MainData> = mutableLiveData

    override fun getValue(): LiveData<MainData> {
        return mutableLiveData
    }

    override fun incrementValue(inputValue: Int) {
        model.increment(inputValue)
        mutableLiveData.value = MainData(MainState.INC, model.counter)
    }

    override fun decrementValue(inputValue: Int) {
        model.decrement(inputValue)
        mutableLiveData.value = MainData(MainState.DEC, model.counter)
    }

    override fun resetValue() {
        model.reset()
        mutableLiveData.value = MainData(MainState.INITIAL, model.counter)
    }

    enum class MainState {
        INITIAL,
        INC,
        DEC,
    }

    data class MainData(
        val state: MainState = MainState.INITIAL,
        val value: Int = Zero,
    )

    companion object {
        private const val Zero: Int = 0
    }
}