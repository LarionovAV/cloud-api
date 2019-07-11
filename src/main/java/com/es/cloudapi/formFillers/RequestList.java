package com.es.cloudapi.formFillers;

import java.util.ArrayList;

public class RequestList {
    private ArrayList<TestRequest> reqList;

    static private RequestList instance = null;

    private RequestList() {
        reqList = new ArrayList<TestRequest>();
    }

    public ArrayList<TestRequest> getReqList() {
        return reqList;
    }

    public static RequestList getInstance() {
        if (instance == null)
            instance = new RequestList();
        return instance;
    }

}
