package net.brianpowers.blsviewer.wsclient;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import net.brianpowers.blsviewer.model.Series;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Proxy class that caches results for a specific BLS series.
 * We're limited to 500 requests per day to the public API.
 */
@Service
@Primary
public class BlsDataServiceClientCachingProxy implements BlsDataServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(BlsDataServiceClientCachingProxy.class);

    private final LoadingCache<String, Series> blsDataCache;
    private final BlsDataServiceClientImpl blsClient;

    @Autowired
    public BlsDataServiceClientCachingProxy(BlsDataServiceClientImpl blsClient) {
        this.blsClient = blsClient;
        this.blsDataCache = CacheBuilder.newBuilder()
                .maximumSize(500)
                .expireAfterWrite(24, TimeUnit.HOURS)
                .build(new CacheLoader<String, Series>() {
                    public Series load(String key) throws Exception {
                        Series blsData = blsClient.getBlsData(key);
                        if (blsData != null) {
                            return blsData;
                        } else {
                            throw new Exception("No Series data returned.");
                        }
                    }
                });
    }

    @Override
    public Series getBlsData(String series) {
        try {
            return blsDataCache.get(series);
        } catch (ExecutionException e) {
            logger.warn("BLS Data not received/cached for series {}", series);
            return null;
        }
    }
}
