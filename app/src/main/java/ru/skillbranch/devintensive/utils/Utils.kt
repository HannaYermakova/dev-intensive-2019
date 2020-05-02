package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.trim()?.split(" ")
        var firstName = parts?.getOrNull(0) ?: "null"
        val lastName = parts?.getOrNull(1) ?: "null"
        if (firstName == "" || firstName == " ") firstName = "null"
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val charArray: CharArray = payload.toCharArray()
        var nickName = ""
        for (c in charArray) {
            when (c) {
                'а' -> nickName += 'a'
                'б' -> nickName += 'b'
                'в' -> nickName += 'v'
                'г' -> nickName += 'g'
                'д' -> nickName += 'd'
                'е' -> nickName += 'e'
                'ё' -> nickName += 'e'
                'ж' -> nickName += "zh"
                'з' -> nickName += 'z'
                'и' -> nickName += 'i'
                'й' -> nickName += 'i'
                'к' -> nickName += 'k'
                'л' -> nickName += 'l'
                'м' -> nickName += 'm'
                'н' -> nickName += 'n'
                'о' -> nickName += 'o'
                'п' -> nickName += 'p'
                'р' -> nickName += 'r'
                'с' -> nickName += 's'
                'т' -> nickName += 't'
                'у' -> nickName += 'u'
                'ф' -> nickName += 'f'
                'х' -> nickName += 'h'
                'ц' -> nickName += 'c'
                'ч' -> nickName += "ch"
                'ш' -> nickName += "sh"
                'щ' -> nickName += "sh"
                'ъ' -> nickName += ""
                'ы' -> nickName += 'i'
                'ь' -> nickName += ""
                'э' -> nickName += "e"
                'ю' -> nickName += "yu"
                'я' -> nickName += "ya"
                ' ' -> nickName += divider
                else -> nickName += c
            }
        }
        return nickName
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val firstLetter = firstName?.trim()?.getOrNull(0)?.toUpperCase() ?: ""
        val secondLetter = lastName?.trim()?.getOrNull(0)?.toUpperCase() ?: ""
        return if (firstLetter != "" || secondLetter != "")
            "$firstLetter$secondLetter"
        else {
            "null"
        }
    }
}