package com.example.Camisas2Act3.service

import com.example.Camisas2Act3.dto.CreatePlayerInTeam
import com.example.Camisas2Act3.dto.CreatePlayerRequest
import com.example.Camisas2Act3.models.Equipo
import com.example.Camisas2Act3.models.Jugador
import com.example.Camisas2Act3.repository.EquipoRepository
import com.example.Camisas2Act3.repository.JugadorRepository

import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull


@Service
class JugadoresService(var repo: JugadorRepository, var repoe: EquipoRepository) {

    fun addPlayer(createPlayerRequest: CreatePlayerRequest): Jugador {

        var jugador = Jugador()
        jugador.nombre = createPlayerRequest.nombre
        jugador.posicion = createPlayerRequest.posicion
        jugador.goles = createPlayerRequest.goles

        return repo.save(jugador)
    }

    fun getAllPlayers(): List<Jugador> {

        return repo.findAll()
    }
    fun getPlayerById(id:Int): Jugador? {

        return repo.findById(id).getOrNull()
    }

    fun updatePlayerById(id:Int, createPlayerRequest: CreatePlayerInTeam): Jugador? {

        val equipo = repoe.findById(createPlayerRequest.id_equipo).getOrNull()?:return null

        var jugador = repo.findById(id).getOrNull()

        if (jugador != null){
            jugador.nombre = createPlayerRequest.nombre
            jugador.posicion = createPlayerRequest.posicion
            jugador.goles = createPlayerRequest.goles
            jugador.equipo = equipo

            return repo.save(jugador)
        }else{
            return null
        }
    }

    fun deletePlayerById(id:Int): Jugador? {

        var jugador = repo.findById(id).getOrNull()
        if (jugador != null){
            repo.delete(jugador)
            return jugador
        }else{
            return null
        }
    }

    fun addJugadorAlEquipo(jugadorRequest: CreatePlayerInTeam): Jugador?{

        val equipo = repoe.findById(jugadorRequest.id_equipo).getOrNull()?:return null

        val jugador = Jugador(
            nombre = jugadorRequest.nombre,
            posicion = jugadorRequest.posicion,
            goles = jugadorRequest.goles,
            equipo = equipo
        )

        return repo.save(jugador)
    }
}