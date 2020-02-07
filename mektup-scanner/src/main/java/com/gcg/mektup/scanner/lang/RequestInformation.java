package com.gcg.mektup.scanner.lang;

public class RequestInformation {

    private String[] path;
    private String[] requestMethod;

    public RequestInformation(){}

    public RequestInformation(String[] path, String[] requestMethod){
        this.path = path;
        this.requestMethod = requestMethod;
    }

    public String getPath() {
        return path[0] == null ? "" : path[0];
    }

    public String getRequestMethod() {
        if (requestMethod.length != 0)
            return requestMethod[0];

        return "POST";
    }

    public String getHttpMethod(){
        return requestMethod[0];
    }

}
