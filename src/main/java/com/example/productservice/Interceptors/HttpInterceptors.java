package com.example.productservice.Interceptors;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class HttpInterceptors implements ClientHttpRequestInterceptor {

    private String head;
    private String value;
    public HttpInterceptors(String head, String value) {

        this.head = head;
        this.value = value;

    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        return null;
    }

}
