package com.example.tp_05_mvvm // ktlint-disable package-name

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.tp_05_mvvm.mvvm.contract.MainCounterContract
import com.example.tp_05_mvvm.mvvm.model.MainCounterModel
import com.example.tp_05_mvvm.mvvm.viewmodel.MainCounterViewModel
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MainCounterViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainCounterContract.ViewModel

    @Before
    fun setup() {
        viewModel = MainCounterViewModel(MainCounterModel())
    }

    @Test
    fun `initial state test`() {
        assert(viewModel.getValue().value == null)
    }

    @Test
    fun `on inc btn pressed after dec btn pressed test`() {
        viewModel.decrementValue(FIVE)
        viewModel.incrementValue(FIVE)
        TestCase.assertEquals(MINUS_FIVE, viewModel.getValue().value?.value)
        assertEquals(MainCounterViewModel.MainState.INC, viewModel.getValue().value?.state)
    }

    @Test
    fun `on btn dec pressed on initial state test`() {
        viewModel.decrementValue(FIVE)
        TestCase.assertEquals(MINUS_FIVE, viewModel.getValue().value?.value)
        assertEquals(MainCounterViewModel.MainState.DEC, viewModel.getValue().value?.state)
    }

    @Test
    fun `on dec btn pressed after inc btn pressed test`() {
        viewModel.incrementValue(FIVE)
        viewModel.decrementValue(FIVE)
        TestCase.assertEquals(Zero, viewModel.getValue().value?.value)
        assertEquals(MainCounterViewModel.MainState.DEC, viewModel.getValue().value?.state)
    }

    @Test
    fun `on button reset pressed test`() {
        viewModel.resetValue()

        assert(viewModel.getValue().value != null)
        assert(viewModel.getValue().value?.state == MainCounterViewModel.MainState.INITIAL)
        assert(viewModel.getValue().value?.value == Zero)
    }

    companion object {
        const val FIVE = 5
        const val Zero = 0
        const val MINUS_FIVE = -5
    }
}
