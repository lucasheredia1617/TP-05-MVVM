package com.example.tp_05_mvvm.mvvm.viewmodel.factory // ktlint-disable package-name

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tp_05_mvvm.mvvm.contract.MainCounterContract
import com.example.tp_05_mvvm.mvvm.model.MainCounterModel
import com.example.tp_05_mvvm.mvvm.viewmodel.MainCounterViewModel

class FactoryViewModel(private val params: Array<Any>) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MainCounterModel::class.java -> MainCounterViewModel(params[0] as MainCounterContract.Model) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
