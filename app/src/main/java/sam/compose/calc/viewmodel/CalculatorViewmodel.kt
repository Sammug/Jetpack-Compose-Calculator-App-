package sam.compose.calc.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import sam.compose.calc.CalculatorActions
import sam.compose.calc.CalculatorActionsState
import sam.compose.calc.CalculatorOperations
import kotlin.math.sqrt

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorActionsState())
    private set

    fun onAction(action: CalculatorActions){
       when(action){
            CalculatorActions.Calculate -> performCalculations()
            CalculatorActions.Delete -> performDeletion()
            CalculatorActions.Decimal -> enterDecimal()
            CalculatorActions.PowerOf -> enterPower()
            is CalculatorActions.Operation -> enterOperation(action.calculatorOperations)
            is CalculatorActions.Number -> enterNumber(action.number)
            CalculatorActions.Clear -> state = CalculatorActionsState()
           else -> {return}
       }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null){
            if (state.firstNumber.length >= MAX_NUMBER_SIZE){
                return
            }else{
                state = state.copy(firstNumber = state.firstNumber + number)
            }
            return
        }

        if (state.secondNumber.length >= MAX_NUMBER_SIZE){
            return
        }else{
            state = state.copy(secondNumber = state.secondNumber + number)
        }
    }

    private fun enterOperation(operator: CalculatorOperations) {
        if(state.firstNumber.isNotBlank() && state.operation == null){
            state = state.copy(operation = operator)
        }else if (state.firstNumber.isBlank() && operator.operator.contentEquals("root")){
            state = state.copy(operation = operator)
        }
    }

    private fun enterDecimal() {
        if (state.firstNumber.isNotBlank() && state.operation == null && !state.firstNumber.contains(".")){
            state = state.copy(firstNumber = state.firstNumber + ".")
            return
        }
        else if (state.secondNumber.isNotBlank() && !state.secondNumber.contains(".")){
            state = state.copy(secondNumber = state.secondNumber + ".")
        }
    }
    private fun enterPower() {
        if (state.firstNumber.isNotBlank()&& state.secondNumber.isBlank() && state.operation == null && !state.firstNumber.contains("^")){
            state = state.copy(firstNumber = state.firstNumber + "^")
            return
        }
    }

    private fun performDeletion() {
        if (state.secondNumber.isNotBlank()){
            state = state.copy(secondNumber = state.secondNumber.dropLast(1))
        }
        else if (state.operation != null){
            state = state.copy(operation = null)
        }
        else if (state.firstNumber.isNotBlank()){
            state = state.copy(firstNumber = state.firstNumber.dropLast(1))
        }
    }

    private fun performCalculations() {
        val firstNumber = state.firstNumber.toDoubleOrNull()
        val secondNumber = state.secondNumber.toDoubleOrNull()
        if (firstNumber != null && secondNumber != null){
            val result = when(state.operation){
                CalculatorOperations.Add -> {firstNumber + secondNumber}
                CalculatorOperations.Multiply -> {firstNumber * secondNumber}
                CalculatorOperations.Divide -> {firstNumber / secondNumber}
                CalculatorOperations.Subtract -> {firstNumber - secondNumber}
                CalculatorOperations.Modulus -> {firstNumber % secondNumber}
                CalculatorOperations.SquareRootOf -> {sqrt(state.firstNumber.toDouble())}
                else -> return
            }
            state = state.copy(
                firstNumber = result.toString().take(15),
                secondNumber = "",
                operation = null
            )
        }
    }
    companion object {
        const val MAX_NUMBER_SIZE = 8
    }
}