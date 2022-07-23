package sam.compose.calc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import sam.compose.calc.ui.theme.CalcTheme
import sam.compose.calc.viewmodel.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcTheme {
                val calculatorViewModel = viewModel<CalculatorViewModel>()
                val state = calculatorViewModel.state
                Calculator(state = state, onAction = calculatorViewModel::onAction)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalcTheme {
        val calculatorViewModel = viewModel<CalculatorViewModel>()
        val state = calculatorViewModel.state
        Calculator(state = state, onAction = calculatorViewModel::onAction)
    }
}