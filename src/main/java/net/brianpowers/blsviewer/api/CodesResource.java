package net.brianpowers.blsviewer.api;

import net.brianpowers.blsviewer.model.AreaItemCode;
import net.brianpowers.blsviewer.service.BlsCodesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
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

    @Path("areas")
    @GET
    @Produces("application/json")
    public List<AreaItemCode> areaCodes() {
        return blsCodesDao.getAreaCodes(BlsRequestType.AVERAGE_PRICE);
    }

    @Path("items")
    @GET
    @Produces("application/json")
    public List<AreaItemCode> itemCodes() {
        return blsCodesDao.getItemCodes(BlsRequestType.AVERAGE_PRICE);
    }

}
