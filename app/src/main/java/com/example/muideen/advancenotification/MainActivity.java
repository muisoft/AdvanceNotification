package com.example.muideen.advancenotification;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFICATION_ID = 1001;
    private NotificationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Button showButton = (Button) findViewById(R.id.show_notification);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNotification();
            }
        });

        Button hideButton = (Button) findViewById(R.id.cancel_notification);
        hideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNotification();
            }
        });
    }
    private void showNotification() {
        Intent mIntent = new Intent(getApplicationContext(),TestActivity.class);
        mIntent.setAction(TestActivity.ACTION_CALL);
        Intent v=new Intent(getApplicationContext(),TestActivity.class);
        v.setAction(TestActivity.ACTION_VIDEO_CALL);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,
                mIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent pendingIntent1 = PendingIntent.getActivity(getApplicationContext(),0,
                v, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext());
        notification.setTicker("Advance Notification Demo");
        notification.setContentTitle("Advance Notification Demo");
        notification.setContentText("You have new notification");
        notification.setSmallIcon(R.drawable.ic_account_circle_black_24dp);
        notification.setContentIntent(pendingIntent);
        notification.setAutoCancel(true);
        notification.setWhen(System.currentTimeMillis());
        notification.addAction(R.drawable.ic_clear_black_24dp,"Cancel",pendingIntent);
        notification.addAction(R.drawable.ic_call_black_24dp,"Call",pendingIntent1);

        manager.notify(NOTIFICATION_ID, notification.build());
    }

    private void hideNotification() {
        manager.cancel(NOTIFICATION_ID);
    }

}
