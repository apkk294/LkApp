package com.lk.lkapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Package：com.lk.lkapp.bean
 * Created by user005 on 2016/12/17.
 * Description：.
 */

public class LolNewsListBean implements Parcelable {

    private String         next;
    private String         nextpage;
    private String         this_page_num;
    /**
     * article_id : 26365
     * content_id : 26365
     * newstype :
     * newstypeid : ordinary
     * channel_desc :
     * channel_id : <2>:<12>,<2>:<3>
     * insert_date : 2016-12-13 12:34:12
     * title : 2017赛季正式开始！
     * article_url : http://qt.qq.com/php_cgi/news/php/varcache_article.php?id=26365&version=$PROTO_VERSION$
     * summary : 召唤师们需要进行10场排位定级赛才能获得新赛季灵活组排的初始段位。
     * score : 3
     * publication_date : 2016-12-13 12:34:12
     * targetid : 1665312956
     * intent :
     * is_act : 0
     * is_hot : 0
     * is_subject : 0
     * is_new : 0
     * is_top : True
     * image_with_btn : False
     * image_spec : 1
     * is_report : True
     * is_direct : False
     * image_url_small : http://ossweb-img.qq.com/upload/qqtalk/news/201612/131234129422656_282.jpg
     * image_url_big : http://ossweb-img.qq.com/upload/qqtalk/news/201612/131234129422656_480.jpg
     * pv : 5804822
     * bmatchid : 0
     * v_len :
     * pics_id : 0
     * is_purchase : 0
     */

    private List<ListBean> list;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getNextpage() {
        return nextpage;
    }

    public void setNextpage(String nextpage) {
        this.nextpage = nextpage;
    }

    public String getThis_page_num() {
        return this_page_num;
    }

    public void setThis_page_num(String this_page_num) {
        this.this_page_num = this_page_num;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Parcelable {
        private String article_id;
        private String content_id;
        private String newstype;
        private String newstypeid;
        private String channel_desc;
        private String channel_id;
        private String insert_date;
        private String title;
        private String article_url;
        private String summary;
        private String score;
        private String publication_date;
        private String targetid;
        private String intent;
        private String is_act;
        private String is_hot;
        private String is_subject;
        private String is_new;
        private String is_top;
        private String image_with_btn;
        private String image_spec;
        private String is_report;
        private String is_direct;
        private String image_url_small;
        private String image_url_big;
        private int pv;
        private String bmatchid;
        private String v_len;
        private String pics_id;
        private String is_purchase;

        public String getArticle_id() {
            return article_id;
        }

        public void setArticle_id(String article_id) {
            this.article_id = article_id;
        }

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        public String getNewstype() {
            return newstype;
        }

        public void setNewstype(String newstype) {
            this.newstype = newstype;
        }

        public String getNewstypeid() {
            return newstypeid;
        }

        public void setNewstypeid(String newstypeid) {
            this.newstypeid = newstypeid;
        }

        public String getChannel_desc() {
            return channel_desc;
        }

        public void setChannel_desc(String channel_desc) {
            this.channel_desc = channel_desc;
        }

        public String getChannel_id() {
            return channel_id;
        }

        public void setChannel_id(String channel_id) {
            this.channel_id = channel_id;
        }

        public String getInsert_date() {
            return insert_date;
        }

        public void setInsert_date(String insert_date) {
            this.insert_date = insert_date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getArticle_url() {
            return article_url;
        }

        public void setArticle_url(String article_url) {
            this.article_url = article_url;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getPublication_date() {
            return publication_date;
        }

        public void setPublication_date(String publication_date) {
            this.publication_date = publication_date;
        }

        public String getTargetid() {
            return targetid;
        }

        public void setTargetid(String targetid) {
            this.targetid = targetid;
        }

        public String getIntent() {
            return intent;
        }

        public void setIntent(String intent) {
            this.intent = intent;
        }

        public String getIs_act() {
            return is_act;
        }

        public void setIs_act(String is_act) {
            this.is_act = is_act;
        }

        public String getIs_hot() {
            return is_hot;
        }

        public void setIs_hot(String is_hot) {
            this.is_hot = is_hot;
        }

        public String getIs_subject() {
            return is_subject;
        }

        public void setIs_subject(String is_subject) {
            this.is_subject = is_subject;
        }

        public String getIs_new() {
            return is_new;
        }

        public void setIs_new(String is_new) {
            this.is_new = is_new;
        }

        public String getIs_top() {
            return is_top;
        }

        public void setIs_top(String is_top) {
            this.is_top = is_top;
        }

        public String getImage_with_btn() {
            return image_with_btn;
        }

        public void setImage_with_btn(String image_with_btn) {
            this.image_with_btn = image_with_btn;
        }

        public String getImage_spec() {
            return image_spec;
        }

        public void setImage_spec(String image_spec) {
            this.image_spec = image_spec;
        }

        public String getIs_report() {
            return is_report;
        }

        public void setIs_report(String is_report) {
            this.is_report = is_report;
        }

        public String getIs_direct() {
            return is_direct;
        }

        public void setIs_direct(String is_direct) {
            this.is_direct = is_direct;
        }

        public String getImage_url_small() {
            return image_url_small;
        }

        public void setImage_url_small(String image_url_small) {
            this.image_url_small = image_url_small;
        }

        public String getImage_url_big() {
            return image_url_big;
        }

        public void setImage_url_big(String image_url_big) {
            this.image_url_big = image_url_big;
        }

        public int getPv() {
            return pv;
        }

        public void setPv(int pv) {
            this.pv = pv;
        }

        public String getBmatchid() {
            return bmatchid;
        }

        public void setBmatchid(String bmatchid) {
            this.bmatchid = bmatchid;
        }

        public String getV_len() {
            return v_len;
        }

        public void setV_len(String v_len) {
            this.v_len = v_len;
        }

        public String getPics_id() {
            return pics_id;
        }

        public void setPics_id(String pics_id) {
            this.pics_id = pics_id;
        }

        public String getIs_purchase() {
            return is_purchase;
        }

        public void setIs_purchase(String is_purchase) {
            this.is_purchase = is_purchase;
        }

        public String getPvCountFormat() {
            String result;

            if (pv >= 10000) {
                result = String.valueOf(pv / 1000);
            } else {
                result = String.valueOf(pv);
            }

            result += "万阅";

            return result;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.article_id);
            dest.writeString(this.content_id);
            dest.writeString(this.newstype);
            dest.writeString(this.newstypeid);
            dest.writeString(this.channel_desc);
            dest.writeString(this.channel_id);
            dest.writeString(this.insert_date);
            dest.writeString(this.title);
            dest.writeString(this.article_url);
            dest.writeString(this.summary);
            dest.writeString(this.score);
            dest.writeString(this.publication_date);
            dest.writeString(this.targetid);
            dest.writeString(this.intent);
            dest.writeString(this.is_act);
            dest.writeString(this.is_hot);
            dest.writeString(this.is_subject);
            dest.writeString(this.is_new);
            dest.writeString(this.is_top);
            dest.writeString(this.image_with_btn);
            dest.writeString(this.image_spec);
            dest.writeString(this.is_report);
            dest.writeString(this.is_direct);
            dest.writeString(this.image_url_small);
            dest.writeString(this.image_url_big);
            dest.writeInt(this.pv);
            dest.writeString(this.bmatchid);
            dest.writeString(this.v_len);
            dest.writeString(this.pics_id);
            dest.writeString(this.is_purchase);
        }

        public ListBean() {
        }

        protected ListBean(Parcel in) {
            this.article_id = in.readString();
            this.content_id = in.readString();
            this.newstype = in.readString();
            this.newstypeid = in.readString();
            this.channel_desc = in.readString();
            this.channel_id = in.readString();
            this.insert_date = in.readString();
            this.title = in.readString();
            this.article_url = in.readString();
            this.summary = in.readString();
            this.score = in.readString();
            this.publication_date = in.readString();
            this.targetid = in.readString();
            this.intent = in.readString();
            this.is_act = in.readString();
            this.is_hot = in.readString();
            this.is_subject = in.readString();
            this.is_new = in.readString();
            this.is_top = in.readString();
            this.image_with_btn = in.readString();
            this.image_spec = in.readString();
            this.is_report = in.readString();
            this.is_direct = in.readString();
            this.image_url_small = in.readString();
            this.image_url_big = in.readString();
            this.pv = in.readInt();
            this.bmatchid = in.readString();
            this.v_len = in.readString();
            this.pics_id = in.readString();
            this.is_purchase = in.readString();
        }

        public static final Parcelable.Creator<ListBean> CREATOR = new Parcelable.Creator<ListBean>() {
            @Override
            public ListBean createFromParcel(Parcel source) {
                return new ListBean(source);
            }

            @Override
            public ListBean[] newArray(int size) {
                return new ListBean[size];
            }
        };
    }

    public boolean hasNext() {
        return next.equals("True");
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.next);
        dest.writeString(this.nextpage);
        dest.writeString(this.this_page_num);
        dest.writeTypedList(this.list);
    }

    public LolNewsListBean() {
    }

    protected LolNewsListBean(Parcel in) {
        this.next = in.readString();
        this.nextpage = in.readString();
        this.this_page_num = in.readString();
        this.list = in.createTypedArrayList(ListBean.CREATOR);
    }

    public static final Parcelable.Creator<LolNewsListBean> CREATOR = new Parcelable.Creator<LolNewsListBean>() {
        @Override
        public LolNewsListBean createFromParcel(Parcel source) {
            return new LolNewsListBean(source);
        }

        @Override
        public LolNewsListBean[] newArray(int size) {
            return new LolNewsListBean[size];
        }
    };
}
