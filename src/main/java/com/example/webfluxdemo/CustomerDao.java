package com.example.webfluxdemo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Slf4j
public class CustomerDao {

    @SneakyThrows
    private void sleepExecution(int cpt){
        Thread.sleep(1000);
    }

    List<CustomerDto> getCustomers() {
        return IntStream.rangeClosed(1, 10)
                .peek(this::sleepExecution)
                .peek(i -> log.info("processing count: {}", i))
                .mapToObj(i -> new CustomerDto(i, "customer-" + i))
                .collect(Collectors.toList());
    }

    Flux<CustomerDto> getCustomersStream() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> log.info("processing count in stream: {}", i))
                .map(i -> new CustomerDto(i, "customer-" + i));
    }
}
