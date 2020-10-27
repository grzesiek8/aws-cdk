package lambda

import lambda.resources.LambdaHandler
import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.core.Duration
import software.amazon.awscdk.services.apigateway.LambdaIntegration
import software.amazon.awscdk.services.apigateway.RestApi
import software.amazon.awscdk.services.apigateway.RestApiProps
import software.amazon.awscdk.services.apigateway.StageOptions
import software.amazon.awscdk.services.lambda.Code
import software.amazon.awscdk.services.lambda.Function
import software.amazon.awscdk.services.lambda.FunctionProps
import software.amazon.awscdk.services.lambda.Runtime

class AppConstruct(scope: Construct, id: String) : Construct(scope, id) {
    init {
//        val lambdaHandler = Function.Builder.create(this, id)
//                .runtime(props.runtime)
//                .code(props.code)
//                .handler(props.handler)
//                .timeout(props.timeout)
//                .memorySize(props.memorySize)
//                .build()
//
//        val restApi = RestApi.Builder.create(this, "Lambda-API!")
//                .restApiName("Lambda API!")
//                .deployOptions(StageOptions.builder().stageName("dev").build())
//                .description("API For Lambdaaa!!!!")
//                .build()
//
//        val lambdaIntegration = LambdaIntegration.Builder.create(lambdaHandler).build()
//
//        restApi.root.addMethod("POST", lambdaIntegration)

        val lambdaHandler = Function(this, "Lambda", FunctionProps.builder()
                .code(Code.fromAsset("./src/main/kotlin/lambda/resources"))
                .runtime(Runtime.NODEJS_10_X)
                .handler("lambdaHandler.main")
                .timeout(Duration.minutes(5))
                .build())

        
        val restApi = RestApi(this, "API", RestApiProps.builder()
                .restApiName("Lambda API!")
                .build())

        val lambdaIntegration = LambdaIntegration.Builder.create(lambdaHandler).build()

        restApi.root.addMethod("GET", lambdaIntegration)

    }
}