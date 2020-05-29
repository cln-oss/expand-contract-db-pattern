package com.github.cln.customer.application.rest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.cln.customer.application.dto.NewCustomerRequest;
import com.github.cln.customer.application.facade.CustomerFacade;

@Path("/v1/customers")
public class CustomerResource {

    @Inject
    CustomerFacade facade;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(NewCustomerRequest request) {
        var created = this.facade.addCustomer(request);
        return Response.ok(created).status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        var customers = this.facade.getAllCustomers();
        return Response.ok(customers).build();
    }
}
