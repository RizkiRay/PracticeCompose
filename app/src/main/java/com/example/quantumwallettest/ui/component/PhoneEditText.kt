package com.example.quantumwallettest.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.quantumwallettest.R


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 11/06/23.
 */

@Composable
fun PhoneEditText(
    value: String,
    leftText: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.background(
            color = Color(0xFFF4F9FE),
            shape = RoundedCornerShape(16.dp)
        ),
        horizontalArrangement = Arrangement.End
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFFA8C3EC),
                modifier = Modifier.padding(start = 24.dp, top = 16.dp, end = 24.dp)
            )
            Row {
                Text(
                    text = leftText,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFFA8C3EC),
                    modifier = Modifier.padding(start = 24.dp, top = 8.dp, bottom = 16.dp)
                )
                BasicTextField(
                    value = value,
                    textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color(0xFF313F51)),
                    onValueChange = onValueChange,
                    modifier = Modifier.padding(
                        start = 8.dp,
                        top = 8.dp,
                        bottom = 16.dp,
                        end = 8.dp
                    ).weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_country_flag),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 24.dp)
        )
    }
}