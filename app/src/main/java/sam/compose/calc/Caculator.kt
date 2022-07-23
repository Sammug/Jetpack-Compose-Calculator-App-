package sam.compose.calc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import sam.compose.calc.ui.theme.*
import sam.compose.calc.viewmodel.CalculatorViewModel

@Composable
fun Calculator(
    state: CalculatorActionsState,
    modifier: Modifier = Modifier,
    buttonsSpacing: Dp = 8.dp,
    onAction: (CalculatorActions) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(GreyColor)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .background(GreyColor)
            .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonsSpacing)
        ) {
            /**Calculator display area/text*/
            Text(
                text = state.firstNumber + (state.operation?.operator ?: "") + state.secondNumber,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontSize = 80.sp,
                maxLines = 2,
                fontWeight = FontWeight.Light,
                color = LightColor
            )
            /**first row containing c,(,),and x buttons*/
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonsSpacing)
            ) {
                //ClearButton
                CalculatorButton(modifier = Modifier
                    .background(YellowColor)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "AC",
                    onClick = {
                        onAction(CalculatorActions.Clear)
                    }
                )

                //OpeningBracket
                CalculatorButton(modifier = Modifier
                    .background(LightButtonColor)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "("
                ){

                }

                //ClosingBracket
                CalculatorButton(modifier = Modifier
                    .background(LightButtonColor)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = ")"
                ){

                }

                //MultiplicationButton
                CalculatorButton(modifier = Modifier
                    .background(DeepPurple)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "X",
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.Multiply))
                    }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonsSpacing)
            ) {
                //SquireRootButton
                CalculatorButton(modifier = Modifier
                    .background(LightButtonColor)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "root",
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.SquareRootOf))
                    }
                )

                //ModulusButton
                CalculatorButton(modifier = Modifier
                    .background(LightButtonColor)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "%",
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.Modulus))
                    }
                )

                //PowerOf Button
                CalculatorButton(modifier = Modifier
                    .background(LightButtonColor)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "^"
                ){

                }

                //DivisionButton
                CalculatorButton(modifier = Modifier
                    .background(DeepPurple)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "/",
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.Divide))
                    }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonsSpacing)
            ) {
                //SquireRootButton
                CalculatorButton(modifier = Modifier
                    .background(LightGrey)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "7",
                    onClick = {
                        onAction(CalculatorActions.Number(7))
                    }
                )

                //ModulusButton
                CalculatorButton(modifier = Modifier
                    .background(LightGrey)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "8",
                    onClick = {
                        onAction(CalculatorActions.Number(8))
                    }
                )

                //PowerOf Button
                CalculatorButton(modifier = Modifier
                    .background(LightGrey)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "9",
                    onClick = {
                        onAction(CalculatorActions.Number(9))
                    }
                )

                //AdditionButton
                CalculatorButton(modifier = Modifier
                    .background(DeepPurple)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "+",
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.Add))
                    }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonsSpacing)
            ) {
                //4
                CalculatorButton(modifier = Modifier
                    .background(LightGrey)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "4",
                    onClick = {
                        onAction(CalculatorActions.Number(4))
                    }
                )

                //5
                CalculatorButton(modifier = Modifier
                    .background(LightGrey)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "5",
                    onClick = {
                        onAction(CalculatorActions.Number(5))
                    }
                )

                //6
                CalculatorButton(modifier = Modifier
                    .background(LightGrey)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "6",
                    onClick = {
                        onAction(CalculatorActions.Number(6))
                    }
                )

                //-
                CalculatorButton(modifier = Modifier
                    .background(DeepPurple)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "-",
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.Subtract))
                    }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonsSpacing)
            ) {
                //1
                CalculatorButton(modifier = Modifier
                    .background(LightGrey)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "1",
                    onClick = {
                        onAction(CalculatorActions.Number(1))
                    }
                )

                //2
                CalculatorButton(modifier = Modifier
                    .background(LightGrey)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "2",
                    onClick = {
                        onAction(CalculatorActions.Number(2))
                    }
                )

                //3
                CalculatorButton(modifier = Modifier
                    .background(LightGrey)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "3",
                    onClick = {
                        onAction(CalculatorActions.Number(3))
                    }
                )

                CalculatorButton(modifier = Modifier
                    .background(DeepPurple)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "Del",
                    onClick = {
                        onAction(CalculatorActions.Delete)
                    }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonsSpacing)
            ) {
                //1
                CalculatorButton(modifier = Modifier
                    .background(LightGrey)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = ".",
                    onClick = {
                        onAction(CalculatorActions.Decimal)
                    }
                )

                //0
                CalculatorButton(modifier = Modifier
                    .background(LightGrey)
                    .aspectRatio(1f)
                    .weight(1f),
                    symbol = "0",
                    onClick = {
                        onAction(CalculatorActions.Number(0))
                    }
                )

                //=
                CalculatorButton(modifier = Modifier
                    .background(LightButtonColor)
                    .aspectRatio(2f)
                    .weight(2f),
                    symbol = "=",
                    onClick = {
                        onAction(CalculatorActions.Calculate)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CalcTheme {
        val calculatorViewModel = viewModel<CalculatorViewModel>()
        val state = calculatorViewModel.state
        Calculator(state = state, onAction = calculatorViewModel::onAction)
    }
}