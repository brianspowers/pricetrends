package net.brianpowers.blsviewer.wsclient;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Request object that will be sent to the Bureau of Labor Statistics API.
 */
public class BlsDataRequest {

    private List<String> seriesid;
    private String registrationKey;

    /**
     * Ccreate a request object for a single series.
     *
     * @param seriesId
     * @param registrationKey
     */
    public BlsDataRequest(String seriesId, String registrationKey) {
        this.seriesid = Lists.newArrayList(seriesId);
        this.registrationKey = registrationKey;
    }

    public List<String> getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(List<String> seriesid) {
        this.seriesid = seriesid;
    }

    public String getRegistrationKey() {
        return registrationKey;
    }

    public void setRegistrationKey(String registrationKey) {
        this.registrationKey = registrationKey;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("seriesid", seriesid)
                .add("registrationKey", registrationKey)
                .toString();
    }
}
