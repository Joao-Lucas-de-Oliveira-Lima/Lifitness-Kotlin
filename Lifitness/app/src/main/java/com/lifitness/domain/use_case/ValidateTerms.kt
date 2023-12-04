package com.lifitness.domain.use_case

class ValidateTerms {
    fun execute(acceptedTerms : Boolean) : ValidationResult{
        if(!acceptedTerms){
            return ValidationResult(
                successful = false,
                errorMessage = "Por favor, aceite os termos"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}