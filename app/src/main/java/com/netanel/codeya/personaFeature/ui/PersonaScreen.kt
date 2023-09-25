package com.netanel.codeya.personaFeature.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.netanel.codeya.R
import com.netanel.codeya.personaFeature.ui.PersonaKind.*


/**
 * Created by netanelamar on 24/09/2023.
 * NetanelCA2@gmail.com
 */

@Composable
fun ThreeTextFieldsWithCheckboxes(navController: NavController, viewModel: PersonaScreenViewModel) {

    val scrollState = rememberScrollState()

    val focusRequester1 = remember { FocusRequester() }
    val focusRequester2 = remember { FocusRequester() }
    val focusRequester3 = remember { FocusRequester() }

    var firstPersonaNumber by remember { mutableStateOf("") }
    var secondPersonaNumber by remember { mutableStateOf("") }
    var thirdPersonaNumber by remember { mutableStateOf("") }

    var firstPersonaNumberOption by remember { mutableIntStateOf(0) }
    var secondPersonaNumberOption by remember { mutableIntStateOf(0) }
    var thirdPersonaNumberOption by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.persona_text),
            fontSize = 30.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.height(20.dp))

        DesignedTextField(
            value = firstPersonaNumber,
            onValueChange = { firstPersonaNumber = it },
            label = stringResource(R.string.first_number_text),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusRequester2.requestFocus() }
            ),
            focusRequester = focusRequester1
        )

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SingleCheckboxRow(
                label = stringResource(R.string.excess_text),
                isChecked = firstPersonaNumberOption == Excess.value,
                onCheckedChange = { isChecked ->
                    firstPersonaNumberOption = if (isChecked) Excess.value else None.value
                }
            )

            SingleCheckboxRow(
                label = stringResource(R.string.lack_text),
                isChecked = firstPersonaNumberOption == Lack.value,
                onCheckedChange = { isChecked ->
                    firstPersonaNumberOption = if (isChecked) Lack.value else None.value
                }
            )

            SingleCheckboxRow(
                label = stringResource(R.string.balanced_text),
                isChecked = firstPersonaNumberOption == Balanced.value,
                onCheckedChange = { isChecked ->
                    firstPersonaNumberOption = if (isChecked) Balanced.value else None.value
                }
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        DesignedTextField(
            value = secondPersonaNumber,
            onValueChange = { secondPersonaNumber = it },
            label = stringResource(R.string.seconde_number_text),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Number

            ),
            keyboardActions = KeyboardActions(
                onNext = { focusRequester3.requestFocus() }
            ),
            focusRequester = focusRequester2,
        )

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SingleCheckboxRow(
                label = stringResource(R.string.excess_text),
                isChecked = secondPersonaNumberOption == Excess.value,
                onCheckedChange = { isChecked ->
                    secondPersonaNumberOption = if (isChecked) Excess.value else None.value
                }
            )

            SingleCheckboxRow(
                label = stringResource(R.string.lack_text),
                isChecked = secondPersonaNumberOption == Lack.value,
                onCheckedChange = { isChecked ->
                    secondPersonaNumberOption = if (isChecked) Lack.value else None.value
                }
            )

            SingleCheckboxRow(
                label = stringResource(R.string.balanced_text),
                isChecked = secondPersonaNumberOption == Balanced.value,
                onCheckedChange = { isChecked ->
                    secondPersonaNumberOption = if (isChecked) Balanced.value else None.value
                }
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        DesignedTextField(
            value = thirdPersonaNumber,
            onValueChange = { thirdPersonaNumber = it },
            label = stringResource(R.string.third_number_text),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onDone = { }
            ),
            focusRequester = focusRequester3,
        )

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SingleCheckboxRow(
                label = stringResource(R.string.excess_text),
                isChecked = thirdPersonaNumberOption == Excess.value,
                onCheckedChange = { isChecked ->
                    thirdPersonaNumberOption = if (isChecked) Excess.value else None.value
                }
            )

            SingleCheckboxRow(
                label = stringResource(R.string.lack_text),
                isChecked = thirdPersonaNumberOption == Lack.value,
                onCheckedChange = { isChecked ->
                    thirdPersonaNumberOption = if (isChecked) Lack.value else None.value
                }
            )

            SingleCheckboxRow(
                label = stringResource(R.string.balanced_text),
                isChecked = thirdPersonaNumberOption == Balanced.value,
                onCheckedChange = { isChecked ->
                    thirdPersonaNumberOption = if (isChecked) Balanced.value else None.value
                }
            )
        }
        Spacer(modifier = Modifier.height(28.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = firstPersonaNumber != "" && secondPersonaNumber != "" && thirdPersonaNumber != "" /*Move logic to viewModel*/,
            onClick = { /*ViewModel logic here - catch all fields*/ viewModel }) {
            Text(stringResource(R.string.persona_calculate_text))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesignedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    focusRequester: FocusRequester? = null
) {
    var borderColor by remember { mutableStateOf(Color.Gray) }

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        modifier = modifier
            .focusRequester(focusRequester ?: FocusRequester())
            .onFocusChanged { state ->
                borderColor = if (state.isFocused) {
                    Color.Green
                } else {
                    Color.Red
                }
            }
            .fillMaxWidth()
            .border(
                width = .5.dp,
                color = borderColor,
                shape = RectangleShape
            )
    )
}


@Composable
fun SingleCheckboxRow(
    label: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.wrapContentSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 16.sp
        )
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
fun PersonaScreen(
    navController: NavController,
    viewModel: PersonaScreenViewModel = hiltViewModel()
) {
    ThreeTextFieldsWithCheckboxes(navController, viewModel)
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        /*PersonaScreen()*/
    }
}

enum class PersonaKind(val value: Int) {
    None(0),
    Excess(1),
    Lack(2),
    Balanced(3)

}
