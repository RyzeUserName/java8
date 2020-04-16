package com.lft.java8.swagger;

import java.util.List;
import java.util.Map;

/**
 * 测试 swagger json
 * @author Ryze
 * @date 2020-04-08 13:50
 */
public class SwaggerJson {
    private String swagger;
    private Object info;
    private String basePath;
    private List<TagsBean> tags;
    private List<String> schemes;
    private Map<String, Map<String, InnerBean>> paths;

    public String getSwagger() {
        return swagger;
    }

    public void setSwagger(String swagger) {
        this.swagger = swagger;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<String> getSchemes() {
        return schemes;
    }

    public void setSchemes(List<String> schemes) {
        this.schemes = schemes;
    }

    public Map<String, Map<String, InnerBean>> getPaths() {
        return paths;
    }

    public void setPaths(Map<String, Map<String, InnerBean>> paths) {
        this.paths = paths;
    }
}
