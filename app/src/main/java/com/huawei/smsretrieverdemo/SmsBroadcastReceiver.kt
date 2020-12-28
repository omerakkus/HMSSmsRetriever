package com.huawei.smsretrieverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.huawei.hms.common.api.CommonStatusCodes
import com.huawei.hms.support.api.client.Status
import com.huawei.hms.support.sms.common.ReadSmsConstant

class SmsBroadcastReceiver : BroadcastReceiver() {

    companion object {
        val TAG = "SmsRetrieverDemo"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val bundle = intent!!.extras
        if (bundle != null) {
            val status: Status? = bundle.getParcelable(ReadSmsConstant.EXTRA_STATUS)
            if (status?.statusCode == CommonStatusCodes.TIMEOUT) {

            } else if (status?.statusCode == CommonStatusCodes.SUCCESS) {

                if (bundle.containsKey(ReadSmsConstant.EXTRA_SMS_MESSAGE)) {

                    bundle.getString(ReadSmsConstant.EXTRA_SMS_MESSAGE)?.let {
                        Log.d(TAG, it)
                        val local = Intent()
                        local.action = "service.to.activity.transfer"
                        local.putExtra("sms", it)
                        context!!.sendBroadcast(local)
                    }
                }
            }
        }
    }
}