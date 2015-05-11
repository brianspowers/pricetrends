package net.brianpowers.blsviewer.api;

/**
 * Created by bpowers on 5/11/15.
 */
public enum BlsRequestType {
    AVERAGE_PRICE("average_price"),
    CONSUMER_PRICE_INDEX_AVG("cpi_avg");

    private final String name;

    BlsRequestType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static BlsRequestType fromString(String name) {
        if (name != null) {
            for (BlsRequestType blsRequestType : BlsRequestType.values()) {
                if (blsRequestType.name.equalsIgnoreCase(name)) {
                    return blsRequestType;
                }
            }
        }
        return null;
    }
}
