package net.brianpowers.blsviewer.wsclient;

import net.brianpowers.blsviewer.model.Series;
import org.springframework.stereotype.Service;

/**
 * Service to return data from the Bureau of Labor Statistics Average Price Data public API.
 */
@Service
public interface BlsDataServiceClient {

    /**
     * Retrieves a data-set from the US Bureau of Labor Statistics database.
     *
     * @param series
     * @return
     */
    Series getBlsData(String series);
}
