package com.example.webfluxdemo;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    @SneakyThrows
    private void sleepExecution(int cpt){
        Thread.sleep(1000);
    }

    List<CustomerDto> getCustomers() {
        return IntStream.rangeClosed(1, 10)
                .peek(i -> System.out.println("processing count: " + i))
                .peek(this::sleepExecution)
                .mapToObj(i -> new CustomerDto(i, "customer-" + i))
                .collect(Collectors.toList());
    }
}
