// https://www.hackerrank.com/challenges/s10-interquartile-range/problem

fun median(numbers: List<Int>): Double {
    val length = numbers.size

    return if (length % 2 == 1) {
        numbers[length / 2].toDouble()
    } else {
        (numbers[length / 2] + numbers[length / 2 - 1]).toDouble() / 2.0
    }
}

fun main() {
    readLine()!!.toInt()
    val allNumbers = mutableListOf<Int>()
    val numbers = readLine()!!.split(" ").map { it.toInt() }

    val frequencies = readLine()!!.split(" ").map { it.toInt() }
    frequencies.forEachIndexed { idx, frequency ->
        repeat(frequency) {
            allNumbers.add(numbers[idx])
        }
    }

    allNumbers.sort()
    val numOfNumbers = frequencies.sum()

    val q1 = median(allNumbers.subList(0, numOfNumbers / 2))
    val q3 = if (numOfNumbers % 2 == 1) median(
        allNumbers.subList(
            numOfNumbers / 2 + 1,
            numOfNumbers
        )
    ) else median(allNumbers.subList(numOfNumbers / 2, numOfNumbers))

    val range = q3 - q1
    println("%.1f".format(range))
}