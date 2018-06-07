package com.lik.robotcms.entity;

public class Result {

    /**提示的信息*/
    private String message;
    /**返回的数据*/
    private String data;
    /**如果为false是发生错误*/
    private boolean success;
    /**类型*/
    private Integer state;

    public Result(){}

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Result(String message, String data, boolean success, Integer state) {
        this.message = message;
        this.data = data;
        this.success = success;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", data='" + data + '\'' +
                ", success=" + success +
                ", state=" + state +
                '}';
    }
}
