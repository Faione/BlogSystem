package stu.swufe.fhl.blog.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult {
    private boolean isSuccess;
    private int code;
    private String token;
    private String msg;
    private Object data;

    public ResponseResult(ResponseState responseState, Object data){
        this.isSuccess = responseState.isSuccess();
        this.code = responseState.getCode();
        this.msg = responseState.getMessage();
        this.data = data;
    }

    public ResponseResult(ResponseState responseState){
        this.isSuccess = responseState.isSuccess();
        this.code = responseState.getCode();
        this.msg = responseState.getMessage();
    }

    /**
     * 操作成功
     * @return
     */
    public static ResponseResult createSuccess(){
        return new ResponseResult(ResponseState.SUCCESS);
    }

    // 返回成功描述
    public static ResponseResult createSuccess(String msg){
        return new ResponseResult(ResponseState.SUCCESS).setMsg(msg);
    }

    // 返回特定成功操作
    public static ResponseResult createSuccess(ResponseState responseState){
        return new ResponseResult(responseState);
    }

    // 仅返回数据，与操作成功的描述
    public static ResponseResult createSuccess(ResponseState responseState, Object data){
        return new ResponseResult(responseState, data);
    }


    /**
     * 操作失败
     * @return
     */
    public static ResponseResult creatFailed(){return new ResponseResult(ResponseState.FALIED); }

    // 返回错误信息
    public static ResponseResult creatFailed(String msg){
        return new ResponseResult(ResponseState.FALIED).setMsg(msg);
    }


    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getToken() {
        return token;
    }

    public ResponseResult setToken(String token) {
        this.token = token;
        return this;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
