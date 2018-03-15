package kr.sofac.itsskinapp

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.google.firebase.messaging.FirebaseMessagingService
import android.content.ContentValues.TAG
import android.content.Context
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.google.firebase.messaging.RemoteMessage
import kr.sofac.itsskinapp.ui.navigation.NavigationActivity


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {

        Log.d(TAG, "From: " + remoteMessage!!.from)
        sendNotification(remoteMessage)

//        if (remoteMessage.data.size > 0) {
//            Log.e(TAG, "Message data payload: " + remoteMessage.data)
//        }
//
//        if (remoteMessage.notification != null) {
//            Log.e(TAG, "Message Notification Body: " + remoteMessage.notification.body!!)
//        }

    }

    private fun sendNotification(remoteMessage: RemoteMessage) {
        val intent = Intent(this, NavigationActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this)
                .setContentText(remoteMessage.notification.body)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.logo)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
    }
}
