package com.lifitness.domain.use_case

class ValidateHeight {
    fun execute(height : String) : ValidationResult{
        if(height.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "The height field can't be blank"
            )
        }
        var heightAsInt: Int
        try{
            heightAsInt = height.toInt()
        }catch(e: Exception){
            return ValidationResult(
                successful = false,
                errorMessage = "The height field is not in a valid format"
            )
        }

        if(heightAsInt < 50 || heightAsInt > 250){
            return ValidationResult(
                successful = false,
                errorMessage = "The height field must be greater than or equal to 50cm and less than or equal to 250cm"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}