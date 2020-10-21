package lambda

import software.amazon.awscdk.core.App

object TestApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val app = App()
        TestStack(app, "TestStack")
        println("two lambdas deployed to aws");
        app.synth()
    }
}