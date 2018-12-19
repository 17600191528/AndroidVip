package wyj.com.androidvip.entity;

import java.util.List;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/19 14:42
 */

public class LiveInfoBean {

    /**
     * title : Android Studio宸ュ叿璁茶В
     * video_url : b0318cpzggn
     * video_desc : 鍦ˋndroid Studio鍙戝竷涔嬪悗锛屾棤璁哄浗鍐呭锛岄兘鎺€璧蜂簡涓€鑲ndroid Studio PK Eclipse鐨勭儹娼紝浜轰滑浜夌浉鐑濡備綍鐪嬪緟Google I/O涓婃帹鍑虹殑Android Studio锛熻兘瀹屽叏鍙栦唬Eclipse鍚楋紵Android Studio鏄竴椤瑰叏鏂扮殑鍩轰簬IntelliJ IDEA鐨凙ndroid寮€鍙戠幆澧冦€傜被浼间簬Eclipse ADT鎻掍欢锛孉ndroid Studio鎻愪緵浜嗛泦鎴愮殑Android寮€鍙戝伐鍏风敤浜庡紑鍙戝拰璋冭瘯銆�
     * isList : false
     * video_list : [{"video_title":"1.Android Studio宸ュ叿璁茶В锛堢涓\u20ac闆嗭級","video_url":"b0318cpzggn","video_time":"","video_id":0},{"video_title":"2.Android Studio宸ュ叿璁茶В锛堢浜岄泦锛�","video_url":"g0318f44uqy","video_time":"","video_id":0},{"video_title":"3.Android Studio宸ュ叿璁茶В锛堢涓夐泦锛�","video_url":"t0318dk4dqw","video_time":"","video_id":0},{"video_title":"4.Android Studio宸ュ叿璁茶В锛堢鍥涢泦锛�","video_url":"y0318przo4v","video_time":"","video_id":0}]
     */

    private String title;
    private String video_url;
    private String video_desc;
    private boolean isList;
    private List<VideoListBean> video_list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getVideo_desc() {
        return video_desc;
    }

    public void setVideo_desc(String video_desc) {
        this.video_desc = video_desc;
    }

    public boolean isIsList() {
        return isList;
    }

    public void setIsList(boolean isList) {
        this.isList = isList;
    }

    public List<VideoListBean> getVideo_list() {
        return video_list;
    }

    public void setVideo_list(List<VideoListBean> video_list) {
        this.video_list = video_list;
    }

    public static class VideoListBean {
        /**
         * video_title : 1.Android Studio宸ュ叿璁茶В锛堢涓€闆嗭級
         * video_url : b0318cpzggn
         * video_time :
         * video_id : 0
         */

        private String video_title;
        private String video_url;
        private String video_time;
        private int video_id;

        public String getVideo_title() {
            return video_title;
        }

        public void setVideo_title(String video_title) {
            this.video_title = video_title;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public String getVideo_time() {
            return video_time;
        }

        public void setVideo_time(String video_time) {
            this.video_time = video_time;
        }

        public int getVideo_id() {
            return video_id;
        }

        public void setVideo_id(int video_id) {
            this.video_id = video_id;
        }
    }
}
