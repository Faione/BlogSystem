package stu.swufe.fhl.blog.response;

public enum ResponseState {
    SUCCESS(true, 20000, "操作成功"),
    FALIED(false, 40000, "操作失败");

    ResponseState(boolean success, int code, String message){
        this.success=success;
        this.code=code;
        this.message=message;
    }

    private int code;
    private String message;
    private boolean success;

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
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


}
