package com.example.Camisas2Act3.models

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
data class Jugador(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    var nombre: String = "",
    var posicion: String = "",
    var goles: Int = 0,


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    var equipo: Equipo? = null
)
