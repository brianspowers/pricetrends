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

    @JsonProperty("seriesData")
    public List<SeriesItem> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<SeriesItem> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("seriesId", seriesId)
                .add("data", data)
                .toString();
    }
}
