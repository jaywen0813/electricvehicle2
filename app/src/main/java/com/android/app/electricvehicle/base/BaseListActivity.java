package com.android.app.electricvehicle.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.mvp.view.RecyclerViewDivider;
import com.android.app.electricvehicle.utils.UIUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseListActivity<V, T extends BasePresenter<V>> extends BaseMvpActivity implements SwipeRefreshLayout
        .OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemClickListener {


//    @BindView(R.id.rv_list)
    public RecyclerView rvList;
//    @BindView(R.id.srl_list)
    public SwipeRefreshLayout srlList;

    Unbinder unbinder;
    private TextView mTvEmpty;
    private ImageView mEmptyIm;

    private static final String TAG = BaseListFragment.class.getSimpleName();
    //分页 每页item数量
    protected static final int PAGE_SIZE = 20;
    //列表Adapter
    protected BaseQuickAdapter adapter;
    //页码, 初始为1
    protected int page = 1;
    //分页 index
    protected int firstIndex = 0;
    //是否是刷新 默认进来是刷新 true
    protected boolean isRefresh = true;


    @Override
    protected void initView() {
        super.initView();
        srlList=findViewById(R.id.srl_list);
        rvList=findViewById(R.id.rv_list);
//        srlList.setColorSchemeColors(UIUtils.getColor(R.color.colorPrimary));
//        srlList.setOnRefreshListener(this);
        rvList.setLayoutManager(getLayoutManager());
        adapter = getRecyclerAdapter();
        rvList.setAdapter(adapter);
        adapter.bindToRecyclerView(rvList);
        if (canLoadMore()) {
            adapter.setOnLoadMoreListener(this);
        }
        if (getRecycleViewDivider() != null) {
            rvList.addItemDecoration(getRecycleViewDivider());
        }
        if (getEmptyView() != null) {
            adapter.setEmptyView(getEmptyView());
        }
        adapter.setOnItemClickListener(this);
    }


    @Override
    protected int getLayoutById() {
        return R.layout.activity_list;
    }


    @Override
    protected BasePresenter initPresenter() {
        return getPresenter();
    }

    protected abstract BasePresenter getPresenter();

    /**
     * 是否支持加载更多 (如需修改, 重写此方法)
     *
     * @return
     */
    protected boolean canLoadMore() {
        return true;
    }



    /**
     * 获取分割线 (默认横向分割线2px灰色, 如需修改 重新此方法)
     *
     * @return
     */
    protected RecyclerView.ItemDecoration getRecycleViewDivider() {
        return new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL);
    }

    /**
     * 获取LayoutManager( 默认 线性 纵向, 如需修改重写此方法)
     *
     * @return
     */
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    }

    protected View getEmptyView() {
        View emptyView = LayoutInflater.from(this).inflate(R.layout.layout_empty, null);
        mTvEmpty = (TextView) emptyView.findViewById(R.id.tv_empty);
        mEmptyIm = emptyView.findViewById(R.id.empty_im);
        return emptyView;
    }


    public void loading() {
        if (!srlList.isRefreshing()) {
            srlList.setRefreshing(true);
        }
        if (mTvEmpty != null) {
            mTvEmpty.setText(R.string.base_load_loading);
            mTvEmpty.setVisibility(View.VISIBLE);
            mEmptyIm.setVisibility(View.INVISIBLE);
        }
    }

    public void loadingComplete() {
        if (srlList != null) {
            srlList.setRefreshing(false);
        }
        //如果当前正在加载更多
        if (!isRefresh && adapter.isLoading()) {
            adapter.loadMoreComplete();
        }
        if (mTvEmpty != null) {
            mTvEmpty.setText(UIUtils.getString(R.string.base_load_empty));
            mTvEmpty.setVisibility(View.INVISIBLE);
            mEmptyIm.setVisibility(View.INVISIBLE);//这里先隐藏
        }
    }


    public void onloadSucceed() {
        page++;
        firstIndex += PAGE_SIZE;
    }

    public void onLoadFail() {
        if (isRefresh && adapter.getData().size() == 0) {
            //刷新失败, 且原数据为空则显示加载错误的布局
            Logger.e(TAG, "onLoadFail refresh Fail");
            //            showError();
            if (mTvEmpty != null) {
                mTvEmpty.setText(UIUtils.getString(R.string.base_load_error_and_retry));
                mTvEmpty.setVisibility(View.VISIBLE);
                mEmptyIm.setVisibility(View.INVISIBLE);
            }
        } else {
            //loadmore 失败
            adapter.loadMoreFail();
            Logger.e(TAG, "onLoadFail loadMore Fail");
        }
    }

    /**
     * 获取adapter
     */
    protected abstract BaseQuickAdapter getRecyclerAdapter();

    /**
     * 刷新列表
     */
    protected abstract void refresh();

    /**
     * 加载更多
     */
    protected abstract void loadMore();





    @Override
    public void onRefresh() {
        page = 1;
        firstIndex = 0;
        isRefresh = true;
        refresh();
    }







    @Override
    public void onLoadMoreRequested() {
        isRefresh = false;
        loadMore();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        if (getPresenter() != null) {
            getPresenter().detachView();
        }
    }
    
}
