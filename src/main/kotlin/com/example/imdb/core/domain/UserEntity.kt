package com.example.imdb.core.domain

import com.example.imdb.common.BaseTimeEntity
import com.example.imdb.core.api.request.SignupRequest
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

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
        fun of(signupRequest: SignupRequest, encodedPassword: String): UserEntity {
            signupRequest.run {
                return UserEntity(email, encodedPassword, nickname, telephone, role)
            }
        }
    }

}