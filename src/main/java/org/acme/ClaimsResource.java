package org.acme;

import io.smallrye.mutiny.Multi;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/claim")
public class ClaimsResource {

    @Inject
    ClaimService claimService;

    @GET
    public List<Claim> hello() {
        return Claim.listAll();
    }

    @POST
    @Path("/{claimNumber}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String questionClaim(@PathParam("claimNumber") String claimNumber, String query) {

        Claim claim = Claim.findClaimByNumber(claimNumber);
        ClaimBotQuery claimBotQuery = new ClaimBotQuery(claim.summary, query);

        return claimService.chat(claimBotQuery);
    }
}
