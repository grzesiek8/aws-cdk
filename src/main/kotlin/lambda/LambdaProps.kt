package lambda

import software.amazon.awscdk.services.iam.IRole
import software.amazon.awscdk.services.lambda.Code
import software.amazon.awscdk.services.lambda.Runtime

/**
 * Configuration class for Application Load Balanced Fargate Service
 */
class LambdaProps(
        /**
         * The runtime environment for the Lambda function that you are uploading.
         */
        val runtime: Runtime,

        /**
         * The source code of your Lambda function.
         */
        val code: Code,

        /**
         * The name of the method within your code that Lambda calls to execute your function.
         */
        val handler: String?,

        /**
         * Lambda execution role.
         */
        val role: IRole? = null,

        /**
         * A list of layers to add to the function's execution environment.
         */
        val environment: Map<String, String> = emptyMap(),


        /**
         * The function execution time (in seconds) after which Lambda terminates the function.
         */
        val timeout: software.amazon.awscdk.core.Duration?,


        /**
         * 	The amount of memory, in MB, that is allocated to your Lambda function.
         */
        val memorySize: Number = 1024
)

