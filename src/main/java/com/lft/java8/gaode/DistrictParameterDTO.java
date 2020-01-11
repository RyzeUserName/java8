package com.lft.java8.gaode;

/**
 * 行政区查询参数
 *  参考文档 https://lbs.amap.com/api/webservice/guide/api/georegeo/
 * @author Ryze
 * @date 2019-12-27 14:08
 */
public class DistrictParameterDTO {
    /**
     * 高德Key
     */
    private String key;
    /**
     * 传入内容规则：经度在前，纬度在后，经纬度间以“,”分割，
     * 经纬度小数点后不要超过 6 位。如果需要解析多个经纬度的话，
     * 请用"|"进行间隔，并且将 batch 参数设置为 true，最多支持传入 20 对坐标点。
     * 每对点坐标之间用"|"分割。
     */
    private String location;
    /**
     * 返回附近POI类型
     */
    private String poitype;
    private String radius;
    private String extensions;
    /**
     * 批量查询控制
     */
    private String batch;
    private String roadlevel;
    private String sig;
    private String output;
    private String callback;
    private String homeorcorp;

    public DistrictParameterDTO() {
    }

    public DistrictParameterDTO(DistrictParameterDTO districtParameterDTO) {
        this.key = districtParameterDTO.getKey();
        this.location = districtParameterDTO.getLocation();
        this.poitype = districtParameterDTO.getPoitype();
        this.radius = districtParameterDTO.getRadius();
        this.extensions = districtParameterDTO.getExtensions();
        this.batch = districtParameterDTO.getBatch();
        this.roadlevel = districtParameterDTO.getRoadlevel();
        this.sig = districtParameterDTO.getSig();
        this.output = districtParameterDTO.getOutput();
        this.callback = districtParameterDTO.getCallback();
        this.homeorcorp = districtParameterDTO.getHomeorcorp();
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPoitype() {
        return this.poitype;
    }

    public void setPoitype(String poitype) {
        this.poitype = poitype;
    }

    public String getRadius() {
        return this.radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getExtensions() {
        return this.extensions;
    }

    public void setExtensions(String extensions) {
        this.extensions = extensions;
    }

    public String getBatch() {
        return this.batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getRoadlevel() {
        return this.roadlevel;
    }

    public void setRoadlevel(String roadlevel) {
        this.roadlevel = roadlevel;
    }

    public String getSig() {
        return this.sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getOutput() {
        return this.output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getCallback() {
        return this.callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getHomeorcorp() {
        return this.homeorcorp;
    }

    public void setHomeorcorp(String homeorcorp) {
        this.homeorcorp = homeorcorp;
    }

    public static class DistrictParameterDTOBuilder {
        private DistrictParameterDTO districtParameterDTO;

        public DistrictParameterDTOBuilder() {
            this.districtParameterDTO = new DistrictParameterDTO();
        }

        public DistrictParameterDTOBuilder key(String key) {
            this.districtParameterDTO.setKey(key);
            return this;
        }

        public DistrictParameterDTOBuilder location(String location) {
            this.districtParameterDTO.setLocation(location);
            return this;
        }

        public DistrictParameterDTOBuilder poitype(String poitype) {
            this.districtParameterDTO.setPoitype(poitype);
            return this;
        }

        public DistrictParameterDTOBuilder radius(String radius) {
            this.districtParameterDTO.setRadius(radius);
            return this;
        }

        public DistrictParameterDTOBuilder extensions(String extensions) {
            this.districtParameterDTO.setExtensions(extensions);
            return this;
        }

        public DistrictParameterDTOBuilder batch(String batch) {
            this.districtParameterDTO.setBatch(batch);
            return this;
        }

        public DistrictParameterDTOBuilder roadlevel(String roadlevel) {
            this.districtParameterDTO.setRoadlevel(roadlevel);
            return this;
        }

        public DistrictParameterDTOBuilder sig(String sig) {
            this.districtParameterDTO.setSig(sig);
            return this;
        }

        public DistrictParameterDTOBuilder output(String output) {
            this.districtParameterDTO.setOutput(output);
            return this;
        }

        public DistrictParameterDTOBuilder callback(String callback) {
            this.districtParameterDTO.setCallback(callback);
            return this;
        }

        public DistrictParameterDTOBuilder homeorcorp(String homeorcorp) {
            this.districtParameterDTO.setHomeorcorp(homeorcorp);
            return this;
        }

        public DistrictParameterDTO build() {
            return new DistrictParameterDTO(this.districtParameterDTO);
        }
    }
}
