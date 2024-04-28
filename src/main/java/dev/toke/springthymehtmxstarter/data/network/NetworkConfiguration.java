package dev.toke.springthymehtmxstarter.data.network;

import dev.toke.springthymehtmxstarter.data.api.ProductApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class NetworkConfiguration {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://fakestoreapi.com/")
                .build();
    }

    @Bean
    public WebClientAdapter webClientAdapter(WebClient webClient) {
        return WebClientAdapter.create(webClient);
    }

    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory(WebClientAdapter webClientAdapter) {
        return HttpServiceProxyFactory
                .builderFor(webClientAdapter)
                .build();
    }

    @Bean
    public ProductApi productApi(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(ProductApi.class);
    }
}
