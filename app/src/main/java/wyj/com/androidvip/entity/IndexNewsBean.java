package wyj.com.androidvip.entity;

import java.util.List;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/18 11:27
 */

public class IndexNewsBean {

    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * news_title : 晚清时真正的武林高手在这儿？
         * news_link : https://blog.csdn.net/wyljk/article/details/84103066
         * news_image : https://inews.gtimg.com/newsapp_bt/0/6339193795/641
         * news_desc : 起晚清时的武林高手，很多人可能会想到十大高手，什么黄飞鸿、霍元甲、燕子李三之类的。但是这些人中很多都是被影视界无限放大的。那么晚清时的真正武林高手那个才称得上这个头衔
         * news_author : wyljk
         * news_pic : https://avatar.csdn.net/A/9/5/3_wyljk.jpg
         * news_time : 2018-12-12 10:59:10
         * news_type : 2
         */

        private String news_title;
        private String news_link;
        private String news_image;
        private String news_desc;
        private String news_author;
        private String news_pic;
        private String news_time;
        private String news_type;

        public String getNews_title() {
            return news_title;
        }

        public void setNews_title(String news_title) {
            this.news_title = news_title;
        }

        public String getNews_link() {
            return news_link;
        }

        public void setNews_link(String news_link) {
            this.news_link = news_link;
        }

        public String getNews_image() {
            return news_image;
        }

        public void setNews_image(String news_image) {
            this.news_image = news_image;
        }

        public String getNews_desc() {
            return news_desc;
        }

        public void setNews_desc(String news_desc) {
            this.news_desc = news_desc;
        }

        public String getNews_author() {
            return news_author;
        }

        public void setNews_author(String news_author) {
            this.news_author = news_author;
        }

        public String getNews_pic() {
            return news_pic;
        }

        public void setNews_pic(String news_pic) {
            this.news_pic = news_pic;
        }

        public String getNews_time() {
            return news_time;
        }

        public void setNews_time(String news_time) {
            this.news_time = news_time;
        }

        public String getNews_type() {
            return news_type;
        }

        public void setNews_type(String news_type) {
            this.news_type = news_type;
        }
    }
}
