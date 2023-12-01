package com.lifitness.domain.use_case

import android.util.Patterns
import com.lifitness.repository.UserRepository

class ValidateUsername {
    var userRepository = UserRepository()
    fun execute(username : String) : ValidationResult{
        if(username.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "The username can't be blank"
            )
        }
        /*
        var userWithTheSameUsername = userRepository.getUserByUsername(username)
        if(userWithTheSameUsername != null){
            return ValidationResult(
                successful = false,
                errorMessage = "The username already exists"
            )
        }

         */
        //Todo: Validation for creating new usernames
        return ValidationResult(
            successful = true
        )
    }
}