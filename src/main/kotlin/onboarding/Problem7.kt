package onboarding

fun main(args: Array<String>) {
    val user = "mrko"
    val friends = listOf(
        listOf("donut", "andole"),
        listOf("donut", "jun"),
        listOf("donut", "mrko"),
        listOf("shakevan", "andole"),
        listOf("shakevan", "jun"),
        listOf("shakevan", "mrko")
    )
    val visitors = listOf("bedi", "bedi", "donut", "bedi", "shakevan")
    println(solution7(user, friends, visitors))
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendRelation = createFriendRelation(friends = friends)
}

fun createFriendRelation(friends: List<List<String>>): HashMap<String, MutableSet<String>> {
    val friendRelation = hashMapOf<String, MutableSet<String>>()

    friends.forEach { (friendA, friendB) ->
        friendRelation[friendA]?.add(friendB) ?: run {
            friendRelation[friendA] = mutableSetOf(friendB)
        }

        friendRelation[friendB]?.add(friendA) ?: run {
            friendRelation[friendB] = mutableSetOf(friendA)
        }
    }

    return friendRelation
}

const val MAX_RECOMMEND_NUM = 5
const val ACQUAINTANCE_SCORE = 10
const val VISITOR_SCORE = 1