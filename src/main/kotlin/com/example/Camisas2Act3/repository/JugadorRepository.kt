package com.example.Camisas2Act3.repository

import com.example.Camisas2Act3.models.Jugador
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JugadorRepository:JpaRepository<Jugador,Int>