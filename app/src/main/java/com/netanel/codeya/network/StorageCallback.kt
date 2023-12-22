package com.netanel.codeya.network


/**
 * Created by netanelamar on 22/12/2023.
 * NetanelCA2@gmail.com
 */

interface StorageCallback {
        fun onSuccess(result: String?)
        fun onFailure(message: String?)
}