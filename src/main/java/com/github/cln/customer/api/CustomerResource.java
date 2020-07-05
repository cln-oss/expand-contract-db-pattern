package com.github.cln.customer.api;

import com.github.cln.customer.facade.CustomerFacade;
import com.github.cln.customer.facade.NewCustomerRequest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
