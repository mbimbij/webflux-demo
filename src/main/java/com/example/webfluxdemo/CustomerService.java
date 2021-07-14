package com.example.webfluxdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@Slf4j
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public List<CustomerDto> getCustomers() {
        long start = System.currentTimeMillis();
        List<CustomerDto> customers = customerDao.getCustomers();
        long end = System.currentTimeMillis();
        log.info("Total execution time: {} ms", (end-start));
        return customers;
    }

    public Flux<CustomerDto> getCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<CustomerDto> customers = customerDao.getCustomersStream();
        long end = System.currentTimeMillis();
        log.info("Total execution time: {} ms", (end-start));
        return customers;
    }
}
