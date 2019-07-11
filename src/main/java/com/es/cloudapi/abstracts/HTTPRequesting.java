package com.es.cloudapi.abstracts;

import com.es.cloudapi.formFillers.RequestList;
import com.es.cloudapi.formFillers.TestRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HTTPRequesting {

    private static RequestList requests = RequestList.getInstance();
    public static void getHTTPRequestInfo(HttpServletRequest request,
                                   HttpServletResponse response){
        TestRequest test = new TestRequest();
        test.setUrl(request.getRequestURI());
        test.setMethod(request.getMethod());
        test.setHTTPResultCode(response.getStatus());
        test.setBody(request.getParameterMap().toString());
        requests.getReqList().add(test);
    }
}
