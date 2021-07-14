package com.example.webfluxdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
