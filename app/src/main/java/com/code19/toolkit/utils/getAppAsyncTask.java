package com.code19.toolkit.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.code19.toolkit.R;
import com.code19.toolkit.model.AppModel;

import java.util.List;

/**
 * Created by gh0st on 2017/2/21.
 */

public class GetAppAsyncTask extends AsyncTask<Void, Integer, List<AppModel>> {
    private Context mContext;
    private CallBack mCallback;
    private ProgressDialog mProgressDialog;

    public GetAppAsyncTask(Context context, CallBack callBack) {
        this.mContext = context;
        this.mCallback = callBack;
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setMessage(context.getString(R.string.loading));
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //运行在UI线程中，在调用doInBackground()之前执行
        if (mProgressDialog != null)
            mProgressDialog.show();
    }

    @Override
    protected List<AppModel> doInBackground(Void... voids) {
        //后台运行的方法，可以运行非UI线程，可以执行耗时的方法
        return AppUtil2.getInstallApp(mContext);
    }

    @Override
    protected void onPostExecute(List<AppModel> appModels) {
        super.onPostExecute(appModels);
        //运行在ui线程中，在doInBackground()执行完毕后执行
        mCallback.send(appModels);
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    //定义接口
    public interface CallBack {
        void send(List<AppModel> result);
    }
}
