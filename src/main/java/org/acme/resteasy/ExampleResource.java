package org.acme.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;
import java.util.concurrent.CompletionStage;

@Path("/resteasy/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "bonjour";
    }

    @GET
    @Path("/async")
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> helloAsync() {
         return ReactiveStreams.of("h", "e", "l", "l", "o")
         .map(s -> s.toUpperCase())
         .toList().run().thenApply(l -> l.toString());
     }
 
}