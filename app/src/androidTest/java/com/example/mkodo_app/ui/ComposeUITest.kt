package com.example.mkodo_app.ui

import androidx.activity.compose.setContent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mkodo_app.assertAreDisplayed
import com.example.mkodo_app.presentation.MainActivity
import com.example.mkodo_app.presentation.drawsList.DrawListScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ComposeUITest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testIfDetailsBtnIsDisplayed() {
        composeRule.activity.setContent { DrawListScreen(onButtonClick = {}) }
        composeRule.onAllNodesWithText("Draw Details").assertAreDisplayed()
    }

    @Test
    fun testIfBtnIsClickable(){
        composeRule.activity.setContent { DrawListScreen(onButtonClick = {}) }
        composeRule.onAllNodesWithText("Draw Details")[0].performClick()
    }
}



