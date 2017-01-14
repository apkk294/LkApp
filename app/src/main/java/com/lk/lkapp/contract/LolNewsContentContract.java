package com.lk.lkapp.contract;

import com.lk.lkapp.bean.LolNewsListBean;

/**
 * Package：com.lk.lkapp.contract
 * Created by user005 on 2016/12/29.
 * Description：.
 */

public class LolNewsContentContract {
    
    
    
public interface View{
    LolNewsListBean.ListBean getNewsDetail();

    void setNewsTitle(String title);

    void setNewsImg(String imgUrl);

    void setNewsUrl(String url);
}

public interface Presenter{
    void getNewsDetail();
}

public interface Model{

}


}