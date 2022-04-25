package other

fun main(args: Array<String>) {
    println(fizzBuzz3(15))
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

fun fizzBuzz3(n: Int): List<String> {
    val res = Array(n) { "why" }
    var r = if (n % 2 == 0) {
        (n / 2)
    } else {
        (n / 2) + 1
    }
    var l = 1

    for (l in 1..n / 2 + 1) {
        when {
            l % 3 == 0 && l % 5 == 0 -> res[l - 1] = "FizzBuzz"
            l % 5 == 0 -> res[l - 1] = "Buzz"
            l % 3 == 0 -> res[l - 1] = "Fizz"
            else -> res[l - 1] = "$l"
        }

        when {
            r % 3 == 0 && r % 5 == 0 -> res[r - 1] = "FizzBuzz"
            r % 5 == 0 -> res[r - 1] = "Buzz"
            r % 3 == 0 -> res[r - 1] = "Fizz"
            else -> res[r - 1] = "$r"
        }
        r++
    }

    return res.toMutableList()
}