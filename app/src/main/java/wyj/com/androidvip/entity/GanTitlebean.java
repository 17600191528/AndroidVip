package wyj.com.androidvip.entity;

import java.util.List;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/18 15:07
 */

public class GanTitlebean {

    private List<TitlesBean> titles;

    public List<TitlesBean> getTitles() {
        return titles;
    }

    public void setTitles(List<TitlesBean> titles) {
        this.titles = titles;
    }

    public static class TitlesBean {
        /**
         * name : 浼樿川鏂囩珷
         * id : 1
         */

        private String name;
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
