package com.netanel.codeya


/**
 * Created by netanelamar on 21/08/2023.
 * NetanelCA2@gmail.com
 */
sealed class Screen(val route: String) {
    data object Persona : Screen("persona_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
