package example.com.plugins

import io.github.smiley4.ktorswaggerui.SwaggerUI
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.webjars.*

fun Application.configureRouting() {
    install(Webjars) {
        path = "/webjars" //defaults to /webjars
    }
    install(SwaggerUI) {
        swagger {
            swaggerUrl = "swagger-ui"
            forwardRoot = true
        }
        info {
            title = "Example API"
            version = "latest"
            description = "Example API for testing and demonstration purposes."
        }
        server {
            url = "http://localhost:8080"
            description = "Development Server"
        }
    }
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/webjars") {
            call.respondText("<script src='/webjars/jquery/jquery.js'></script>", ContentType.Text.Html)
        }
    }
    routing {
        // Add the five lines below
        get("/test1") {
            val text = "<h1>Hello From Ktor</h1>"
            val type = ContentType.parse("application/json")
            call.respond("{\n" +
                    "  \"id\": 12345,\n" +
                    "  \"username\": \"john_doe\",\n" +
                    "  \"email\": \"john.doe@example.com\",\n" +
                    "  \"profile\": {\n" +
                    "    \"first_name\": \"John\",\n" +
                    "    \"last_name\": \"Doe\",\n" +
                    "    \"age\": 30,\n" +
                    "    \"gender\": \"male\",\n" +
                    "    \"location\": {\n" +
                    "      \"city\": \"New York\",\n" +
                    "      \"state\": \"NY\",\n" +
                    "      \"country\": \"USA\"\n" +
                    "    },\n" +
                    "    \"preferences\": {\n" +
                    "      \"newsletter\": true,\n" +
                    "      \"notifications\": {\n" +
                    "        \"email\": true,\n" +
                    "        \"sms\": false\n" +
                    "      }\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"friends\": [\n" +
                    "    {\n" +
                    "      \"id\": 67890,\n" +
                    "      \"username\": \"jane_smith\",\n" +
                    "      \"first_name\": \"Jane\",\n" +
                    "      \"last_name\": \"Smith\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": 54321,\n" +
                    "      \"username\": \"sam_jones\",\n" +
                    "      \"first_name\": \"Sam\",\n" +
                    "      \"last_name\": \"Jones\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}")
//            call.respondText(text, type)
        }
    }
}
