package com.litobumba.desafio_becoming_dev_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvUnderline: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvUnderline = findViewById(R.id.tvUnderline)

        findViewById<Button>(R.id.btn1).setOnClickListener {
            tvUnderline.text = mudarTextoEcra(tvUnderline.text.toString(), 1)
        }

        findViewById<Button>(R.id.btn2).setOnClickListener {
            tvUnderline.text = mudarTextoEcra(tvUnderline.text.toString(), 2)
        }

        findViewById<Button>(R.id.btn3).setOnClickListener {
            tvUnderline.text = mudarTextoEcra(tvUnderline.text.toString(), 3)
        }

        findViewById<Button>(R.id.btn4).setOnClickListener {
            tvUnderline.text = mudarTextoEcra(tvUnderline.text.toString(), 4)
        }

    }
}

fun mudarTextoEcra(
    texto: String, botao: Int
): String {
    val indexInicios = pegarInicios(texto)
    val indexFins = pegarFins(texto)

    val textosBotao = listOf("EU", "VOU", "VIRAR", "DEV")
    var textoTemp = ""

    when (botao) {
        1 -> {
            textoTemp =
                verificarMudarTexto(
                    texto.substring(indexInicios[0], indexFins[0]),
                    textosBotao[0]
                ) + texto.substring(indexFins[0] + 1)
        }
        2 -> {
            textoTemp = texto.substring(0, indexInicios[1]) +
                    verificarMudarTexto(
                        texto.substring(indexInicios[1], indexFins[1]),
                        textosBotao[1]
                    ) +
                    texto.substring(indexFins[1] + 1)
        }
        3 -> {
            textoTemp = texto.substring(0, indexInicios[2]) +
                    verificarMudarTexto(
                        texto.substring(indexInicios[2], indexFins[2]),
                        textosBotao[2]
                    ) +
                    texto.substring(indexFins[2] + 1)
        }
        4 -> {
            textoTemp = texto.substring(0, indexInicios[3]) +
                    verificarMudarTexto(
                        texto.substring(indexInicios[3], indexFins[3]),
                        textosBotao[3]
                    ) +
                    texto.substring(indexFins[3] + 1)
        }
    }

    return textoTemp
}

fun verificarMudarTexto(texto: String, textoNovo: String = "", linha: String = "_____"): String {
    var underline = true
    texto.forEach {
        if (it.isLetter())
            underline = false
    }

    return when (underline) {
        true -> textoNovo
        false -> linha
    }
}

fun pegarEspacos(texto: String): List<Int> {
    var lista = mutableListOf<Int>()
    var index = 0

    do {
        if (texto[index].isWhitespace())
            lista.add(index)

        index++
    } while (texto.length > index)
    return lista
}

fun pegarInicios(texto: String): List<Int> {
    val inicios = mutableListOf(0)
    val espacos = pegarEspacos(texto)

    espacos.forEach { espaco ->
        if (!texto[espaco + 1].isWhitespace())
            inicios.add(espaco + 1)
    }

    return inicios
}

fun pegarFins(texto: String): List<Int> {
    val fins = mutableListOf<Int>()
    val espacos = pegarEspacos(texto)

    espacos.forEach { espaco ->
        if (!texto[espaco - 1].isWhitespace())
            fins.add(espaco - 1)
    }

    fins.add(texto.length - 1)

    return fins
}