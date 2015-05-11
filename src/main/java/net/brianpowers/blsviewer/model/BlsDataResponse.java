package net.brianpowers.blsviewer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.List;

/**
 * Top-level response object for JSON retrieved from the BLS web service.
 */
public class BlsDataResponse {

    private String status;
    private long responseTime;
    private List<String> message;

    @JsonProperty("Results")
    private ResultContainer results;

    public String getStatus() {
        return status;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public List<String> getMessage() {
        return message;
    }

    @JsonIgnore
    public List<Series> getSeries() {
        return results.series;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("status", status)
                .add("responseTime", responseTime)
                .add("message", message)
                .add("results", results)
                .toString();
    }

    /**
     * Container for one or many Series of data.
     */
    public static class ResultContainer {
        private List<Series> series;

        public List<Series> getSeries() {
            return series;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("series", series)
                    .toString();
        }
    }
}
