package net.brianpowers.blsviewer.model;

import com.google.common.base.MoreObjects;

import java.util.List;
import java.util.Map;

/**
 * Class representing a single data-point in a Series of BLS data.
 */
public class SeriesItem {

    private String year;
    private String period;
    private String periodName;
    private String value;
    private List<Map<String, String>> footnotes;

    public String getYear() {
        return year;
    }

    public String getPeriod() {
        return period;
    }

    public String getPeriodName() {
        return periodName;
    }

    public String getValue() {
        return value;
    }

    public List<Map<String, String>> getFootnotes() {
        return footnotes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("year", year)
                .add("period", period)
                .add("periodName", periodName)
                .add("value", value)
                .add("footnotes", footnotes)
                .toString();
    }
}
