package com.litobumba.desafio_becoming_dev_1

import org.junit.Assert.assertEquals
import org.junit.Test

class UseCaseTest {

    val texto = "__ ___ ___ ___"

    @Test
    fun `Listar todos Espaços`() {
        val esperado = listOf(2, 6, 10)
        val resultado = pegarEspacos(texto)
        assertEquals(esperado, resultado)
    }

    @Test
    fun `Listar Indexs Iniciais`() {
        val esperado = listOf(0, 3, 7, 11)
        val resultado = pegarInicios(texto)
        assertEquals(esperado, resultado)
    }

    @Test
    fun `Listar Indexs Finais`() {
        val esperado = listOf(1, 5, 9, texto.length - 1)
        val resultado = pegarFins(texto)
        assertEquals(esperado, resultado)
    }

    @Test
    fun `Verificar e Mudar Texto`(){
        val esperado = "___"
        val resultado = verificarMudarTexto(texto = "EU", "___")
        assertEquals(esperado, resultado)
    }

    @Test
    fun `Mudar Texto do Ecrão com Botão 1`() {
        val esperado = "EU ___ ___ ___"
        val resultado = mudarTextoEcra(texto, 1)
        assertEquals(esperado, resultado)
    }

    @Test
    fun `Mudar Texto do Ecrão com Botão 2`() {
        val esperado = "__ VOU ___ ___"
        val resultado = mudarTextoEcra(texto, 2)
        assertEquals(esperado, resultado)
    }

    @Test
    fun `Mudar Texto do Ecrão com Botão 3`() {
        val esperado = "__ ___ SER ___"
        val resultado = mudarTextoEcra(texto, 3)
        assertEquals(esperado, resultado)
    }

    @Test
    fun `Mudar Texto do Ecrão com Botão 4`() {
        val esperado = "__ ___ ___ DEV"
        val resultado = mudarTextoEcra(texto, 4)
        assertEquals(esperado, resultado)
    }
}