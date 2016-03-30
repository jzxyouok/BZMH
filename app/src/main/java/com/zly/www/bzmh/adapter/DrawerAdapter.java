package com.zly.www.bzmh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zly.www.bzmh.R;

import java.util.Arrays;
import java.util.List;

/**
 * 仿navigationview实现
 * Created by zly on 2016/3/30.
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerViewHolder> {

    private static final int TYPE_DIVIDER = 0;
    private static final int TYPE_NORMAL = 1;
    private static final int TYPE_HEADER = 2;

    private List<DrawerItem> dataList = Arrays.asList(
            new DrawerItemHeader(),
            new DrawerItemNormal(R.mipmap.icon_drawerlayout_home, "首页"),
            new DrawerItemNormal(R.mipmap.icon_drawerlayout_rank, "排行榜"),
            new DrawerItemNormal(R.mipmap.icon_drawerlayout_column, "栏目"),
            new DrawerItemNormal(R.mipmap.icon_drawerlayout_search, "搜索"),
            new DrawerItemNormal(R.mipmap.icon_drawerlayout_setting, "设置"),
            new DrawerItemDivider(),
            new DrawerItemNormal(R.mipmap.icon_drawerlayout_night, "夜间模式"),
            new DrawerItemNormal(R.mipmap.icon_drawerlayout_offline, "离线")
    );
    private LayoutInflater inflater;
    private LinearLayout headerView;

    public DrawerAdapter(Context context,ViewGroup parentView) {
        inflater = LayoutInflater.from(context);
        headerView = (LinearLayout) inflater.inflate(R.layout.item_drawer_header_container, parentView, false);
    }

    public void inflaterHeader(int res){
        headerView.addView(inflater.inflate(res,headerView,false));
    }

    public View getHeaderView(int position){
        return headerView.getChildAt(position);
    }


    @Override
    public int getItemViewType(int position) {
        DrawerItem drawerItem = dataList.get(position);
        if (drawerItem instanceof DrawerItemDivider) {
            return TYPE_DIVIDER;
        } else if (drawerItem instanceof DrawerItemNormal) {
            return TYPE_NORMAL;
        }else if(drawerItem instanceof DrawerItemHeader){
            return TYPE_HEADER;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return (dataList == null || dataList.size() == 0) ? 0 : dataList.size();
    }

    @Override
    public DrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DrawerViewHolder viewHolder = null;
        switch (viewType) {
            case TYPE_DIVIDER:
                viewHolder = new DividerViewHolder(inflater.inflate(R.layout.item_drawer_divider, parent, false));
                break;
            case TYPE_HEADER:
                viewHolder = new HeaderViewHolder(headerView);
                break;
            case TYPE_NORMAL:
                viewHolder = new NormalViewHolder(inflater.inflate(R.layout.item_drawer_normal, parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DrawerViewHolder holder, int position) {
        DrawerItem item = dataList.get(position);
        if (holder instanceof NormalViewHolder) {
            final NormalViewHolder normalViewHolder = (NormalViewHolder) holder;
            DrawerItemNormal itemNormal = (DrawerItemNormal) item;
            normalViewHolder.iv.setBackgroundResource(itemNormal.iconRes);
            normalViewHolder.tv.setText(itemNormal.title);

            normalViewHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.itemClick(normalViewHolder.view);
                    }
                }
            });


        }
    }

    public OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void itemClick(View v);
    }




    //-------------------------item数据模型------------------------------
    // drawerlayout item统一的数据模型
    private interface DrawerItem {
    }


    //有图片和文字的item
    class DrawerItemNormal implements DrawerItem {
        public int iconRes;
        public String title;

        public DrawerItemNormal(int iconRes, String title) {
            this.iconRes = iconRes;
            this.title = title;
        }

    }

    //分割线item
    class DrawerItemDivider implements DrawerItem {
        public DrawerItemDivider() {
        }
    }

    //头部item
    class DrawerItemHeader implements DrawerItem{
        public DrawerItemHeader() {
        }
    }



    //----------------------------------ViewHolder数据模型---------------------------
    //抽屉ViewHolder模型
    class DrawerViewHolder extends RecyclerView.ViewHolder {

        public DrawerViewHolder(View itemView) {
            super(itemView);
        }
    }

    //有图标有文字ViewHolder
    class NormalViewHolder extends DrawerViewHolder {
        public View view;
        public TextView tv;
        public ImageView iv;

        public NormalViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tv = (TextView) itemView.findViewById(R.id.tv);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

    //分割线ViewHolder
    class DividerViewHolder extends DrawerViewHolder {

        public DividerViewHolder(View itemView) {
            super(itemView);
        }
    }

    //头部ViewHolder
    class HeaderViewHolder extends DrawerViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
