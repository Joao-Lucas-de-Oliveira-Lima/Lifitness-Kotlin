package com.lifitness.domain.use_case

class ValidateWeight {
    fun execute(weight : String) : ValidationResult{
        if(weight.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "O campo de peso não pode ficar em branco"
            )
        }
        var weightAsInt: Int
        try{
            weightAsInt = weight.toInt()
        }catch(e: Exception){
            return ValidationResult(
                successful = false,
                errorMessage = "O campo de peso não está em um formato válido"
            )
        }

        if(weightAsInt < 1 || weightAsInt > 730){
            return ValidationResult(
                successful = false,
                errorMessage = "O campo peso deve ser maior ou igual a 1kg e menor ou igual a 730kg"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}