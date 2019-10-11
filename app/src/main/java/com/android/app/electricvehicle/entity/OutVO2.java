package com.android.app.electricvehicle.entity;

public class OutVO2 {
    /**
     * ticket : e159d27042c7366f944aa23074217855
     * success : T
     * code : null
     * message : null
     * method : null
     * uri : null
     * timestamp : 1570544827542
     * data : {"access_token":"2X3b1ODjhpb65sb8PcoKD6Tu3bGhPMxjFw9bc7I7VjIOLybQUMWOM2XjPSBkWAXF","refresh_token":"wO9BszP4DRP7SqEA4jdP0t1mgIOpdqf5kBzU1N5wBD3uyJGuuHrNmp7cuUwt9Rqm","refresh_expires_in":604800,"expires_in":86400}
     * args : null
     * moreinfo : null
     * detail : null
     * subCode : null
     * subMessage : null
     */

    private String ticket;
    private String success;
    private String code;
    private String message;
    private String method;
    private String uri;
    private long timestamp;
    private DataBean data;
    private String args;
    private String moreinfo;
    private String detail;
    private String subCode;
    private String subMessage;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getMoreinfo() {
        return moreinfo;
    }

    public void setMoreinfo(String moreinfo) {
        this.moreinfo = moreinfo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMessage() {
        return subMessage;
    }

    public void setSubMessage(String subMessage) {
        this.subMessage = subMessage;
    }

    public static class DataBean {
        /**
         * access_token : 2X3b1ODjhpb65sb8PcoKD6Tu3bGhPMxjFw9bc7I7VjIOLybQUMWOM2XjPSBkWAXF
         * refresh_token : wO9BszP4DRP7SqEA4jdP0t1mgIOpdqf5kBzU1N5wBD3uyJGuuHrNmp7cuUwt9Rqm
         * refresh_expires_in : 604800
         * expires_in : 86400
         */

        private String access_token;
        private String refresh_token;
        private int refresh_expires_in;
        private int expires_in;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public void setRefresh_token(String refresh_token) {
            this.refresh_token = refresh_token;
        }

        public int getRefresh_expires_in() {
            return refresh_expires_in;
        }

        public void setRefresh_expires_in(int refresh_expires_in) {
            this.refresh_expires_in = refresh_expires_in;
        }

        public int getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(int expires_in) {
            this.expires_in = expires_in;
        }
    }
}
