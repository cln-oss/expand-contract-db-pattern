package com.github.cln.customer.facade;

import com.github.cln.customer.repo.CustomerEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CustomerFacade {

    @Inject
    CustomerMapper mapper;

    @Transactional
    public CustomerResponse addCustomer(NewCustomerRequest req) {
        var entity = this.mapper.toCustomerEntity(req);
        entity.persist();
        return this.mapper.toResponse(entity);
    }

    public List<CustomerResponse> getAllCustomers() {
        List<CustomerEntity> entities = CustomerEntity.listAll();
        return this.mapper.toResponses(entities);
    }
}
