package com.android.app.electricvehicle.mvp.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.app.electricvehicle.R;


/**
 * @创建者 booobdai.
 * @创建时间 2017/8/30  14:15.
 * @描述 ${基本的 确定/取消 Dialog}.
 */
public class BasicDialog extends Dialog implements View.OnClickListener {
    private TextView contentTxt;
    private TextView titleTxt;
    private TextView submitTxt;
    private TextView cancelTxt;
    private ImageView ivClose;

    private Context mContext;
    private String mContent;
    private OnCloseListener listener;
    private String positiveName;
    private String negativeName;
    private String title;

    public interface OnCloseListener {
        void onClose(Dialog dialog, boolean confirm);
    }

    public BasicDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public BasicDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;
    }

    public BasicDialog(Context context, int themeResId, OnCloseListener listener) {
        super(context, themeResId);
        this.mContext = context;
        this.listener = listener;
    }

    protected BasicDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext = context;
    }

    public BasicDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public BasicDialog setPositiveButton(String name) {
        this.positiveName = name;
        return this;
    }

    public BasicDialog setNegativeButton(String name) {
        this.negativeName = name;
        return this;
    }

    public BasicDialog setContent(String content) {
        this.mContent = content;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_basic);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView() {
        contentTxt = (TextView) findViewById(R.id.tv_content_dialog_basic);
        titleTxt = (TextView) findViewById(R.id.tv_title_dialog_basic);
        submitTxt = (TextView) findViewById(R.id.tv_confirm_dialog);
        cancelTxt = (TextView) findViewById(R.id.tv_cancel_dialog);
        ivClose = (ImageView) findViewById(R.id.iv_dialog_basic_close);
        ivClose.setVisibility(View.INVISIBLE);
        submitTxt.setOnClickListener(this);
        cancelTxt.setOnClickListener(this);
        ivClose.setOnClickListener(this);

        if (!TextUtils.isEmpty(mContent)) {
            contentTxt.setText(mContent);
        }
        if (!TextUtils.isEmpty(positiveName)) {
            submitTxt.setText(positiveName);
        }
        if (!TextUtils.isEmpty(negativeName)) {
            cancelTxt.setText(negativeName);
        }
        if (!TextUtils.isEmpty(title)) {
            titleTxt.setText(title);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel_dialog:
                if (listener != null) {
                    listener.onClose(this, false);
                }
                dismiss();
                break;
            case R.id.tv_confirm_dialog:
                if (listener != null) {
                    listener.onClose(this, true);
                }
                break;
            case R.id.iv_dialog_basic_close:
                if (listener != null) {
                    listener.onClose(this, false);
                }
                dismiss();
                break;
        }
    }

}
