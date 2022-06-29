package com.example.bootmaven.tools.response;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author robin
 * @date 2022年06月24日 12:03
 * @description
 */

public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private long code;
    private T data;
    private String msg;

    public R() {
    }

    public R(IErrorCode errorCode) {
        errorCode = (IErrorCode) Optional.ofNullable(errorCode).orElse(ResponseCode.FAILED);
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public static <T> R<T> ok(T data) {
        ResponseCode aec = ResponseCode.SUCCESS;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            aec = ResponseCode.FAILED;
        }

        return restResult(data, aec);
    }

    public static <T> R<T> failed(String msg) {
        return restResult(null, ResponseCode.FAILED.getCode(), msg);
    }

    public static <T> R<T> failed(IErrorCode errorCode) {
        return restResult(null, errorCode);
    }

    public static <T> R<T> restResult(T data, IErrorCode errorCode) {
        return restResult(data, errorCode.getCode(), errorCode.getMsg());
    }

    private static <T> R<T> restResult(T data, long code, String msg) {
        R<T> apiResult = new R<T>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public boolean ok() {
        return ResponseCode.SUCCESS.getCode() == this.code;
    }

    public T serviceData() throws Exception {
        if (!this.ok()) {
            throw new Exception(this.msg);
        } else {
            return this.data;
        }
    }

    public long getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public R<T> setCode(final long code) {
        this.code = code;
        return this;
    }

    public R<T> setData(final T data) {
        this.data = data;
        return this;
    }

    public R<T> setMsg(final String msg) {
        this.msg = msg;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof R)) {
            return false;
        } else {
            R<?> other = (R<?>) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    return other$msg == null;
                } else return this$msg.equals(other$msg);
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof R;
    }

    public int hashCode() {
//        int PRIME = true;
        int result = 1;
        long $code = this.getCode();
        result = result * 59 + (int) ($code >>> 32 ^ $code);
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        return result;
    }

    public String toString() {
        return "R(code=" + this.getCode() + ", data=" + this.getData() + ", msg=" + this.getMsg() + ")";
    }
}
