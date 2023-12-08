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
fun ClickablePolicyTextAndTermsTextComponent(text: String, navController: NavHostController) {
    val initialText = "Continuando voce aceita nossa "
    val privacyPolicyText = "Política de privacidade "
    val andText = "e "
    val termsAndConditionslText = "Termo de uso"

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
                if ((span.item == termsAndConditionslText)) {

                        Log.d("Termos" ,"termos")
                        navController.navigate(LifitnessScreen.TermsAndConditions.name)

                }
            }
    })
}

@Composable
fun ClickableLoginTextComponent(text: String, onClick: () -> Unit) {
    val initialText = "Já tem conta? "
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
    val text = "Esqueceu a senha? "

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
    val initialText = "Não tem conta ainda? "
    val registerText = "Cadastrar"

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
