package org.demon.java11;

import org.junit.Test;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author demon
 * @version 1.0
 * @date 2018/11/2 11:58
 * @since 1.0
 */
public class HttpTester {

    /**
     * 设置超时时间
     */
    @Test
    public void test_01() throws IOException, InterruptedException, ExecutionException {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofMillis(5000))
                .version(HttpClient.Version.HTTP_2)
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("welian", "welian".toCharArray());
                    }
                }).build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://192.168.1.253:10000/dev/account"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(request.headers());
        System.out.println(response.body());

        CompletableFuture<String> future =
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);
        System.out.println(future.get());

    }

}
