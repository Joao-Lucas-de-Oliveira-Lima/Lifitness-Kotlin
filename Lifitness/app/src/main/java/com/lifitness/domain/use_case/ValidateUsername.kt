package com.lifitness.domain.use_case

import android.util.Patterns
import com.lifitness.repository.UserRepository

class ValidateUsername {
    fun execute(username : String) : ValidationResult{
        if(username.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "O nome de usuário não pode ficar em branco"
            )
        }
        //Todo: Validation for creating new usernames
        return ValidationResult(
            successful = true
        )
    }
}