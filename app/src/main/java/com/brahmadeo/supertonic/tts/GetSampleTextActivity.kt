package com.brahmadeo.supertonic.tts

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech

/**
 * Activity that handles the android.speech.tts.engine.GET_SAMPLE_TEXT intent.
 * Android Text-to-Speech Settings calls this to retrieve the sample sentence to speak
 * when previewing the TTS engine.
 */
class GetSampleTextActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val language = intent.getStringExtra("language") ?: "en"
        val sampleText = when {
            language.startsWith("ko") -> "이것은 음성 합성의 예입니다."
            language.startsWith("es") -> "Este es un ejemplo de síntesis de voz."
            language.startsWith("fr") -> "Ceci est un exemple de synthèse vocale."
            language.startsWith("pt") -> "Este é um exemplo de síntese de voz."
            language.startsWith("de") -> "Dies ist ein Beispiel für Sprachsynthese."
            language.startsWith("ja") -> "これは音声合成の例です。"
            language.startsWith("it") -> "Questo è un exemplo di sintesi vocale."
            language.startsWith("ru") -> "Это пример синтеза речи."
            language.startsWith("zh") -> "这是语音合成的示例。"
            else -> "This is an example of speech synthesis in English."
        }

        val resultIntent = Intent().apply {
            putExtra(TextToSpeech.Engine.EXTRA_SAMPLE_TEXT, sampleText)
        }
        setResult(TextToSpeech.LANG_AVAILABLE, resultIntent)
        finish()
    }
}
