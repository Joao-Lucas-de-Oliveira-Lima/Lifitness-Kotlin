package com.lifitness.domain.use_case

class ValidateWeight {
    fun execute(weight : String) : ValidationResult{
        if(weight.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "The weight field can't be blank"
            )
        }
        var weightAsInt: Int
        try{
            weightAsInt = weight.toInt()
        }catch(e: Exception){
            return ValidationResult(
                successful = false,
                errorMessage = "The weight field is not in a valid format"
            )
        }

        if(weightAsInt < 1 || weightAsInt > 700){
            return ValidationResult(
                successful = false,
                errorMessage = "The weight field must be greater than or equal to 1kg and less than or equal to 700kg"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}