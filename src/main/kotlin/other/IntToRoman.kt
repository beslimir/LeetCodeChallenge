package other

fun main(args: Array<String>) {
    println(intToRoman(2987))
}

fun intToRoman(num: Int): String {
    var res = ""
    var number = num

    while (number > 0) {
        when {
            //thousands
            number > 999 -> {
                res += "M"
                number -= 1000
            }
            //five-hundreds
            number > 499 -> {
                if (number > 899) {
                    res += "CM"
                    number -= 900
                } else {
                    res += "D"
                    number -= 500
                }
            }
            //hundreds
            number > 99 -> {
                if (number > 399) {
                    res += "CD"
                    number -= 400
                } else {
                    res += "C"
                    number -= 100
                }
            }
            //fifties
            number > 49 -> {
                if (number > 89) {
                    res += "XC"
                    number -= 90
                } else {
                    res += "L"
                    number -= 50
                }
            }
            //tens
            number > 9 -> {
                if (number > 39) {
                    res += "XL"
                    number -= 40
                } else {
                    res += "X"
                    number -= 10
                }
            }
            //fives
            number > 4 -> {
                if (number > 8) {
                    res += "IX"
                    number -= 9
                } else {
                    res += "V"
                    number -= 5
                }
            }
            //ones
            number > 0 -> {
                if (number > 3) {
                    res += "IV"
                    number -= 4
                } else {
                    res += "I"
                    number -= 1
                }
            }
        }
    }

    return res
}