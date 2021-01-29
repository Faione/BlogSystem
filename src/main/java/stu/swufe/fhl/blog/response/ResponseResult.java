package stu.swufe.fhl.blog.response;

public class ResponseResult {
    private ResponseState responseState;
    private Object data;

    public ResponseResult(ResponseState responseState, Object data){
        this.responseState=responseState;
        this.data=data;
    }

    public static ResponseResult Success(Object data){
        return new ResponseResult(ResponseState.SUCCESS, data);
    }

    public static ResponseResult Success(){
        return new ResponseResult(ResponseState.SUCCESS, null);
    }


    public ResponseState getResponseState() {
        return responseState;
    }

    public void setResponseState(ResponseState responseState) {
        this.responseState = responseState;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
