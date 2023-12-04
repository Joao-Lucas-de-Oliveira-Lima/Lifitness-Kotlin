package com.lifitness.domain.use_case

class ValidateHeight {
    fun execute(height : String) : ValidationResult{
        if(height.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "O campo de altura não pode ficar em branco"
            )
        }
        var heightAsInt: Int
        try{
            heightAsInt = height.toInt()
        }catch(e: Exception){
            return ValidationResult(
                successful = false,
                errorMessage = "O campo de altura não está em um formato válido"
            )
        }

        if(heightAsInt < 50 || heightAsInt > 250){
            return ValidationResult(
                successful = false,
                errorMessage = "O campo de altura deve ser maior ou igual a 50cm e menor ou igual a 250cm"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}