package pl.mc.springboot.basics.springbootdemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class RestController {
    @GetMapping("books")
    fun getAllBooks(): List<Book> {
        return Arrays.asList(Book(1L, "Thinking in kotlin", "Janusz Tracewiczew"))
    }
}