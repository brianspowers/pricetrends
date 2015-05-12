package net.brianpowers.blsviewer.api;

import com.google.common.base.Strings;
import net.brianpowers.blsviewer.model.Series;
import net.brianpowers.blsviewer.wsclient.BlsDataServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Service endpoint that will request data from the U.S. Bureau of Labor & Statistics public API for a specific series
 * and return.  Series data will be cached for 24 hours to try to keep us under the BLS daily request limit.
 */
@Component
@Path("/blsdata")
public class BlsDataResource {

    @Autowired
    private BlsDataServiceClient blsDataServiceClient;

    @Path("average_price/{areaItemCode}")
    @GET
    @Produces("application/json")
    public Series areaCodes(@PathParam("areaItemCode") String seriesCode) {
        if (Strings.isNullOrEmpty(seriesCode)) {
            throw new WebApplicationException("Invalid Area or Item code received.", Response.Status.BAD_REQUEST);
        }

        Series blsData = blsDataServiceClient.getBlsData(seriesCode);
        if (blsData != null) {
            return blsData;
        } else {
            throw new WebApplicationException("Error retrieving data.", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
