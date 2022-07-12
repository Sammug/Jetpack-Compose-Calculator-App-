package sam.compose.calc.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import sam.compose.calc.CalculatorActions
import sam.compose.calc.CalculatorActionsState

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorActionsState())
    private set

    private fun calcActions(action: CalculatorActions){
        when(action){
            CalculatorActions.Calculate -> performCalculations()
            CalculatorActions.Delete -> performDeletion()
            CalculatorActions.Decimal -> enterDecimal()
            is CalculatorActions.Operation -> enterOperation(action.calculatorOperations.operator)
            is CalculatorActions.Number -> enterNumber(action.number)
            CalculatorActions.Clear -> state = CalculatorActionsState()
        }
    }

    private fun enterNumber(number: String) {
        TODO("Not yet implemented")
    }

    private fun enterOperation(operator: String) {
        TODO("Not yet implemented")
    }

    private fun enterDecimal() {
        TODO("Not yet implemented")
    }

    private fun performDeletion() {
        TODO("Not yet implemented")
    }

    private fun performCalculations() {
        TODO("Not yet implemented")
    }
}