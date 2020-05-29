package com.github.cln.customer.application.dto;

import javax.enterprise.context.ApplicationScoped;

import com.github.cln.customer.domain.model.Customer;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerMapper {

    public Customer toCustomer(NewCustomerRequest req) {
        return new Customer(0L, req.name);
    }

    public List<CustomerResponse> toResponses(List<Customer> customers) {
        return customers.stream()
                .map(this::toResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    public CustomerResponse toResponse(Customer customer) {
        var response = new CustomerResponse();
        response.id = customer.getId();
        response.name = customer.getName();
        return response;
    }
}
