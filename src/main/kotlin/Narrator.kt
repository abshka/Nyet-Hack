import kotlin.random.Random
import kotlin.random.nextInt

var narrationModifier: (String) -> String = { it
}

inline fun narrate(
    message: String,
    modifier: (String) -> String = { narrationModifier(it) }
) {
    println(modifier(message))
}

fun changeNarratorMood() {
    var mood = "neutral"
    var modifier: (String) -> String = { it }
    when (Random.nextInt(1..10)) {
        1 -> {
            mood = "loud"
            modifier = { message -> message.uppercase() + "!".repeat(3) }
        }
        2 -> {
            mood = "tired"
            modifier = { message -> message.lowercase().replace(" ", "... ") }
        }
        3 -> {
            mood = "unsure"
            modifier = { message -> "$message?" }
        }
        4 -> {
            var narrationsGiven = 0
            mood = "like sending an itemized bill"
            modifier = { message -> narrationsGiven++; "$message.\n(I have narrated $narrationsGiven things)" }
        }
        5 -> {
            mood = "professional"
            modifier = { message -> "$message." }
        }
        6 -> {
            mood = "lazy"
            modifier = { message -> message.take(message.length / 2) }
        }
        7 -> {
            mood = "mysterious"
            val leetMap = mapOf('a' to '4', 'e' to '3', 'i' to '1', 'o' to '0', 't' to '7', 's' to '5')
            modifier = { message -> message.map { leetMap[it.lowercaseChar()] ?: it }.joinToString("") }
        }
        8 -> {
            mood = "poetic"
            val random = Random.Default
            modifier = {message -> message.split(" ").joinToString(" \n") { if (random.nextBoolean()) it else "\n$it" }}
        }
        9 -> {
            mood = "nostalgic"
            val nostalgicWords = listOf("back in the day", "remember when", "in the good old times")
            modifier = { message -> nostalgicWords.random() + ", " + message }
        }
        10 -> {
            mood = "chaotic"
            modifier = { message -> message.split(" ").shuffled().joinToString(" ")}
        }
    }
    narrationModifier = modifier
    narrate("The narrator begins to feel $mood")
}
