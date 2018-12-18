package wyj.com.androidvip.entity;

import java.util.List;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/18 16:05
 */

public class LiveIndexBean {

    /**
     * image : https://code.aliyun.com/598254259/AndroidGuide/raw/master/txt/live/image/android_03.jpg
     * title : 互动直播开发入门
     * position : live_003
     * items : [{"image":"https://img4.mukewang.com/59e716e2000167dc06000338-240-135.jpg","title":"Android经典视频集锦","position":"live_002"},{"image":"https://img2.mukewang.com/593606e60001a6c206000338-240-135.jpg","title":"Android自定义","position":"live_009"},{"image":"https://code.aliyun.com/598254259/AndroidGuide/raw/master/txt/live/image/android_07.jpg","title":"Android开发从入门到精通","position":"live_010"},{"image":"https://img.mukewang.com/57919306000175bf06000356-240-135.jpg","title":"Android Studio工具讲解","position":"live_011"},{"image":"http://p.qpic.cn/smartcampus/0/673401521108076/0","title":"ReactNative基础与入门","position":"live_001"},{"image":"https://code.aliyun.com/598254259/AndroidGuide/raw/master/txt/live/image/android_06.png","title":"2048游戏开发","position":"live_004"},{"image":"https://code.aliyun.com/598254259/AndroidGuide/raw/master/txt/live/image/android_06.jpg","title":"Kotlin视频集锦","position":"live_005"},{"image":"https://code.aliyun.com/598254259/AndroidGuide/raw/master/txt/live/image/android_08.jpg","title":"数独游戏开发","position":"live_006"},{"image":"https://img3.mukewang.com/587c76150001a0ab06000338-240-135.jpg","title":"视频教程-Java语言","position":"live_007"},{"image":"https://code.aliyun.com/598254259/AndroidGuide/raw/master/txt/live/image/kotlin_01.jpg","title":"Kotlin基础学习","position":"live_008"},{"image":"https://szimg.mukewang.com/5909a1250001197e05400300-360-202.jpg","title":"APK瘦身实践","position":"live_012"},{"image":"https://img.mukewang.com/5833e62b0001c2ad06000338-240-135.jpg","title":"GreenDao数据库框架","position":"live_013"},{"image":"https://code.aliyun.com/598254259/AndroidGuide/raw/master/image/android_index_1.jpg","title":"Android基础视频全集","position":"live_014"},{"image":"https://code.aliyun.com/598254259/AndroidGuide/raw/master/txt/live/image/android_01.jpg","title":"Android实战（超级手电）","position":"live_015"},{"image":"https://img2.mukewang.com/5785deb30001002b06000338-240-135.jpg","title":"Android编码规范及代码风格","position":"live_016"},{"image":"https://code.aliyun.com/598254259/AndroidGuide/raw/master/txt/live/image/android_05.jpg","title":"Android之商务网开发","position":"live_017"},{"image":"https://code.aliyun.com/598254259/AndroidGuide/raw/master/image/android_index_0.jpg","title":"Android开发科课程","position":"live_018"}]
     */

    private String image;
    private String title;
    private String position;
    private List<ItemsBean> items;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * image : https://img4.mukewang.com/59e716e2000167dc06000338-240-135.jpg
         * title : Android经典视频集锦
         * position : live_002
         */

        private String image;
        private String title;
        private String position;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }
}
