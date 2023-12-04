package com.lifitness.domain.use_case

import com.lifitness.repository.UserRepository

class CheckingDuplicateUsername {
    suspend fun execute(username: String): ValidationResult {
        var userRepository = UserRepository()
        var userWithTheSameUsername = userRepository.getUserByUsername(username)
        if(userWithTheSameUsername != null){
            return ValidationResult(
                successful = false,
                errorMessage = "O nome de usuário já existe"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}