package lambda

import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.services.apigateway.LambdaIntegration
import software.amazon.awscdk.services.apigateway.RestApi
import software.amazon.awscdk.services.apigateway.StageOptions
import software.amazon.awscdk.services.lambda.Function

class LambdaConstruct(scope: Construct, id: String, props: LambdaProps) : Construct(scope, id) {
    init {
        val lambdaHandler = Function.Builder.create(this, id)
                .runtime(props.runtime)
                .code(props.code)
                .handler(props.handler)
                .timeout(props.timeout)
                .memorySize(props.memorySize)
                .build()

        val restApi = RestApi.Builder.create(this, "Lambda-API!")
                .restApiName("Lambda API!")
                .deployOptions(StageOptions.builder().stageName("dev").build())
                .description("API For Lambdaaa!!!!")
                .build()

        val lambdaIntegration = LambdaIntegration.Builder.create(lambdaHandler).build()

        restApi.root.addMethod("POST", lambdaIntegration)
    }
}