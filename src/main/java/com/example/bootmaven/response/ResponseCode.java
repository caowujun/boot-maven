package com.example.bootmaven.response;


public enum ResponseCode implements IErrorCode {
    FAILED(-1L, "操作失败"),
    SUCCESS(0L, "执行成功");
//    PARAMATERNOTALLOWED(401, "参数不被允许");

    private final long code;
    private final String msg;

    private ResponseCode(final long code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseCode fromCode(long code) {
        ResponseCode[] ecs = values();
        ResponseCode[] var3 = ecs;
        int var4 = ecs.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            ResponseCode ec = var3[var5];
            if (ec.getCode() == code) {
                return ec;
            }
        }

        return SUCCESS;
    }

    public long getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String toString() {
        return String.format(" ResponseCode:{code=%s, msg=%s} ", this.code, this.msg);
    }
}
