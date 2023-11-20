package com.lifitness.domain.use_case

import android.util.Patterns

class ValidateUsername {
    fun execute(username : String) : ValidationResult{
        if(username.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "The username can't be blank"
            )
        }
        //Todo: Validation for creating new usernames
        return ValidationResult(
            successful = true
        )
    }
}