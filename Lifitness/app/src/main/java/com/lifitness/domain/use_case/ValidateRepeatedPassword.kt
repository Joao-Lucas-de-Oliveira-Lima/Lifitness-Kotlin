package com.lifitness.domain.use_case

class ValidateRepeatedPassword {
    fun execute(password: String, repeatedPassword : String) : ValidationResult{
        if(password != repeatedPassword){
            return ValidationResult(
                successful = false,
                errorMessage = "As senhas não coincidem"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}