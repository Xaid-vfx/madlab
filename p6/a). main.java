package com.example.notificationprog6a;
import android.app.Notification;
import android.app.NotificationChannel; import android.app.NotificationManager; import android.app.PendingIntent; import android.app.TaskStackBuilder; import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity; import androidx.core.app.NotificationCompat;
@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
Button but;
Context context=MainActivity.this;
String CHANNEL_ID="my_channel_01"; CharSequence name = "my_channel";
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
but= findViewById(R.id.buttonNotify);
NotificationManager notificationManager = (NotificationManager)
context.getSystemService(Context.NOTIFICATION_SERVICE);
but.setOnClickListener(v -> {
NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name,
NotificationManager.IMPORTANCE_HIGH); notificationManager.createNotificationChannel(mChannel);
Intent notificationIntent = new Intent(context, MainActivity.class);
TaskStackBuilder stackBuilder = TaskStackBuilder.create(context); stackBuilder.addParentStack(MainActivity.class); stackBuilder.addNextIntent(notificationIntent);
PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_IMMUTABLE);
 S Trisheela
NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID);
Notification notification = builder.setContentTitle("Notification Title") .setContentText("Notification Text")
.setTicker("Test!")
.setSmallIcon(R.mipmap.ic_launcher)
.setAutoCancel(true) .setContentIntent(pendingIntent).build();
notificationManager.notify(0, notification); });
} }
