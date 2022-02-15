package com.hms.codelab.account.smsretriever

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var ClickObserver = MutableLiveData<String>()
    var MobileNumber = MutableLiveData<String>()
    var Otp = MutableLiveData<String>()

    fun onClickGenerateCode(eventCode: String) {
        ClickObserver.value = eventCode
    }
}