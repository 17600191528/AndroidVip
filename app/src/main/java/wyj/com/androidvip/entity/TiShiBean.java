package wyj.com.androidvip.entity;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/18 10:31
 */

public class TiShiBean {

    @Override
    public String toString() {
        return "TiShiBean{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    /**
     * status : 0
     * message : 注册成功
     */

    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
