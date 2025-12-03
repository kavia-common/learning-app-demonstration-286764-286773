package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Basic API endpoints for the Learning App.
 */
@RestController
@Tag(name = "Hello Controller", description = "Basic endpoints for Learning App")
public class HelloController {

    // PUBLIC_INTERFACE
    /**
     * Simple hello endpoint for API sanity checks.
     * @return welcome message
     */
    @GetMapping("/api/hello")
    @Operation(summary = "Welcome endpoint", description = "Returns a welcome message")
    public String hello() {
        return "Hello, Spring Boot! Welcome to the Learning App";
    }

    // PUBLIC_INTERFACE
    /**
     * Redirect to Swagger UI (OpenAPI docs), preserving original scheme/host/port behind proxies.
     * @param request incoming HTTP request
     * @return redirect to swagger-ui.html
     */
    @GetMapping("/docs")
    @Operation(summary = "API Documentation", description = "Redirects to Swagger UI preserving original scheme/host/port")
    public RedirectView docs(HttpServletRequest request) {
        String target = UriComponentsBuilder
                .fromHttpRequest(new ServletServerHttpRequest(request))
                .replacePath("/swagger-ui.html")
                .replaceQuery(null)
                .build()
                .toUriString();

        RedirectView rv = new RedirectView(target);
        rv.setHttp10Compatible(false);
        return rv;
    }

    // PUBLIC_INTERFACE
    /**
     * Application health check endpoint.
     * @return OK text
     */
    @GetMapping("/health")
    @Operation(summary = "Health check", description = "Returns application health status")
    public String health() {
        return "OK";
    }

    // PUBLIC_INTERFACE
    /**
     * Basic application information.
     * @return info text
     */
    @GetMapping("/api/info")
    @Operation(summary = "Application info", description = "Returns application information")
    public String info() {
        return "Spring Boot Application: learning-app-demo";
    }
}
