package ru.skillbranch.devintensive.models.data

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = null,
    var isOnline: Boolean = false
) {

    constructor(
        id: String,
        firstName: String?,
        lastName: String?
    ) : this(id, firstName, lastName, null)

    constructor(id: String) : this(id, "John", "Doe")

    companion object Factory {
        private var lastId = -1
        fun makeUser(fullName: String?): User {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(
                id = "$lastId",
                firstName = firstName,
                lastName = lastName
            )
        }
    }
}