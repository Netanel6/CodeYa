package com.netanel.codeya.personaFeature.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.netanel.codeya.network.StorageCallback
import com.netanel.codeya.personaFeature.model.PersonaNumberProperties
import com.netanel.codeya.personaFeature.repository.PersonaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * Created by netanelamar on 25/09/2023.
 * NetanelCA2@gmail.com
 */

@HiltViewModel
class PersonaScreenViewModel @Inject constructor() : ViewModel() {
    private val repository = PersonaRepository()

    private val _firstPersonaNumber: PersonaNumberProperties by lazy { firstPersonaNumber }
    var firstPersonaNumber: PersonaNumberProperties = PersonaNumberProperties()
    private val _secondPersonaNumber: PersonaNumberProperties by lazy { secondPersonaNumber }
    var secondPersonaNumber: PersonaNumberProperties = PersonaNumberProperties()
    private val _thirdPersonaNumber: PersonaNumberProperties by lazy { thirdPersonaNumber }
    var thirdPersonaNumber: PersonaNumberProperties = PersonaNumberProperties()


    init {
        repository.downloadFile(
            "BalancedOne.txt",
            object : StorageCallback {
                override fun onSuccess(fileContent: String?) {
                    Log.i("Netanel", fileContent.toString())
                }

                override fun onFailure(message: String?) {
                    Log.i("Netanel", "onFailure: ${message.toString()}")
                }
            })
    }
}