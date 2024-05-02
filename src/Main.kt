fun main() {
    println(recommendItems("user1"))
}


val users = mapOf(
    "user1" to listOf("item1", "item2", "item3"),
    "user2" to listOf("item4", "item5", "item6")
)

val items = mapOf(
    "item1" to mapOf("name" to "Item One", "category" to "Electronics"),
    "item2" to mapOf("name" to "Item Two", "category" to "Clothing"),
    "item3" to mapOf("name" to "Item Three", "category" to "Home"),
    "item4" to mapOf("name" to "Item Four", "category" to "Electronics"),
    "item5" to mapOf("name" to "Item Five", "category" to "Clothing"),
    "item6" to mapOf("name" to "Item Six", "category" to "Home")
)

fun getUserPreferences(userId: String): List<String>? {
    return users[userId]
}

fun recommendItems(userId: String): List<Map<String, Any>> {
    val preferences = getUserPreferences(userId)?: return emptyList()
    val recommendedItems = mutableListOf<Map<String, Any>>()

    preferences.forEach { preference ->
        if (items.containsKey(preference)) {
            recommendedItems.add(items[preference]!!)
        }
    }

    return recommendedItems
}



