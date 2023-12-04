package com.lifitness.domain.use_case

import android.util.Patterns

class ValidateEmail {
    fun execute(email : String) : ValidationResult{
        if(email.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "O e-mail não pode ficar em branco"
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(
                successful = false,
                errorMessage = "Esse não é um e-mail válido"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}