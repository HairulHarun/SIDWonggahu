package com.chairul.sidwonggahu.service;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;

public class NotificationSound extends Service {
    static Ringtone r;

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //activating alarm sound
        Uri notification = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getApplicationContext().getPackageName() + "/raw/alarm");
        r = RingtoneManager.getRingtone(getBaseContext(), notification);
        //playing sound alarm
        r.play();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
        r.stop();
    }
}
