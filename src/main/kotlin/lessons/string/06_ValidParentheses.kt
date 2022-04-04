package lessons.string

fun main(args: Array<String>) {
    val str = "([)]"

    println(validParentheses(str))
}

fun validParentheses(str: String): Boolean {
    var stack = ArrayDeque<Char>()
    var hashMap: HashMap<Char, Char> = HashMap()
    hashMap[')'] = '('
    hashMap[']'] = '['
    hashMap['}'] = '{'

    for (i in str.indices) {
        if (stack.isNotEmpty()) {
            if (hashMap.containsKey(str[i]) && hashMap.getValue(str[i]) == stack[stack.size - 1]) {
                stack.removeLast()
            } else {
                stack.add(str[i])
            }
        } else {
            stack.add(str[i])
        }
    }

    return stack.isEmpty()
}