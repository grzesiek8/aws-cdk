package lambda

import lambda.resources.LambdaHandler
import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.core.Duration
import software.amazon.awscdk.core.Stack
import software.amazon.awscdk.core.StackProps
import software.amazon.awscdk.services.lambda.Code
import software.amazon.awscdk.services.lambda.Runtime

class TestStack(scope: Construct?, id: String?, props: StackProps?) : Stack(scope, id, props) {
    constructor(scope: Construct?, id: String?) : this(scope, id, null) {}

    init {
        //DatabaseConstruct(this,"RdsDatabase","alpha")
//        LambdaConstruct(this, "SimpleLambda", LambdaProps(
//                code = Code.fromAsset("build/libs/lambda.jar"),
//                runtime = Runtime.JAVA_11,
//                handler = LambdaHandler::class.qualifiedName,
//                timeout = Duration.minutes(5)
//        ))
        AppConstruct(this,"APP")
    }
}