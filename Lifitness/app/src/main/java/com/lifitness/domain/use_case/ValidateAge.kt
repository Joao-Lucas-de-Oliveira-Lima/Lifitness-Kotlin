package com.lifitness.domain.use_case

import android.util.Patterns
import co.yml.charts.common.extensions.isNotNull

class ValidateAge {
    fun execute(age : String) : ValidationResult{
        if(age.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "O campo idade não pode ficar em branco"
            )
        }
        var ageAsInt: Int
        try{
            ageAsInt = age.toInt()
        }catch(e: Exception){
            return ValidationResult(
                successful = false,
                errorMessage = "O campo de idade não está em um formato válido"
            )
        }

        if(ageAsInt <  10 || ageAsInt > 150){
            return ValidationResult(
                successful = false,
                errorMessage = "O campo idade deve ser maior ou igual a 10 e menor ou igual a 150"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}