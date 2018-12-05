package cn.edu.zut.broadservice;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {

    private MediaPlayer mediaPlayer;
    private boolean isStop = true;

    public MyService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (isStop) {
            mediaPlayer.reset();
            //将需要播放的资源与之绑定
            mediaPlayer = MediaPlayer.create(this, R.raw.tie);
            //mediaPlayer=MediaPlayer.create(this,android.R.raw.1);
            //开始播放
            mediaPlayer.start();
            //是否循环播放
            mediaPlayer.setLooping(false);
            isStop = false;
        } else if (!isStop && mediaPlayer.isPlaying() && mediaPlayer != null) {
            mediaPlayer.start();
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
