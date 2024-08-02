package example.com.application.handlers

import example.com.application.commands.CreateUserCommand
import example.com.domain.entities.User
import example.com.infrastructure.MongoUserRepository
import java.util.UUID

class CreateUserHandler(
    private val userRepository: MongoUserRepository
) {
    fun handle(command: CreateUserCommand) {
        val user = User(
            UUID.randomUUID().toString(),
            command.name,
            command.lastName,
            command.email
        )

        userRepository.save(user)
    }


}