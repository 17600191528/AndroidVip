package wyj.com.androidvip.entity;

import java.util.List;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/18 14:17
 */

public class StudyXrvBean {

    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * title : Kotlin瀛︿範涔嬭矾
         * image : http://www.abnerming.cn/txt/image/kotlin_1.jpg
         * isvip : true
         * code : 8826
         * money : 6
         * study_id : e
         * islist : 0
         */

        private String title;
        private String image;
        private boolean isvip;
        private String code;
        private String money;
        private String study_id;
        private int islist;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public boolean isIsvip() {
            return isvip;
        }

        public void setIsvip(boolean isvip) {
            this.isvip = isvip;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getStudy_id() {
            return study_id;
        }

        public void setStudy_id(String study_id) {
            this.study_id = study_id;
        }

        public int getIslist() {
            return islist;
        }

        public void setIslist(int islist) {
            this.islist = islist;
        }
    }
}
