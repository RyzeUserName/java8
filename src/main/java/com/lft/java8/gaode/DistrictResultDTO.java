package com.lft.java8.gaode;

import java.util.List;

/**
 * 行政区查询结果
 * 参考文档 https://lbs.amap.com/api/webservice/guide/api/georegeo/
 * @author Ryze
 * @date 2019-12-27 14:02:28
 * @version V1.0.0
 */
public class DistrictResultDTO {

    /**
     * status : 1
     * info : OK
     * infocode : 10000
     * regeocodes : [{"formatted_address":"北京市海淀区西北旺镇唐家岭新城T08小区","addressComponent":{"country":"中国","province":"北京市","city":[],"citycode":"010","district":"海淀区","adcode":"110108","township":"西北旺镇","towncode":"110108028000","neighborhood":{"name":"唐家岭新城","type":"商务住宅;住宅区;住宅小区"},"building":{"name":[],"type":[]},"streetNumber":{"street":"邓庄南路","number":"13号","location":"116.278389,40.0661711","direction":"东南","distance":"269.455"},"businessAreas":[{"location":"116.256057,40.054273","name":"西北旺","id":"110108"}]}},{"formatted_address":"北京市海淀区西北旺镇唐家岭新城T08小区","addressComponent":{"country":"中国","province":"北京市","city":[],"citycode":"010","district":"海淀区","adcode":"110108","township":"西北旺镇","towncode":"110108028000","neighborhood":{"name":"唐家岭新城","type":"商务住宅;住宅区;住宅小区"},"building":{"name":[],"type":[]},"streetNumber":{"street":"邓庄南路","number":"13号","location":"116.278389,40.0661711","direction":"东南","distance":"269.455"},"businessAreas":[{"location":"116.256057,40.054273","name":"西北旺","id":"110108"}]}}]
     */

    private String status;
    private String info;
    private String infocode;
    private List<RegeocodesBean> regeocodes;

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

    public List<RegeocodesBean> getRegeocodes() {
        return regeocodes;
    }

    public void setRegeocodes(List<RegeocodesBean> regeocodes) {
        this.regeocodes = regeocodes;
    }

    public static class RegeocodesBean {
        /**
         * formatted_address : 北京市海淀区西北旺镇唐家岭新城T08小区
         * addressComponent : {"country":"中国","province":"北京市","city":[],"citycode":"010","district":"海淀区","adcode":"110108","township":"西北旺镇","towncode":"110108028000","neighborhood":{"name":"唐家岭新城","type":"商务住宅;住宅区;住宅小区"},"building":{"name":[],"type":[]},"streetNumber":{"street":"邓庄南路","number":"13号","location":"116.278389,40.0661711","direction":"东南","distance":"269.455"},"businessAreas":[{"location":"116.256057,40.054273","name":"西北旺","id":"110108"}]}
         */

        private String formatted_address;
        private AddressComponentBean addressComponent;

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public AddressComponentBean getAddressComponent() {
            return addressComponent;
        }

        public void setAddressComponent(AddressComponentBean addressComponent) {
            this.addressComponent = addressComponent;
        }

        public static class AddressComponentBean {
            /**
             * country : 中国
             * province : 北京市
             * city : []
             * citycode : 010
             * district : 海淀区
             * adcode : 110108
             * township : 西北旺镇
             * towncode : 110108028000
             * neighborhood : {"name":"唐家岭新城","type":"商务住宅;住宅区;住宅小区"}
             * building : {"name":[],"type":[]}
             * streetNumber : {"street":"邓庄南路","number":"13号","location":"116.278389,40.0661711","direction":"东南","distance":"269.455"}
             * businessAreas : [{"location":"116.256057,40.054273","name":"西北旺","id":"110108"}]
             */

            private String country;
            private String province;
            private String citycode;
            private String district;
            private String adcode;
            private String township;
            private String towncode;
            private NeighborhoodBean neighborhood;
            private BuildingBean building;
            private StreetNumberBean streetNumber;
            private List<?> city;
            private List<BusinessAreasBean> businessAreas;

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCitycode() {
                return citycode;
            }

            public void setCitycode(String citycode) {
                this.citycode = citycode;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getAdcode() {
                return adcode;
            }

            public void setAdcode(String adcode) {
                this.adcode = adcode;
            }

            public String getTownship() {
                return township;
            }

            public void setTownship(String township) {
                this.township = township;
            }

            public String getTowncode() {
                return towncode;
            }

            public void setTowncode(String towncode) {
                this.towncode = towncode;
            }

            public NeighborhoodBean getNeighborhood() {
                return neighborhood;
            }

            public void setNeighborhood(NeighborhoodBean neighborhood) {
                this.neighborhood = neighborhood;
            }

            public BuildingBean getBuilding() {
                return building;
            }

            public void setBuilding(BuildingBean building) {
                this.building = building;
            }

            public StreetNumberBean getStreetNumber() {
                return streetNumber;
            }

            public void setStreetNumber(StreetNumberBean streetNumber) {
                this.streetNumber = streetNumber;
            }

            public List<?> getCity() {
                return city;
            }

            public void setCity(List<?> city) {
                this.city = city;
            }

            public List<BusinessAreasBean> getBusinessAreas() {
                return businessAreas;
            }

            public void setBusinessAreas(List<BusinessAreasBean> businessAreas) {
                this.businessAreas = businessAreas;
            }

            public static class NeighborhoodBean {
                /**
                 * name : 唐家岭新城
                 * type : 商务住宅;住宅区;住宅小区
                 */

                private String name;
                private String type;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }
            }

            public static class BuildingBean {
                private List<?> name;
                private List<?> type;

                public List<?> getName() {
                    return name;
                }

                public void setName(List<?> name) {
                    this.name = name;
                }

                public List<?> getType() {
                    return type;
                }

                public void setType(List<?> type) {
                    this.type = type;
                }
            }

            public static class StreetNumberBean {
                /**
                 * street : 邓庄南路
                 * number : 13号
                 * location : 116.278389,40.0661711
                 * direction : 东南
                 * distance : 269.455
                 */

                private String street;
                private String number;
                private String location;
                private String direction;
                private String distance;

                public String getStreet() {
                    return street;
                }

                public void setStreet(String street) {
                    this.street = street;
                }

                public String getNumber() {
                    return number;
                }

                public void setNumber(String number) {
                    this.number = number;
                }

                public String getLocation() {
                    return location;
                }

                public void setLocation(String location) {
                    this.location = location;
                }

                public String getDirection() {
                    return direction;
                }

                public void setDirection(String direction) {
                    this.direction = direction;
                }

                public String getDistance() {
                    return distance;
                }

                public void setDistance(String distance) {
                    this.distance = distance;
                }
            }

            public static class BusinessAreasBean {
                /**
                 * location : 116.256057,40.054273
                 * name : 西北旺
                 * id : 110108
                 */

                private String location;
                private String name;
                private String id;

                public String getLocation() {
                    return location;
                }

                public void setLocation(String location) {
                    this.location = location;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }
        }
    }
}
