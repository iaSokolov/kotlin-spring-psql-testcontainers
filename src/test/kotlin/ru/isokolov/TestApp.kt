package ru.isokolov

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestApp

fun main(args: Array<String>) {
	fromApplication<App>().with(TestApp::class).run(*args)
}
