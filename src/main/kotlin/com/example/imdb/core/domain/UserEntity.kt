package com.example.imdb.core.domain

import com.example.imdb.common.BaseTimeEntity
import com.example.imdb.core.api.request.SignupRequest
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "Users")
class UserEntity(
        @Column
        var email: String?,

        @Column
        var password: String?,

        @Column
        var nickname: String?,

        @Column
        var telephone: String?,

        @Column
        var role: String?
) : BaseTimeEntity() {

    companion object {
        fun of(signupRequest: SignupRequest): UserEntity {
            signupRequest.run {
                return UserEntity(email, password, nickname, telephone, role)
            }
        }
    }

}