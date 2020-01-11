package com.lft.java8.youdao;

import java.util.List;

/**
 * 描述
 * @author Ryze
 * @date 2019-12-31 19:42
 */
public class A {
    /**
     * tSpeakUrl : http://openapi.youdao.com/ttsapi?q=The+text+to+be+entered&langType=en&sign=C6B1F488F7440F24CA12351653C0216C&salt=1577792549718&voice=4&format=mp3&appKey=038ff96c5b4aec4c
     * query : 待输入的文字
     * translation : ["The text to be entered"]
     * errorCode : 0
     * dict : {"url":"yddict://m.youdao.com/dict?le=eng&q=%E5%BE%85%E8%BE%93%E5%85%A5%E7%9A%84%E6%96%87%E5%AD%97"}
     * webdict : {"url":"http://m.youdao.com/dict?le=eng&q=%E5%BE%85%E8%BE%93%E5%85%A5%E7%9A%84%E6%96%87%E5%AD%97"}
     * l : zh-CHS2en
     * speakUrl : http://openapi.youdao.com/ttsapi?q=%E5%BE%85%E8%BE%93%E5%85%A5%E7%9A%84%E6%96%87%E5%AD%97&langType=zh-CHS&sign=C402CFEE685891220612FD45AB5894A0&salt=1577792549718&voice=4&format=mp3&appKey=038ff96c5b4aec4c
     */

    private String tSpeakUrl;
    private String query;
    private String errorCode;
    private DictBean dict;
    private WebdictBean webdict;
    private String l;
    private String speakUrl;
    private List<String> translation;

    public String getTSpeakUrl() {
        return tSpeakUrl;
    }

    public void setTSpeakUrl(String tSpeakUrl) {
        this.tSpeakUrl = tSpeakUrl;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public DictBean getDict() {
        return dict;
    }

    public void setDict(DictBean dict) {
        this.dict = dict;
    }

    public WebdictBean getWebdict() {
        return webdict;
    }

    public void setWebdict(WebdictBean webdict) {
        this.webdict = webdict;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getSpeakUrl() {
        return speakUrl;
    }

    public void setSpeakUrl(String speakUrl) {
        this.speakUrl = speakUrl;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public static class DictBean {
        /**
         * url : yddict://m.youdao.com/dict?le=eng&q=%E5%BE%85%E8%BE%93%E5%85%A5%E7%9A%84%E6%96%87%E5%AD%97
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class WebdictBean {
        /**
         * url : http://m.youdao.com/dict?le=eng&q=%E5%BE%85%E8%BE%93%E5%85%A5%E7%9A%84%E6%96%87%E5%AD%97
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
