package cn.nzy.toutiao.adater;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;

import java.util.List;

import cn.nzy.toutiao.Bean.ContentBean;
import cn.nzy.toutiao.Bean.NetDataBean;
import cn.nzy.toutiao.R;
import cn.nzy.toutiao.utils.GlideUtil;

/**
 * Created by Administrator on 2016/11/18 0018.
 */
public class NewsAdapter extends BaseQuickAdapter<NetDataBean.DataBean,BaseViewHolder> {
    private Fragment mFragment;
    public NewsAdapter(List<NetDataBean.DataBean> data, Fragment fragment) {
        super(R.layout.item_news, data);
        mFragment=fragment;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, NetDataBean.DataBean dataBean) {
        //防止复用View没有改变主题，重新设置
        setGone(baseViewHolder);
        String content = dataBean.getContent();
        Gson gson = new Gson();
        ContentBean news = gson.fromJson(content, ContentBean.class);
        int article_type = news.getArticle_type();
        if (article_type==0) {
            //文章类型
            if (news.getImage_list() == null || news.getImage_list().size() == 0) {
                if (!TextUtils.isEmpty(news.getUrl())) {

                    //单图片文章
                    GlideUtil.setImage(mFragment,news.getUrl(), (ImageView) baseViewHolder.getView(R.id.ivRightImg1));
                    baseViewHolder.setVisible(R.id.rlRightImg, true)
                            .setVisible(R.id.viewFill, true);
                }
            } else {
                //3张图片
                baseViewHolder.setVisible(R.id.llCenterImg, true);
                try {
                    GlideUtil.setImage(mFragment,news.getImage_list().get(0).getUrl(), (ImageView) baseViewHolder.getView(R.id.ivCenterImg1));
                    GlideUtil.setImage(mFragment,news.getImage_list().get(1).getUrl(), (ImageView) baseViewHolder.getView(R.id.ivCenterImg2));
                    GlideUtil.setImage(mFragment,news.getImage_list().get(2).getUrl(), (ImageView) baseViewHolder.getView(R.id.ivCenterImg3));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } else if (article_type==1) {
            //画廊类型
            if (news.getImage_list() == null || news.getImage_list().size() == 0) {
                GlideUtil.setImage(mFragment,news.getUrl(), (ImageView) baseViewHolder.getView(R.id.ivRightImg1));
                baseViewHolder.setVisible(R.id.rlRightImg, true)
                        .setVisible(R.id.viewFill, true);
            } else {
                GlideUtil.setImage(mFragment,news.getImage_list().get(0).getUrl(), (ImageView) baseViewHolder.getView(R.id.ivBigImg));
                baseViewHolder.setVisible(R.id.rlBigImg, true)
                        .setText(R.id.tvImgCount, news.getImage_list().size() + "图");
            }


        } else if (news.isHas_video()) {
            //视频类型
            GlideUtil.setImage(mFragment,news.getUrl(), (ImageView) baseViewHolder.getView(R.id.ivRightImg1));
            baseViewHolder.setVisible(R.id.rlRightImg, true)
                    .setVisible(R.id.viewFill, true)
                    .setVisible(R.id.llVideo, true).setText(R.id.tvDuration, news.getVideo_style());
        }
        baseViewHolder.setText(R.id.tvTitle, news.getTitle())
                .setText(R.id.tvAuthorName, news.getSource())
                .setText(R.id.tvCommentCount, news.getComment_count() + "评论")
                .setText(R.id.tvTime,  news.getPublish_time() * 1000+"");
    }

    private void setGone(BaseViewHolder baseViewHolder) {
        baseViewHolder.setVisible(R.id.viewFill, false)
                .setVisible(R.id.llCenterImg, false)
                .setVisible(R.id.rlBigImg, false)
                .setVisible(R.id.llVideo, false)
                .setVisible(R.id.rlRightImg, false);

    }
}
