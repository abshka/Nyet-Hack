var heroName: String = ""

fun main() {

    heroName = promptHeroName()
    // changeNarratorMood()
    narrate("$heroName, ${createTitle(heroName)}, heads to the town square")
    visitTavern()
}

private fun createTitle(name: String): String {
    return when {
        name.all { it.isDigit() } -> "The Identifiable"
        name.none { it.isLetter() } -> "The Witness Protection Member"
        name.count { it.lowercase() in "aeiou" } > 4 -> "The Master of Vowel"
        name.all { it.isUpperCase() } -> "The Outstanding"
        name.length > 10 -> "The Wordy"
        name.lowercase() == name.reversed().lowercase() -> "The Palindrome Bearer"
        name.none { it.lowercase() in "aeiou" } -> "The Stealthy"
        name.count { it.lowercase() in "aeiou" } > 3 -> "The Eternal Wanderer"
        name.length < 4 -> "The Brief"
        name.any { !it.isLetterOrDigit() } -> "The Enigmatic"
        name.first().lowercaseChar() in "sky" -> "The Celestial"
        name.first().isUpperCase() -> "The Born Leader"
        name.lowercase().contains('r') -> "The Brave"
        name.lowercase().contains('y') -> "The Wise"
        name.length == 7 -> "The Great"
        name.zipWithNext().any { it.first == it.second } -> "The Unconquerable"
        else -> "The Renowned Hero"
    }
}

private fun promptHeroName(): String {
    narrate("A hero enters the town of Kronstadt. What is their name?") {
        message -> "\u001b[33;1m$message\u001b[0m"
    }
    /*val input = readline()
    require(input != null && input.isNotEmpty()) {
        "The hero must have a name."
        }
     return input*/
    println("Madrigal")
    return "Madrigal"
}