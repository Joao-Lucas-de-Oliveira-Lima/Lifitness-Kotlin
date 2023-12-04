package com.lifitness.domain.use_case

import android.util.Patterns

class ValidatePassword {
    fun execute(password: String) : ValidationResult{
        if(password.length < 8){
            return ValidationResult(
                successful = false,
                errorMessage = "A senha deve consistir de pelo menos 8 caracteres"
            )
        }
        // Todo: most secure password pattern
        val containsLettersAndDigits = password.any() {it.isDigit()} && password.any() {it.isLetter()}
        if(!containsLettersAndDigits){
            return ValidationResult(
                successful = false,
                errorMessage = "A senha deve conter pelo menos um número e uma letra"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}