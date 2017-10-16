package com.anyun

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
open class KotlinDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinDemoApplication::class.java, *args)
}

@Service
class HelloService {

    val logging = LoggerFactory.getLogger(this::class.java)

    fun getHello(): String {
        logging.warn("into hello service")
        return "hello service"
    }

    fun postHello(name:String): String {
        logging.warn("into post service")
        return "post hello service = $name"
    }
}

@RestController
class HelloController(val helloService: HelloService) {

    val logging = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/hello")
    fun helloKotlinService(): String {
        logging.warn("into hello controller")
        return helloService.getHello()
    }

    @PostMapping("/post")
    fun myService(name:String):String {
        logging.warn("into post controller")
        return helloService.postHello(name)
    }
}

