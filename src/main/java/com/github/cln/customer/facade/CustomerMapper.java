package com.github.cln.customer.facade;

import javax.enterprise.context.ApplicationScoped;

import com.github.cln.customer.repo.CustomerEntity;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerMapper {

    public CustomerEntity toCustomerEntity(NewCustomerRequest req) {
        var entity = new CustomerEntity();
        var nameSplitByWhitespace = req.name.split(" ");
        entity.firstName = nameSplitByWhitespace[0];
        entity.lastName = nameSplitByWhitespace[1];
        return entity;
    }

    public List<CustomerResponse> toResponses(List<CustomerEntity> customers) {
        return customers.stream()
                .map(this::toResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    public CustomerResponse toResponse(CustomerEntity entity) {
        var response = new CustomerResponse();
        response.id = entity.id;
        response.name = entity.firstName + " " + entity.lastName;
        return response;
    }
}
