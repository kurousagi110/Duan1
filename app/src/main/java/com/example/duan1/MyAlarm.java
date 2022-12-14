package com.example.duan1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

public class MyAlarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("dulieu", "bao thuc da chay");

        String CHANNEL_ID = "channel_id";
        CharSequence name = "chanel_name";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        Notification builder=new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("To Do App")
                .setContentText("Bạn Có Công Việc Chưa Hoàn Thành")
                .setChannelId(CHANNEL_ID)
                .build();
        NotificationManager manager= (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mchanel = new NotificationChannel(CHANNEL_ID,name,importance);
            manager.createNotificationChannel(mchanel);
        }
        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pe=PendingIntent.getActivity(context,

                0, i, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.contentIntent = pe;
        manager.notify(0,builder);

        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
