package com.mainacad.model;

public class ConnectionInfo {

    private Integer sessionId;
    private String userIp;
    private Long connectionTime;//

    @Override
    public String toString() {
        return sessionId + " " + connectionTime + " " + userIp;
    }

    public ConnectionInfo(Integer sessionId, Long connectionTime, String userIp) {
        this.sessionId = sessionId;
        this.userIp = userIp;
        this.connectionTime = connectionTime;
    }

    public ConnectionInfo() {
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }
    public Long getConnectionTime() {
        return connectionTime;
    }

    public void setConnectionTime(Long connectionTime) {
        this.connectionTime = connectionTime;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }


}