package other

fun main(args: Array<String>) {
    println(fizzBuzz2(15))
}

fun fizzBuzz(n: Int): List<String> {
    val myList = mutableListOf<String>()

    for (i in 1..n) {
        if (i % 3 == 0 && i % 5 == 0) {
            myList.add("FizzBuzz")
        } else if (i % 5 == 0) {
            myList.add("Buzz")
        } else if (i % 3 == 0) {
            myList.add("Fizz")
        } else {
            myList.add("$i")
        }
    }

    return myList
}

fun fizzBuzz2(n: Int): List<String> {
    val myList = mutableListOf<String>()

    for (i in 1..n) {
        when {
            i % 3 == 0 && i % 5 == 0 -> myList.add("FizzBuzz")
            i % 5 == 0 -> myList.add("Buzz")
            i % 3 == 0 -> myList.add("Fizz")
            else -> myList.add("$i")
        }
    }

    return myList
}