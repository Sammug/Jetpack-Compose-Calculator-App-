package sam.compose.calc

data class CalculatorActionsState(
    val firstNumber: String = "",
    val secondNumber: String = "",
    val operation: CalculatorOperations? = null
)
