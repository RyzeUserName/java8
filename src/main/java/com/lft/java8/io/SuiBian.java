package com.lft.java8.io;

import java.io.Serializable;
import java.util.List;

/**
 * 描述
 * @author Ryze
 * @date 2019-11-28 11:12
 */
public class SuiBian implements Serializable {
    private int index;
    //类别 v1.2
    private String name;
    private String desc;
    private int add_time;
    private int up_time;
    private List<ListBean> list;
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAdd_time() {
        return add_time;
    }

    public void setAdd_time(int add_time) {
        this.add_time = add_time;
    }

    public int getUp_time() {
        return up_time;
    }

    public void setUp_time(int up_time) {
        this.up_time = up_time;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {

        private QueryPathBean query_path;
        private int edit_uid;
        private String status;
        private String type;
        private boolean req_body_is_json_schema;
        private boolean res_body_is_json_schema;
        private boolean api_opened;
        private int index;
        private int _id;
        private String method;
        //名称
        private String title;
        private String desc;
        //路径
        private String path;
        private String req_body_type;
        private String res_body_type;
        private String res_body;
        private int project_id;
        private int catid;
        private int uid;
        private int add_time;
        private int up_time;
        private int __v;
        private List<?> tag;
        private List<ReqParamsBean> req_params;
        private List<?> req_body_form;
        private List<ReqHeadersBean> req_headers;
        private List<?> req_query;

        public QueryPathBean getQuery_path() {
            return query_path;
        }

        public void setQuery_path(QueryPathBean query_path) {
            this.query_path = query_path;
        }

        public int getEdit_uid() {
            return edit_uid;
        }

        public void setEdit_uid(int edit_uid) {
            this.edit_uid = edit_uid;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isReq_body_is_json_schema() {
            return req_body_is_json_schema;
        }

        public void setReq_body_is_json_schema(boolean req_body_is_json_schema) {
            this.req_body_is_json_schema = req_body_is_json_schema;
        }

        public boolean isRes_body_is_json_schema() {
            return res_body_is_json_schema;
        }

        public void setRes_body_is_json_schema(boolean res_body_is_json_schema) {
            this.res_body_is_json_schema = res_body_is_json_schema;
        }

        public boolean isApi_opened() {
            return api_opened;
        }

        public void setApi_opened(boolean api_opened) {
            this.api_opened = api_opened;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int get_id() {
            return _id;
        }

        public void set_id(int _id) {
            this._id = _id;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getReq_body_type() {
            return req_body_type;
        }

        public void setReq_body_type(String req_body_type) {
            this.req_body_type = req_body_type;
        }

        public String getRes_body_type() {
            return res_body_type;
        }

        public void setRes_body_type(String res_body_type) {
            this.res_body_type = res_body_type;
        }

        public String getRes_body() {
            return res_body;
        }

        public void setRes_body(String res_body) {
            this.res_body = res_body;
        }

        public int getProject_id() {
            return project_id;
        }

        public void setProject_id(int project_id) {
            this.project_id = project_id;
        }

        public int getCatid() {
            return catid;
        }

        public void setCatid(int catid) {
            this.catid = catid;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
        }

        public int getUp_time() {
            return up_time;
        }

        public void setUp_time(int up_time) {
            this.up_time = up_time;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public List<?> getTag() {
            return tag;
        }

        public void setTag(List<?> tag) {
            this.tag = tag;
        }

        public List<ReqParamsBean> getReq_params() {
            return req_params;
        }

        public void setReq_params(List<ReqParamsBean> req_params) {
            this.req_params = req_params;
        }

        public List<?> getReq_body_form() {
            return req_body_form;
        }

        public void setReq_body_form(List<?> req_body_form) {
            this.req_body_form = req_body_form;
        }

        public List<ReqHeadersBean> getReq_headers() {
            return req_headers;
        }

        public void setReq_headers(List<ReqHeadersBean> req_headers) {
            this.req_headers = req_headers;
        }

        public List<?> getReq_query() {
            return req_query;
        }

        public void setReq_query(List<?> req_query) {
            this.req_query = req_query;
        }

        public static class QueryPathBean {

            private String path;
            private List<?> params;

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public List<?> getParams() {
                return params;
            }

            public void setParams(List<?> params) {
                this.params = params;
            }
        }

        public static class ReqParamsBean {

            private String _id;
            private String name;
            private String type;
            private String desc;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

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

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }

        public static class ReqHeadersBean {

            private String required;
            private String _id;
            private String name;
            private String value;

            public String getRequired() {
                return required;
            }

            public void setRequired(String required) {
                this.required = required;
            }

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
