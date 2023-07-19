package com.example.examencertificacion

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.examencertificacion.vistas.ItemFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CorreoTest {

    @Test
    fun testEmailSending() {

        val bundle = Bundle().apply {
            putInt("id", 1)
        }
        val scenario: FragmentScenario<ItemFragment> = launchFragmentInContainer(
            fragmentArgs = bundle
        )


        onView(withId(R.id.botonConsultar)).perform(click())
        // Verifica que se haya iniciado la acción de enviar correo electrónico
        intended(hasAction(Intent.ACTION_SEND))
        // Verifica que el correo electrónico tenga el destinatario correcto
        intended(hasExtraWithKey(Intent.EXTRA_EMAIL))
        // Verifica que el correo electrónico tenga el asunto correcto
        intended(hasExtraWithKey(Intent.EXTRA_SUBJECT))
        // Verifica que el correo electrónico tenga el cuerpo correcto
        intended(hasExtraWithKey(Intent.EXTRA_TEXT))

 }
}