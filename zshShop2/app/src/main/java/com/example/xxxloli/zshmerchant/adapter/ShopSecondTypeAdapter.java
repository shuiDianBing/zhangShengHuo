package com.example.xxxloli.zshmerchant.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.xxxloli.zshmerchant.R;
import com.example.xxxloli.zshmerchant.objectmodel.ShopType;
import com.example.xxxloli.zshmerchant.view.MyRadioButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/15.
 */

public class ShopSecondTypeAdapter extends BaseAdapter {

    private ArrayList<ShopType> shopTypes;
    private Context mContext;
    //    private int  selectItem=-1;
    int mSelect = 0;

    public ShopSecondTypeAdapter(Context mContext, ArrayList<ShopType> shopTypes) {
        this.shopTypes = shopTypes;
        this.mContext = mContext;
    }

    //刷新Adapter
    public void refresh(ArrayList<ShopType> shopTypes) {
        this.shopTypes = shopTypes;//传入list，然后调用notifyDataSetChanged方法
        notifyDataSetChanged();
    }

    public void changeSelected(int positon) { //刷新方法
        if (positon != mSelect) {
            mSelect = positon;
            notifyDataSetChanged();
        }
    }


    @Override
    public int getCount() {
        return shopTypes == null ? 0 : shopTypes.size();
    }

    @Override
    public Object getItem(int i) {
        return shopTypes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_select_area, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.radio.setChecked(false);
        holder.radio.setText(shopTypes.get(i).getGenericClassName());
        if (mSelect == i) {
            holder.radio.setChecked(false);
        }
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.radio)
        MyRadioButton radio;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
