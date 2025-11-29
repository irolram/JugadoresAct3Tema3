package com.example.Camisas2Act3.controllers

import com.example.Camisas2Act3.dto.CreateEquipoRequest
import com.example.Camisas2Act3.dto.CreatePlayerRequest
import com.example.Camisas2Act3.models.Equipo
import com.example.Camisas2Act3.models.Jugador
import com.example.Camisas2Act3.service.EquipoService
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

class EquipoController(var equipoService: EquipoService) {

    @GetMapping( "/getAllEquipo")
    private fun getAllEquipo(): ResponseEntity<List<Equipo>> {

        var equipoList = equipoService.getAllEquipos()
        return ResponseEntity<Jugador>.ok(equipoList)
    }

    @GetMapping("/getEquipoById/{id}")
    private fun getEquipoById(@PathVariable id: Int): ResponseEntity<Equipo> {

        var equipo = equipoService.getEquiposById(id)

        if(equipo != null){
            return ResponseEntity<Equipo>.ok(equipo)
        }else{
            return ResponseEntity.notFound().build()
        }

    }


    @PostMapping("/addEquipo")
    private fun addEquipo(@RequestBody team: CreateEquipoRequest): ResponseEntity<Equipo> {

        var equipo = equipoService.addEquipo(team)

        if(equipo != null){
            return ResponseEntity<Jugador>.ok(equipo)
        }else{
            return ResponseEntity.notFound().build()
        }
    }


    @PutMapping("/updateEquipo/{id}")
    private fun updateEquipo(@PathVariable id: Int,@RequestBody team: CreateEquipoRequest): ResponseEntity<Equipo> {

        var equipo = equipoService.updateEquiporById(id, team)

        if(equipo != null){
            return ResponseEntity<Jugador>.ok(equipo)
        }else{
            return ResponseEntity.notFound().build()
        }
    }


    @DeleteMapping("/removeEquipo/{id}")
    private fun removeEquipo(@PathVariable id: Int): ResponseEntity<Equipo> {

        var equipo = equipoService.deleteEquipoById(id)

        if(equipo != null){
            return ResponseEntity<Jugador>.ok(equipo)
        }else{
            return ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/assignExistingPlayerToEquipo")
    private fun assignExistingPlayerToEquipo(@PathVariable id_jugador: Int, @PathVariable id_equipo: Int): ResponseEntity<Jugador> {

        var jugador = equipoService.assignExistingPlayerToEquipo(id_jugador, id_equipo)

        if(jugador != null){
            return ResponseEntity<Jugador>.ok(jugador)
        }else{
            return ResponseEntity.notFound().build()

        }
    }
}