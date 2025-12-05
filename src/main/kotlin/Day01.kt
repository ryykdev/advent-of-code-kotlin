fun main() {
    fun part1(input: List<String>): Int {
        var zero_count = 0
        var lock = Lock()

       val list_int = parse_to_list_int(input)

        for (turn in list_int) {
            if (lock.dial(turn) == 0) {
                zero_count += 1
            }
        }

        return zero_count
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 3)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 3)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

// the Lock is a rotating dial 0-99
class Lock {

    val capacity = 100
    var position = 50

    constructor() {
        this.position = 50
    }

 fun dial(turn: Int): Int {
       position = (position + 100 + turn) % 100;
        return position
    }
}

fun parse_to_list_int(input: List<String>): List<Int> {
    var list_ints: MutableList<Int> = mutableListOf()
    for (s in input) {
        var sign = 1
        val stringInteger = when {
           s.startsWith("L") -> {
               sign = -1
               s.removePrefix("L")
           }
            s.startsWith("R") -> {
                s.removePrefix("R")
            }
            else -> {
                   "0"
            }
        }
        // convert to Int and add to list
        val n = stringInteger.toInt()

        list_ints.add(n * sign)
    }
    return    list_ints
}