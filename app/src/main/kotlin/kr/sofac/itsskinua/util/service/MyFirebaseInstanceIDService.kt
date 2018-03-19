package kr.sofac.itsskinua.util.service

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import kr.sofac.itsskinua.util.AppPreference


/**
 * Created by Asus SoFA on 15.03.2018.
 */
class MyFirebaseInstanceIDService: FirebaseInstanceIdService() {

    override fun onTokenRefresh() {

        val refreshedToken = FirebaseInstanceId.getInstance().token
        Log.e(TAG, "Refreshed token: " + refreshedToken!!)
        AppPreference(this).saveGoogleCloudKey(refreshedToken)

    }

}