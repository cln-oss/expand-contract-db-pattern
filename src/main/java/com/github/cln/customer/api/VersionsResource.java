package com.github.cln.customer.api;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/v1/versions")
public class VersionsResource {

    @ConfigProperty(name = "quarkus.container-image.tag")
    String version;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getCurrentVersion() {
        return Map.of("applicationVersion", this.version);
    }
}
