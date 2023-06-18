package com.example.quantumwallettest.ui.component

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 11/06/23.
 */

@Composable
fun ClickSpannableText(
    regularText: String,
    clickableText: String,
    modifier: Modifier = Modifier,
    onClick: (AnnotatedString.Range<String>) -> Unit = {}
) {
    val annotatedString = buildAnnotatedString {
        append(regularText)
        withStyle(style = SpanStyle(Color(0xFF5EA7FF))) {
            pushStringAnnotation(clickableText, clickableText)
            append(" $clickableText")
        }
    }
    ClickableText(text = annotatedString,
        style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFFA8C3EC)),
        modifier = modifier,
        onClick = {
            annotatedString.getStringAnnotations(it, it).firstOrNull()?.let { span ->
                onClick.invoke(span)
            }
        })
}