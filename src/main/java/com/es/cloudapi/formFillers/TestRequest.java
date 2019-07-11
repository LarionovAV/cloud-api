package com.es.cloudapi.formFillers;

public class TestRequest {

    private String Url;
    private String Body;
    private String Method;
    private int HTTPResultCode;


    public TestRequest() {
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }

    public int getHTTPResultCode() {
        return HTTPResultCode;
    }

    public void setHTTPResultCode(int HTTPResultCode) {
        this.HTTPResultCode = HTTPResultCode;
    }
}
