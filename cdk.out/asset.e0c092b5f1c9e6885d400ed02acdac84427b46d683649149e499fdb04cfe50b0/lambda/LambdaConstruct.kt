package lambda

import lambda.resources.LambdaHandler
import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.services.apigateway.LambdaIntegration
import software.amazon.awscdk.services.apigateway.RestApi
import software.amazon.awscdk.services.apigateway.StageOptions
import software.amazon.awscdk.services.lambda.Code
import software.amazon.awscdk.services.lambda.Function
import software.amazon.awscdk.services.lambda.Runtime

class LambdaConstruct(scope: Construct?, id: String?) : Construct(scope!!, id!!) {
    init {
        val lambdaHandler = Function.Builder.create(this, "Lambda")
                .runtime(Runtime.JAVA_11)
                .code(Code.fromAsset("src/main/kotlin"))
                .handler(LambdaHandler::class.qualifiedName)
                .build()

        val restApi = RestApi.Builder.create(this, "Lambda-API")
                .restApiName("Lambda API")
                .deployOptions(StageOptions.builder().stageName("dev").build())
                .description("API For Lambda")
                .build()

        val lambdaIntegration = LambdaIntegration(lambdaHandler)
        restApi.root.addMethod("GET", lambdaIntegration)

//        val bucket = Bucket(this, "WidgetStore")
//        val handler: Function = Function.Builder.create(this, "WidgetHandler")
//                .runtime(Runtime.NODEJS_10_X)
//                .code(Code.fromAsset("lambda.resources"))
//                .handler("widgets.main")
//                .environment(object : HashMap<String?, String?>() {
//                    init {
//                        put("BUCKET", bucket.bucketName)
//                    }
//                }).build()
//        bucket.grantReadWrite(handler)
//        val api: RestApi = RestApi.Builder.create(this, "Widgets-API")
//                .restApiName("Widget Service").description("This service services widgets.")
//                .build()
//        // Add new widget to bucket with: POST /{id}
//        val postWidgetIntegration = LambdaIntegration(handler)
//        // Get a specific widget from bucket with: GET /{id}
//        val getWidgetIntegration = LambdaIntegration(handler)
//        // Remove a specific widget from the bucket with: DELETE /{id}
//        val deleteWidgetIntegration = LambdaIntegration(handler)
//        api.root.addMethod("POST", postWidgetIntegration) // POST /{id}
//        api.root.addMethod("GET", getWidgetIntegration) // GET /{id}
//        api.root.addMethod("DELETE", deleteWidgetIntegration) // DELETE /{id}
    }
}