package com.example.Camisas2Act3.service

import com.example.Camisas2Act3.dto.CreateEquipoRequest
import com.example.Camisas2Act3.dto.CreatePlayerRequest
import com.example.Camisas2Act3.models.Equipo
import com.example.Camisas2Act3.models.Jugador
import com.example.Camisas2Act3.repository.EquipoRepository
import com.example.Camisas2Act3.repository.JugadorRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import kotlin.jvm.optionals.getOrNull

class EquipoService(var repo: EquipoRepository, var repojugador: JugadorRepository) {

    fun addEquipo(createEquipoRequest: CreateEquipoRequest): Equipo? {

        var equipo = Equipo()

        equipo.nombre = createEquipoRequest.nombre
        equipo.estadio = createEquipoRequest.estadio
        equipo.formacion = createEquipoRequest.formacion

        return repo.save(equipo)
    }

    fun getAllEquipos(): List<Equipo> {

        return repo.findAll()
    }
    fun getEquiposById(id:Int): Equipo? {

        return repo.findById(id).getOrNull()

    }

    fun updateEquiporById(id:Int,createEquipoRequest: CreateEquipoRequest): Equipo? {

        var equipo = repo.findById(id).getOrNull()

        if (equipo != null){
            equipo.nombre = createEquipoRequest.nombre
            equipo.estadio = createEquipoRequest.estadio
            equipo.formacion = createEquipoRequest.formacion

            return repo.save(equipo)
        }else{
            return null
        }
    }

    fun deleteEquipoById(id:Int): Equipo? {

        var equipo = repo.findById(id).getOrNull()
        if (equipo != null){
            repo.delete(equipo)
            return equipo
        }else{
            return null
        }
    }

    fun assignExistingPlayerToEquipo(idEquipo: Int, idJugador: Int):Jugador? {

        val equipo = repo.findById(idEquipo).getOrNull() ?: return null
        val jugador = repojugador.findById(idJugador).getOrNull() ?: return null

        jugador.equipo = equipo
        repojugador.save(jugador)

        return jugador
    }


}