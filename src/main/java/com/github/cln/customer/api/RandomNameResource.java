package com.github.cln.customer.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.cln.customer.util.RandomNameGeneratorUtil;


@Path("/v1/random-names")
public class RandomNameResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getRandomName() {
        return List.of(RandomNameGeneratorUtil.generate());
    }
}
