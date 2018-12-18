package wyj.com.androidvip.entity;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/18 13:41
 */

public class IndexTabBean {
    private int img;
    private String tab;
    private int type;

    @Override
    public String toString() {
        return "IndexTabBean{" +
                "img=" + img +
                ", tab='" + tab + '\'' +
                ", type=" + type +
                '}';
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public IndexTabBean(int img, String tab, int type) {

        this.img = img;
        this.tab = tab;
        this.type = type;
    }
}
