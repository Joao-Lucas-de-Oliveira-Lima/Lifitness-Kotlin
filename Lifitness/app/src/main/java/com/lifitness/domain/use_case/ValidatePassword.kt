package com.lifitness.domain.use_case

import android.util.Patterns

class ValidatePassword {
    fun execute(password: String) : ValidationResult{
        if(password.length < 8){
            return ValidationResult(
                successful = false,
                errorMessage = "The password must consist of at least 8 characters"
            )
        }
        // Todo: most secure password pattern
        val containsLettersAndDigits = password.any() {it.isDigit()} && password.any() {it.isLetter()}
        if(!containsLettersAndDigits){
            return ValidationResult(
                successful = false,
                errorMessage = "The password must contain at least one number and one letter"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}