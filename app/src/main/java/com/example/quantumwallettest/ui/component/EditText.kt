package com.example.quantumwallettest.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 11/06/23.
 */

@Composable
fun EditText(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions()
) {
    Column(
        modifier = modifier.background(
            color = Color(0xFFF4F9FE),
            shape = RoundedCornerShape(16.dp)
        )
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFFA8C3EC),
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
        )
        BasicTextField(
            value = value,
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color(0xFF313F51)),
            onValueChange = onValueChange,
            keyboardOptions = keyboardOptions,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 16.dp, end = 16.dp)
        )
    }
}