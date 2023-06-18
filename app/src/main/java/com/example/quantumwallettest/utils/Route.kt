package com.example.quantumwallettest.utils

import com.example.quantumwallettest.utils.Const.LOGIN_SCREEN
import com.example.quantumwallettest.utils.Const.REGISTER_SCREEN
import com.example.quantumwallettest.utils.Const.VERIFIED_SCREEN


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 12/06/23.
 */

sealed class Route(val route: String) {
    object Register : Route(REGISTER_SCREEN)
    object Login : Route(LOGIN_SCREEN)
    object Verified : Route(VERIFIED_SCREEN)
}