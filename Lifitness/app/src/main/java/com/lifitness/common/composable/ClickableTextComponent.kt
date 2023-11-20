package com.lifitness.common.composable

import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.lifitness.app.LifitnessScreen

@Composable
fun ClickablePolicyTextAndTermsTextComponent(text: String) {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy policy "
    val andText = "and "
    val termsAndConditionslText = "Term of Use"

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(Color.White)) {
            append(initialText)
        }
        withStyle(style = SpanStyle(Color(173, 216, 230))) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        withStyle(style = SpanStyle(Color.White)) {
            append(andText)
        }
        withStyle(style = SpanStyle(Color(173, 216, 230))) {
            pushStringAnnotation(
                tag = termsAndConditionslText,
                annotation = termsAndConditionslText
            )
            append(termsAndConditionslText)
        }
    }

    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("clickableTextComponent", "{$span.item}")
            }
    })
}

@Composable
fun ClickableLoginTextComponent(text: String, onClick: () -> Unit) {
    val initialText = "Already hava an account? "
    val loginText = "Login"

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(Color.White)) {
            append(initialText)
        }
        withStyle(style = SpanStyle(Color(173, 216, 230))) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }
    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                if (span.item == loginText) {
                    onClick()
                }
            }
    })
}

@Composable
fun ClickableForgotYouPasswordTextComponent(text: String) {
    val text = "Forgot your password? "

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(Color(173, 216, 230))) {
            pushStringAnnotation(tag = text, annotation = text)
            append(text)
        }
    }
    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("clickableTextComponent", "{$span.item}")
            }
    })
}


@Composable
fun ClickableDontHaveAnAccountTextComponent(text: String, onClick: () -> Unit) {
    val initialText = "Don't hava an account yet? "
    val registerText = "Register"

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(Color.White)) {
            append(initialText)
        }
        withStyle(style = SpanStyle(Color(173, 216, 230))) {
            pushStringAnnotation(tag = registerText, annotation = registerText)
            append(registerText)
        }
    }
    ClickableText(text = annotatedString, onClick = {offset ->
        val clickedTag = annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.tag
        if (clickedTag == registerText) {
            // Handle click on "Register" text, e.g., navigate to the registration screen
            onClick()
        }
    })
}

@Preview
@Composable
fun PreviewClickablepolicyTextAndTermsTextComponent() {
    ClickablePolicyTextAndTermsTextComponent("Preview")
}

@Preview
@Composable
fun PreviewClickableLoginTextComponent() {
    ClickablePolicyTextAndTermsTextComponent(text = "preview")
}