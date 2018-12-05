package cn.edu.zut.broadservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = "MyReceiver";
    private static final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "已开机，广播接受者onReciver()方法调用......");

        if (intent.getAction().equals(ACTION_BOOT)) {
            Log.i(TAG, "广播接受者在开机时启动，可以调用开机服务了......");
            Intent intent1 = new Intent(context,MyService.class);
            context.startService(intent1);
        }
    }
}
