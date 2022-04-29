package lessons.string

fun main(args: Array<String>) {
    val str = "([{[]}])"

    println(validParentheses2(str))
}

//other solution
fun validParentheses(str: String): Boolean {
    val myMap: HashMap<Char, Char> = HashMap()
    myMap['('] = ')'
    myMap['['] = ']'
    myMap['{'] = '}'
    var r = 1
    var l = r - 1
    val myArray = str.toMutableList()

    while (myArray.size > 0 && r < myArray.size) {
        if (myArray[r] == myMap[myArray[l]]) {
            myArray.removeAt(r)
            myArray.removeAt(l)
            r = 1
            l = r - 1
        } else {
            l++
            r++
        }
    }

    return myArray.isEmpty()
}

fun validParentheses2(str: String): Boolean {
    val stack = ArrayDeque<Char>()
    val hashMap: HashMap<Char, Char> = HashMap()
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