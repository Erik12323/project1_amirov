fun main(args: Array<String>) {
    while (true) {
        println("0 выход")
        println("1 задача")
        println("2 задача")
        println("3 задача")
        println("4 задача")
        println("5 задача")
        println("6 задача")
        println("выберите пункт меню: ")

        val input = readln()
        when (input) {
            "0" -> return
            "1" -> task1()
            "2" -> task2()
            "3" -> task3()
            "4" -> task4()
            "5" -> task5()
            "6" -> task6()
            else -> println("Невернный ввод")
        }
    }
}
    fun task1() {
            println("Введите строку:")
            val input = readLine() ?: ""
            if (input.isEmpty()) {
                println("")
                return
            }
            val result = StringBuilder()
            var currentChar = input[0]
            var count = 1
            for (i in 1 until input.length) {
                if (input[i] == currentChar) {
                    count++
                } else {
                    result.append(currentChar)
                    if (count > 1) result.append(count)
                    currentChar = input[i]
                    count = 1
                }
            }
            result.append(currentChar)
            if (count > 1) result.append(count)
            println(result.toString())
        }


    fun task2() {
            print("Введите строку: ")
            val input = readLine() ?: ""
            val counts = java.util.TreeMap<Char, Int>()
            for (ch in input) {
                counts[ch] = counts.getOrDefault(ch, 0) + 1
            }
            if (counts.isEmpty()) {
                println("Строка пуста или не прочиталась.")
            } else {
                for ((char, count) in counts) {
                    println("$char - $count")
                }
            }
        }


    fun task3() {
            print("Введите натуральное число: ")
            val input = readLine()
            if (input.isNullOrBlank()) {
                println("Ошибка: введена пустая строка")
                return
            }
            val number = input.toIntOrNull()
            if (number == null || number <= 0) {
                println("Ошибка: введите корректное натуральное число (> 0)")
                return
            }
            val binary = number.toString(2)
            println("Число $number в двоичной системе: $binary")
        }


    fun task4() {
            print("Введите два числа и операцию (пример: 3.5 2.1 +): ")
            val input = readLine()

            if (input.isNullOrBlank()) {
                println("Ошибка: пустой ввод")
                return
            }
            val parts = input.trim().split(" ")
            if (parts.size != 3) {
                println("Ошибка: ожидалось 3 элемента, разделённых пробелом")
                return
            }
            val num1 = parts[0].toDoubleOrNull()
            val num2 = parts[1].toDoubleOrNull()
            val op = parts[2]
            if (num1 == null || num2 == null) {
                println("Ошибка: введены неверные числа")
                return
            }
            val result = when (op) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> {
                    if (num2 == 0.0) {
                        println("Ошибка: деление на ноль")
                        return
                    } else num1 / num2
                }

                else -> {
                    println("Ошибка: неизвестная операция '$op'")
                    return
                }
            }
            println("Результат: $result")
        }


    fun task5() {
            print("Введите целое число n: ")
            val nInput = readLine()
            print("Введите основание степени x: ")
            val xInput = readLine()
            val n = nInput?.toLongOrNull()
            val x = xInput?.toLongOrNull()
            if (n == null || x == null) {
                println("Ошибка: введите корректные целые числа")
                return
            }
            // Особые случаи
            if (n == 1L) {
                // Для любого x != 0, x^0 = 1
                println("0")
                return
            }
            if (x == 0L) {
                // 0^y = n
                if (n == 0L) {
                    println("1") // 0^1=0
                } else {
                    println("Целочисленный показатель не существует")
                }
                return
            }
            if (x == 1L) {
                if (n == 1L) {
                    println("0")
                } else {
                    println("Целочисленный показатель не существует")
                }
                return
            }
            var y = 0L
            var power = 1L
            while (true) {
                if (power == n) {
                    println(y)
                    return
                }
                if ((x > 1 && kotlin.math.abs(power) > kotlin.math.abs(n)) ||
                    (x < -1 && ((y > 0 && kotlin.math.abs(power) > kotlin.math.abs(n))))
                ) {
                    break
                }
                y++
                power *= x
                if (power == 0L && n != 0L) break
            }
            println("Целочисленный показатель не существует")
        }


    fun task6() {
            println("Введите первую цифру:")
            val aInput = readLine()
            println("Введите вторую цифру:")
            val bInput = readLine()
            val a = aInput?.toIntOrNull()
            val b = bInput?.toIntOrNull()
            if (a == null || b == null || a !in 0..9 || b !in 0..9) {
                println("Ошибка: введите корректные цифры от 0 до 9")
                return
            }
            if (a == b) {
                println("Ошибка: цифры должны быть различны")
                return
            }
            val candidates = mutableListOf<Int>()
            candidates.add(a)
            candidates.add(b)
            candidates.add(a * 10 + b)
            candidates.add(b * 10 + a)
            val oddNumbers = candidates.filter { it % 2 == 1 }

            if (oddNumbers.isEmpty()) {
                println("Создать нечетное число невозможно")
            } else {
                println(oddNumbers.maxOrNull())
            }
        }


