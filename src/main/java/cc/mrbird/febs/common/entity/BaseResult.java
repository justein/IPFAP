package cc.mrbird.febs.common.entity;

/**
 * @author : Lyn
 * @version V1.0
 * @Project: IPFAP
 * @Package cc.mrbird.febs.common.entity
 * @Description: TODO
 * @date Date : 2020-02-13 下午 01:55
 * @copyright http://www.jhhg.net.cn/
 */
public class BaseResult {
    /**响应状态码*/
    private Integer code;
    /**响应信息*/
    private String msg;
    /**响应体*/
    private Object object;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
