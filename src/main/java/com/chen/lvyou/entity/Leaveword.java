package com.chen.lvyou.entity;

public class Leaveword {
    private Integer leaveWordId;

    private String title;

    private String leaveContent;

    private String addTime;

    private String userId;

    private String replyContent;

    private String replyTime;

    public Integer getLeaveWordId() {
        return leaveWordId;
    }

    public void setLeaveWordId(Integer leaveWordId) {
        this.leaveWordId = leaveWordId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLeaveContent() {
        return leaveContent;
    }

    public void setLeaveContent(String leaveContent) {
        this.leaveContent = leaveContent == null ? null : leaveContent.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime == null ? null : replyTime.trim();
    }
}