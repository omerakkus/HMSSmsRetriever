package com.hms.codelab.account.smsretriever

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var clickObserver = MutableLiveData<String>()
    var mobileNumber = MutableLiveData<String>()
    var otp = MutableLiveData<String>()

    fun onClickGenerateCode(eventCode: String) {
        clickObserver.value = eventCode
    }
}