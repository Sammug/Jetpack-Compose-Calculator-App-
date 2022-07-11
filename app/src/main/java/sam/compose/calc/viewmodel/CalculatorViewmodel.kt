package sam.compose.calc.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import sam.compose.calc.CalculatorActionsState

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorActionsState())
    private set
}