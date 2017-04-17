package com.example.zyj.hellomvpworld;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//业务逻辑部分
class GreetingGeneratorTask extends AsyncTask<Void, Void, Integer> {
    private static final String TAG = "GreetingGeneratorTask";
    //callback - listener
    public interface GreetingTaskListener {
        public void onGreetingGenerated(String greetingText);
    }

    private String baseText;
    private GreetingTaskListener listener;

    public GreetingGeneratorTask(String baseText, GreetingTaskListener listener) {
        Log.i(TAG, "GreetingGeneratorTask: constructor");
        this.baseText = baseText;
        this.listener = listener;
    }

    //模拟计算，返回随机整数
    @Override
    protected Integer doInBackground(Void... params) {
        try {
            Log.i(TAG, "doInBackground: ");
            Thread.sleep(2000);//模拟计算
        } catch (InterruptedException e) {
        }

        return (int) (Math.random() * 100);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        Log.i(TAG, "onPostExecute: ");
        listener.onGreetingGenerated(baseText + " " + integer);
    }
}

//View接口
interface HelloMVPWorldView extends MvpView {

    //以红色文本显示“Hello”
    void showHello(String greetingText);

    //以蓝色文本显示“Goodbye”
    void showGoodbye(String greetingText);
}

//Presenter,协调HelloMVPWorldView和业务逻辑（GreetingGeneratorTask）
class HelloMVPWorldPresenter extends MvpBasePresenter<HelloMVPWorldView> {
    private static final String TAG = "HelloMVPWorldPresenter";
    //Greeting Task是业务逻辑
    private GreetingGeneratorTask greetingTask;

    private void cancelGreetingTaskIfRunning() {
        Log.i(TAG, "cancelGreetingTaskIfRunning: ");
        if (greetingTask != null) {
            greetingTask.cancel(true);
        }
    }

    public void greetHello() {
        Log.i(TAG, "greetHello: ");
        cancelGreetingTaskIfRunning();
        greetingTask = new GreetingGeneratorTask("Hello"
                , new GreetingGeneratorTask.GreetingTaskListener() {
            @Override
            public void onGreetingGenerated(String greetingText) {
                if (isViewAttached())
                    Log.i(TAG, "onGreetingGenerated: HelloGreetingTaskListener");
                    getView().showHello(greetingText);
            }
        });
        greetingTask.execute();
    }

    public void greetGoodbye() {
        Log.i(TAG, "greetGoodbye: ");
        cancelGreetingTaskIfRunning();

        greetingTask = new GreetingGeneratorTask("Goodbye", new GreetingGeneratorTask.GreetingTaskListener() {
            @Override
            public void onGreetingGenerated(String greetingText) {
                if (isViewAttached())
                    Log.i(TAG, "onGreetingGenerated: GoodbyeGreetingTaskListener");
                    getView().showGoodbye(greetingText);
            }
        });
        greetingTask.execute();
    }

    //Activity销毁时调用，取消正在运行的后台任务
    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance) {
            Log.i(TAG, "detachView: ");
            cancelGreetingTaskIfRunning();
        }
    }
}

public class HelloMVPWorldActivity extends MvpActivity<HelloMVPWorldView, HelloMVPWorldPresenter>
        implements HelloMVPWorldView {
    private static final String TAG = "HelloMvpWorldActivity";

    @Bind(R.id.greetingTextView)
    TextView mGreetingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    //Mosby内部调用
    @NonNull
    @Override
    public HelloMVPWorldPresenter createPresenter() {
        Log.i(TAG, "createPresenter: ");
        return new HelloMVPWorldPresenter();
    }

    @OnClick(R.id.helloButton)
    public void onHelloButtonClicked() {
        Log.i(TAG, "onHelloButtonClicked: ");
        presenter.greetHello();
    }

    @OnClick(R.id.goodbyeButton)
    public void onGoodbyeButtonClicked() {
        Log.i(TAG, "onGoodbyeButtonClicked: ");
        presenter.greetGoodbye();
    }

    @Override
    public void showHello(String greetingText) {
        Log.i(TAG, "showHello: ");
        mGreetingTextView.setTextColor(Color.RED);
        mGreetingTextView.setText(greetingText);
    }

    @Override
    public void showGoodbye(String greetingText) {
        Log.i(TAG, "showGoodbye: ");
        mGreetingTextView.setTextColor(Color.BLUE);
        mGreetingTextView.setText(greetingText);
    }
}