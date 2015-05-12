package net.brianpowers.blsviewer.wsclient;

import com.google.common.base.Strings;
import net.brianpowers.blsviewer.model.BlsDataResponse;
import net.brianpowers.blsviewer.model.Series;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Web service client for the Bureau of Labor Statistics Average Price Data public API.
 * <p/>
 * This implementation utilizes the Spring RestTemplate client and Jackson to convert the response to JSON.
 */
@Service
public class BlsDataServiceClientImpl implements BlsDataServiceClient, InitializingBean {

    public static final Logger logger = LoggerFactory.getLogger(BlsDataServiceClientImpl.class);
    private final Environment env;

    @Autowired
    public BlsDataServiceClientImpl(Environment env) {
        this.env = env;
    }

    @Override
    public Series getBlsData(String series) {
        String apiKey = env.getProperty("apiKey");
        Series resultSeries = null;
        RestTemplate restTemplate = new RestTemplate();

        BlsDataRequest request = new BlsDataRequest(series, apiKey);
        BlsDataResponse response = null;
        try {
            response = restTemplate.postForObject("http://api.bls.gov/publicAPI/v2/timeseries/data/", request, BlsDataResponse.class);
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

    @Override
    public void afterPropertiesSet() throws Exception {
        String apiKey = env.getProperty("apiKey");
        if (Strings.isNullOrEmpty(apiKey)) {
            logger.warn("No BLS API key found so we are running in unauthenticated mode.  Drastically lower request limits will apply.");
        }
    }
}
