package sam.compose.calc

sealed class CalculatorOperations(operator: String){
    object Add: CalculatorOperations("+")
    object Subtract: CalculatorOperations("-")
    object Divide: CalculatorOperations("/")
    object Multiply: CalculatorOperations("X")
    object OpeningBracket: CalculatorOperations("(")
    object ClosingBracket: CalculatorOperations(")")
    object Modulus: CalculatorOperations("%")
    object PowerOf: CalculatorOperations("^")
    object SquareRootOf: CalculatorOperations("root")
}
