package com.zjx.island.biz.activiti.examples;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * 调用接口的请求model
 *
 * @author trevor.zhao
 * @date 2020/4/3
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY,property = "@class")
public class CallRequest {
    private String url;
    private String body;
    private boolean approved;
    private Headers headers;

    @JsonCreator
    public CallRequest(@JsonProperty("url") String url, @JsonProperty("body") String body, @JsonProperty("approved") boolean approved, @JsonProperty("headers") Headers headers) {
        this.url = url;
        this.body = body;
        this.approved = approved;
        this.headers = headers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "CallRequest{" +
            "url='" + url + '\'' +
            ", body='" + body + '\'' +
            ", approved=" + approved +
            ", headers=" + headers +
            '}';
    }
}
