package com.netanel.codeya

import com.netanel.codeya.personaFeature.ui.PersonaKind


/**
 * Created by netanelamar on 18/12/2023.
 * NetanelCA2@gmail.com
 */
data class PersonaNumberProperties(
    val personaKind: PersonaKind = PersonaKind.None,
    var personaValue: String = "0"
)