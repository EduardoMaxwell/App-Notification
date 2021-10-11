package com.eduardomaxwell.applicationnotification.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.eduardomaxwell.applicationnotification.R
import com.eduardomaxwell.applicationnotification.ui.MainActivity

lateinit var notificationManger: NotificationManager
lateinit var notificationChannel: NotificationChannel
lateinit var builder: NotificationCompat.Builder

fun Context.showNotification(channelId: String, title: String, body: String) {
    notificationManger = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val intent = Intent(this, MainActivity::class.java)
    val pendingIntent =
        PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        notificationChannel =
            NotificationChannel(channelId, body, NotificationManager.IMPORTANCE_HIGH).apply {
                lightColor = Color.BLUE
                enableVibration(true)
            }
        notificationManger.createNotificationChannel(notificationChannel)

        builder = NotificationCompat.Builder(this, channelId).apply {
            setSmallIcon(R.drawable.ic_baseline_autorenew_24)
            setContentTitle(title)
            setContentText(body)
            setAutoCancel(true)
            setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
            setContentIntent(pendingIntent)
        }
    }

    notificationManger.notify(channelId.toInt(), builder.build())
}