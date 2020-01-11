package com.lft.java8.gaode;

/**
 * 描述
 * @author Ryze
 * @date 2020-01-09 15:50
 */
public class LocationResultDTO {
    /**
     * status : 1
     * info : ok
     * infocode : 10000
     * locations : 116.27561577691,40.067381727431
     */

    private String status;
    private String info;
    private String infocode;
    private String locations;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }
}
