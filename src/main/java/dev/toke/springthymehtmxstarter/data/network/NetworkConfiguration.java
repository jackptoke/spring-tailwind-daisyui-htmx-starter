package dev.toke.springthymehtmxstarter.data.network;

import dev.toke.springthymehtmxstarter.data.api.MachineApi;
import dev.toke.springthymehtmxstarter.data.api.ProductApi;
import dev.toke.springthymehtmxstarter.data.api.WorkOrderApi;
import dev.toke.springthymehtmxstarter.data.api.WorkPlanApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class NetworkConfiguration {
    @Value("${amesystems.api.url}")
    private String BACKEND_URL;
    private final int BUFFER_SIZE = 16*1024*1024;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(BUFFER_SIZE))
                .baseUrl(BACKEND_URL)
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

    @Bean
    public WorkOrderApi workOrderApi(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(WorkOrderApi.class);
    }

    @Bean
    public WorkPlanApi workPlanApi(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(WorkPlanApi.class);
    }

    @Bean
    public MachineApi machineApi(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(MachineApi.class);
    }
}
