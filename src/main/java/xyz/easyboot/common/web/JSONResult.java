package xyz.easyboot.common.web;

import xyz.easyboot.common.Constants;

import java.io.Serializable;

/**
 * 接口返回数据格式
 *
 * @author wujiawei
 * @email jeecgos@163.com
 * @date 2019年1月19日
 */
public class JSONResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success = true;

    /**
     * 返回处理消息
     */
    private String message = "操作成功！";

    /**
     * 返回代码
     */
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    private T JSONResult;

    public T getJSONResult() {
        return this.JSONResult;
    }

    public void setJSONResult(T t) {
        this.JSONResult = t;
    }

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public JSONResult() {

    }

    public JSONResult<T> success(String message) {
        this.message = message;
        this.code = Constants.RESULT_OK_CODE;
        this.success = true;
        return this;
    }

    public static JSONResult<Object> ok() {
        JSONResult<Object> r = new JSONResult<Object>();
        r.setSuccess(true);
        r.setCode(Constants.RESULT_OK_CODE);
        r.setMessage("成功");
        return r;
    }

    public static <T> JSONResult<T> ok(T data) {
        JSONResult<T> r = new JSONResult<T>();
        r.setSuccess(true);
        r.setCode(Constants.RESULT_OK_CODE);
        r.setJSONResult(data);
        return r;
    }

    public static JSONResult<Object> okWithMessage(String msg) {
        JSONResult<Object> r = new JSONResult<Object>();
        r.setSuccess(true);
        r.setCode(Constants.RESULT_OK_CODE);
        r.setMessage(msg);
        return r;
    }

    public static <T> JSONResult<T> okWithData(T data) {
        JSONResult<T> r = new JSONResult<T>();
        r.setSuccess(true);
        r.setCode(Constants.RESULT_OK_CODE);
        r.setJSONResult(data);
        return r;
    }

    public static JSONResult<Object> error(String msg) {
        return error(Constants.RESULT_ERROR_CODE, msg);
    }

    public static JSONResult<Object> error(int code, String msg) {
        JSONResult<Object> r = new JSONResult<Object>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public JSONResult<T> error500(String message) {
        this.message = message;
        this.code = Constants.RESULT_ERROR_CODE;
        this.success = false;
        return this;
    }

    /**
     * 无权限访问返回结果
     */
    public static JSONResult<Object> forbidden(String msg) {
        return error(Constants.RESULT_FORBIDDEN_CODE, msg);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}