package com.lifitness.domain.use_case

import android.util.Patterns
import co.yml.charts.common.extensions.isNotNull

class ValidateAge {
    fun execute(age : String) : ValidationResult{
        if(age.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "The age field can't be blank"
            )
        }
        var ageAsInt: Int
        try{
            ageAsInt = age.toInt()
        }catch(e: Exception){
            return ValidationResult(
                successful = false,
                errorMessage = "The age field is not in a valid format"
            )
        }

        if(ageAsInt <  10 || ageAsInt > 150){
            return ValidationResult(
                successful = false,
                errorMessage = "The age field must be greater than or equal to 10 and less than or equal to 150"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}