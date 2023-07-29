package com.example.demo

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat



var notificationID: Int = 0
const val channelID = "channel"
const val titleExtra = "titleExtra"
const val messageExtra = "messageExtra"

//This is the notification builder
//Extends the broadcast receiver class
class Notifications : BroadcastReceiver()
{
    override fun onReceive(context: Context, intent: Intent) {
       val notification = NotificationCompat.Builder(context, channelID ).setSmallIcon(R.drawable.baseline_access_time_filled_24)
           .setContentTitle(intent.getStringExtra(titleExtra))
           .setContentText(intent.getStringExtra(messageExtra))
           .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(notificationID, notification)
        notificationID++
    }



}