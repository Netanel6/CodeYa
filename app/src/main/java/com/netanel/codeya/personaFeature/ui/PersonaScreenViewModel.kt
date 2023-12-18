package com.netanel.codeya.personaFeature.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.netanel.codeya.PersonaNumberProperties
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * Created by netanelamar on 25/09/2023.
 * NetanelCA2@gmail.com
 */

@HiltViewModel
class PersonaScreenViewModel @Inject constructor() : ViewModel() {

    lateinit var firstPersonaNumber: PersonaNumberProperties
    lateinit var secondPersonaNumber: PersonaNumberProperties
    lateinit var thirdPersonaNumber: PersonaNumberProperties

    init {

    }


    fun getData(){
        Log.i("Netanel", "getData: $firstPersonaNumber, $secondPersonaNumber, $thirdPersonaNumber")
    }
}