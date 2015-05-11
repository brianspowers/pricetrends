package net.brianpowers.blsviewer.api;

import net.brianpowers.blsviewer.service.BlsCodesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Service endpoint providing a list of valid Area and Item codes for use in requesting data from the Bureau of Labor
 * and Statistics database.
 */
@Component
@Path("/codes")
public class CodesResource {

    @Autowired
    private BlsCodesDao blsCodesDao;

    @Path("area")
    @GET
    @Produces("application/json")
    public Map<String, String> areaCodes(@QueryParam("request") String requestType) {
        BlsRequestType blsRequestType = BlsRequestType.fromString(requestType);
        try {
            return blsCodesDao.getAreaCodes(blsRequestType);
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException("Bad or unsupported request_type", Response.Status.BAD_REQUEST);
        }
    }

    @Path("item")
    @GET
    @Produces("application/json")
    public Map<String, String> itemCodes(@QueryParam("request") String requestType) {
        BlsRequestType blsRequestType = BlsRequestType.fromString(requestType);
        try {
            return blsCodesDao.getItemCodes(blsRequestType);
        } catch (IllegalArgumentException e) {
            throw new WebApplicationException("Bad or unsupported request_type", Response.Status.BAD_REQUEST);
        }
    }

}
