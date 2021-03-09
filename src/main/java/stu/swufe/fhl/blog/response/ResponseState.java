package stu.swufe.fhl.blog.response;

public enum ResponseState {
    SUCCESS(true,20000, "操作成功"),
    REGISTER_SUCCESS(true,20001, "注册成功"),
    LOGIN_SUCCESS(true,20002, "登录成功"),
    FALIED(false,40000, "操作失败")
    ;

    ResponseState(boolean isSuccess, int code, String message){
        this.isSuccess=isSuccess;
        this.code = code;
        this.message = message;

    }

    public static ResponseState createFail(String msg){
        ResponseState responseState = ResponseState.FALIED;
        responseState.setMessage(msg);

        return responseState;

    }


    private int code;
    private String message;
    private boolean isSuccess;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
