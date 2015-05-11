package net.brianpowers.blsviewer.wsclient;

import net.brianpowers.blsviewer.model.BlsDataResponse;
import net.brianpowers.blsviewer.model.Series;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Web service client for the Bureau of Labor Statistics Average Price Data public API.
 *
 * This implementation utilizes the Spring RestTemplate client and Jackson to convert the response to JSON.
 *
 */
@Service
public class BlsDataServiceClientImpl implements BlsDataServiceClient {

    public static final Logger logger = LoggerFactory.getLogger(BlsDataServiceClientImpl.class);

    @Override
    public Series getBlsData(String series) {
        Series resultSeries = null;
        RestTemplate restTemplate = new RestTemplate();
        BlsDataResponse response = null;
        try {
            response = restTemplate.getForObject("http://api.bls.gov/publicAPI/v2/timeseries/data/{id}", BlsDataResponse.class, series);
        } catch (RestClientException e) {
            logger.error("Error accessing BLS web service for key: {}.", series, e);
        }

        if (response != null) {
            logger.info(response.toString());
            if ("REQUEST_SUCCEEDED".equals(response.getStatus()) && response.getSeries() != null && response.getSeries().size() == 1) {
                resultSeries = response.getSeries().get(0);
            } else {
                logger.warn("Error accessing BLS web service for key: {}.  Response was: {}", series, response.getStatus());
            }
        } else {
            logger.warn("Error accessing BLS web service for key: {}.  Response was null.", series);
        }
        return resultSeries;
    }
}
