package com.netanel.codeya.personaFeature.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.netanel.codeya.network.StorageCallback
import com.netanel.codeya.personaFeature.model.PersonaNumberProperties
import com.netanel.codeya.personaFeature.repository.PersonaRepository
import com.netanel.codeya.utils.Logger
import com.netanel.codeya.utils.digitToWord
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by netanelamar on 25/09/2023.
 * NetanelCA2@gmail.com
 */

@HiltViewModel
class PersonaScreenViewModel @Inject constructor() : ViewModel() {
    private val repository = PersonaRepository()

    private val _personaPropertiesList: List<PersonaNumberProperties> by lazy { personaPropertiesList }
    var personaPropertiesList: List<PersonaNumberProperties> = ArrayList()

    fun downloadContent() {
        viewModelScope.launch {
            for (persona in _personaPropertiesList) {
                repository.downloadFile(persona.personaKind.name.plus(persona.personaValue?.digitToWord().toString().plus(".txt")), object: StorageCallback {
                    override fun onSuccess(result: String?) {
                        Logger.info("Netanel", "onSuccess: $result")
                    }

                    override fun onFailure(message: String?) {
                        Logger.info("Netanel", "onFailure: $message")
                    }
                })
            }
        }
    }
}