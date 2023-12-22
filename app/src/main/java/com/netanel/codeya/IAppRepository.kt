package com.netanel.codeya

import com.google.firebase.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.storage
import com.netanel.codeya.utils.Constants


/**
 * Created by netanelamar on 22/12/2023.
 * NetanelCA2@gmail.com
 */
interface IAppRepository {
    val appRepository: FirebaseStorage
        get() = Firebase.storage(Constants.storagePath)
}