package com.github.cln.customer.application.dto;

import java.util.StringJoiner;

public class NewCustomerRequest {
    public String name;

    @Override
    public String toString() {
        return new StringJoiner(", ", NewCustomerRequest.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
