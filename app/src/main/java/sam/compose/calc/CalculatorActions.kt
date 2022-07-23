package sam.compose.calc

sealed class CalculatorActions{
    data class Number(val number: Int): CalculatorActions()
    data class Operation(val calculatorOperations: CalculatorOperations): CalculatorActions()
    object Clear: CalculatorActions()
    object Delete: CalculatorActions()
    object Calculate: CalculatorActions()
    object Decimal: CalculatorActions()
    object BodMasCalculation: CalculatorActions()
    object PowerOf: CalculatorActions()
    object SquareRoot: CalculatorActions()
}
