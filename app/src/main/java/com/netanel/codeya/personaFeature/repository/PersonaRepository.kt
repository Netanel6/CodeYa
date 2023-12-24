package com.netanel.codeya.personaFeature.repository

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.netanel.codeya.IAppRepository
import com.netanel.codeya.network.StorageCallback
import java.nio.charset.StandardCharsets


/**
 * Created by netanelamar on 22/12/2023.
 * NetanelCA2@gmail.com
 */
class PersonaRepository : IPersonaRepository {
    private var storage: FirebaseStorage? = null
    private var storageRef: StorageReference? = null

    override suspend fun uploadFile(fileUri: Uri, storagePath: String, callback: StorageCallback?) {
        val fileRef = storageRef?.child(storagePath)
        fileRef?.putFile(fileUri)
            ?.addOnSuccessListener { taskSnapshot: UploadTask.TaskSnapshot? ->
                callback?.onSuccess(
                    result = null
                )
            }
            ?.addOnFailureListener { e: Exception -> callback?.onFailure(e.message) }
    }

    override suspend fun downloadFile(storagePath: String, callback: StorageCallback?) {
        val fileRef = storageRef?.child(storagePath)
        fileRef?.getBytes(Long.MAX_VALUE)
            ?.addOnSuccessListener { bytes: ByteArray? ->
                val fileContent = String(bytes!!, StandardCharsets.UTF_8)
                callback?.onSuccess(fileContent)
            }
            ?.addOnFailureListener { e: Exception -> callback?.onFailure(e.message) }
    }

    override val appRepository: FirebaseStorage
        get() = super.appRepository

    init {
        storage = appRepository
        storageRef = storage?.reference
    }
}


interface IPersonaRepository : IAppRepository {
    suspend fun uploadFile(fileUri: Uri, storagePath: String, callback: StorageCallback?)
    suspend fun downloadFile(storagePath: String, callback: StorageCallback?)
}