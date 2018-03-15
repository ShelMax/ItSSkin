package kr.sofac.itsskinapp

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService


/**
 * Created by Asus SoFA on 15.03.2018.
 */
class MyFirebaseInstanceIDService: FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        val refreshedToken = FirebaseInstanceId.getInstance().token

        Log.e(TAG, "Refreshed token: " + refreshedToken!!)

    }

}