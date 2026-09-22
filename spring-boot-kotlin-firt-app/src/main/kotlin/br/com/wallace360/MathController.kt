package br.com.wallace360

import br.com.wallace360.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong


@RestController
class MathController {
    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {

        // Tenta converter ambos para Double
        val first = numberOne?.toDoubleOrNull()
        val second = numberTwo?.toDoubleOrNull()

        // Se qualquer um for nulo (ou seja, não era um número válido), lança a sua exceção
        if (first == null || second == null) {
            throw UnsupportedMathOperationException("Please set a numeric value")
        }

        return first + second
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {

        val first = numberOne?.toDoubleOrNull()
        val second = numberTwo?.toDoubleOrNull()

        if (first == null || second == null) {
            throw UnsupportedMathOperationException("Please set a numeric value")
        }

        return first - second
    }

    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {

        val first = numberOne?.toDoubleOrNull()
        val second = numberTwo?.toDoubleOrNull()

        if (first == null || second == null) {
            throw UnsupportedMathOperationException("Please set a numeric value")
        }

        return first / second
    }

    @RequestMapping(value = ["/mul/{numberOne}/{numberTwo}"])
    fun mul(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {

        val first = numberOne?.toDoubleOrNull()
        val second = numberTwo?.toDoubleOrNull()

        if (first == null || second == null) {
            throw UnsupportedMathOperationException("Please set a numeric value")
        }

        return first * second
    }

    @RequestMapping(value = ["/sqrt/{numberOne}"])
    fun sqrt(
        @PathVariable(value = "numberOne") numberOne: String?
    ): Double {

        val first = numberOne?.toDoubleOrNull()

        if (first == null) {
            throw UnsupportedMathOperationException("Please set a numeric value")
        }

        return kotlin.math.sqrt(first)
    }
}