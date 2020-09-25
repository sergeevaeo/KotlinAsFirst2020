@file:Suppress("UNUSED_PARAMETER", "UNREACHABLE_CODE")

package lesson3.task1


import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.sqrt

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var count: Int
    var number = n
    count = if (number == 0) 1 else 0
    while (number > 0) {
        count++
        number /= 10
    }
    return count
}


/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int =
    when (n) {
        1, 2 -> 1
        else -> fib(n - 1) + fib(n - 2)
    }

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var m = 2
    while (m <= n) {
        if (n % m == 0) {
            return m
            break
        } else m++
    }
    return m
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    for (m: Int in n - 1 downTo 1) {
        if (n % m == 0) {
            return m
            break
        }
    }
    return 1
}

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var number = x
    var answer = 0
    while (number != 1) {
        if (number % 2 == 0) number /= 2
        else number = number * 3 + 1
        answer++
    }
    return answer
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var k = 1
    while (k <= n * m) {
        if (k % m == 0 && k % n == 0) break
        k++
    }
    return k
}

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var k = 0
    val max: Int = if (m >= n) m
    else n
    for (i: Int in 1..max) {
        if (m % i == 0 && n % i == 0) {
            k++
        }
    }
    return k == 1
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var k = 0
    for (i: Int in m..n) {
        val j: Double = sqrt(i.toDouble())
        val l = j.toInt()
        if (l * l == i) {
            k++
        }
    }
    return k > 0
}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var k = 0
    var s = n
    while (s > 0) {
        k = k * 10 + s % 10
        s /= 10
    }
    return k
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var k = 0
    var s = n
    while (s > 0) {
        k = k * 10 + s % 10
        s /= 10
    }
    return n == k
}

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var k = 0
    var a = n % 10
    var number = n / 10
    while (number > 0) {
        if (number % 10 != a) {
            k++
            break
        } else {
            a = number % 10
            number /= 10
        }
    }
    return k > 0
}


/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var k = 2
    var l: Double = x
    var m = x
    if (eps > 0.1) return 0.0
    while (abs(m) > eps) {
        m = -1 * m * sqr(x) / (k * (k + 1))
        l += m
        k += 2
    }
    if (l < -1.0) return 0.0
    if (l > 1.0) return 1.0
    return l
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    var k = 1
    var l = 1.0
    var m = 1.0
    while (abs(m) > eps) {
        m = -1 * m * x * x / (k * (k + 1))
        l += m
        k += 2
    }
    if (l < -1.0) return 0.0
    if (l > 1.0) return 1.0
    return l
}

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var sq: Int
    var pos = 0
    var step = 1
    var i = 0
    var p = 10
    var diff: Int
    while (pos < n) {
        i++
        sq = sqr(i)
        if (sq / p == 0) pos += step
        if (sq / p > 0) {
            step++
            pos += step
            p *= 10
        }
    }
    diff = pos - n + 1
    sq = sqr(i)
    while (diff > 1) {
        sq /= 10
        diff--
    }
    return if (sq / 10 != 0) {
        sq % 10
    } else sq
}

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var i = 0
    var s = 0
    var p = 10
    var d = 1
    var m: Int
    while (s < n) {
        i++
        m = fib(i)
        if (m / p == 0) s += d
        if (m / p > 0) {
            d += 1
            s += d
            p *= 10
        }
    }
    var t = s - n + 1
    m = fib(i)
    while (t > 1) {
        m /= 10
        t--
    }
    return if (m / 10 != 0) {
        m % 10
    } else m
}




