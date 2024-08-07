package com.example.mkodo_app

import androidx.compose.ui.test.SemanticsNodeInteractionCollection
import androidx.compose.ui.test.assertIsDisplayed

fun SemanticsNodeInteractionCollection.assertAreDisplayed(): SemanticsNodeInteractionCollection {
    fetchSemanticsNodes().forEachIndexed { index, _ ->
        get(index).assertIsDisplayed()
    }
    return this
}