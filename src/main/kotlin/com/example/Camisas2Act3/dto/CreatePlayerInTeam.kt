package com.example.Camisas2Act3.dto

data class CreatePlayerInTeam(
    val nombre: String,
    val posicion: String,
    val goles: Int,
    val id_equipo: Int)
