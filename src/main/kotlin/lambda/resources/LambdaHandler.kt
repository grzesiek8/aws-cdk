package lambda.resources;

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import java.net.HttpURLConnection
import com.google.gson.Gson

class LambdaHandler : RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    override fun handleRequest(input: APIGatewayProxyRequestEvent, context: Context): APIGatewayProxyResponseEvent {
        if (input.body == null) {
            throw IllegalArgumentException("Upsi, empty body")
        }

        return try {
            val requestName = Gson().fromJson(input.body, InputData::class.java).name
            APIGatewayProxyResponseEvent().withBody("Welcome $requestName the great master of Kotlin and AWS CDK!").withStatusCode(HttpURLConnection.HTTP_OK)
        } catch (e: IllegalArgumentException) {
            APIGatewayProxyResponseEvent().withBody(e.message).withStatusCode(HttpURLConnection.HTTP_BAD_REQUEST)
        }
    }
}