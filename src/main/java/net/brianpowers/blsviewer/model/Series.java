package net.brianpowers.blsviewer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.List;

public class Series {

    @JsonProperty("seriesID")
    private String seriesId;
    private List<SeriesItem> data;

    public String getSeriesId() {
        return seriesId;
    }

    public List<SeriesItem> getData() {
        return data;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("seriesId", seriesId)
                .add("data", data)
                .toString();
    }
}
