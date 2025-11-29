package com.example.Camisas2Act3.controllers

import com.example.Camisas2Act3.dto.CreatePlayerInTeam
import com.example.Camisas2Act3.models.Jugador
import com.example.Camisas2Act3.dto.CreatePlayerRequest
import com.example.Camisas2Act3.service.JugadoresService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test/")
class PlayerController(var jugadoresService: JugadoresService) {


    @GetMapping( "/getAllPlayer")
    private fun getAllPlayer(): ResponseEntity<List<Jugador>> {

        var playerList = jugadoresService.getAllPlayers()
        return ResponseEntity<Jugador>.ok(playerList)
    }

    @GetMapping("/getPlayerById/{id}")
    private fun getPlayerById(@PathVariable id: Int): ResponseEntity<Jugador> {

        var jugador = jugadoresService.getPlayerById(id)

        if(jugador != null){
            return ResponseEntity<Jugador>.ok(jugador)
        }else{
            return ResponseEntity.notFound().build()
        }

    }

    @PostMapping("/addPlayer")
    private fun addplayer(@RequestBody player: CreatePlayerRequest): ResponseEntity<Jugador> {

        var jugador = jugadoresService.addPlayer(player)

        return ResponseEntity<Jugador>.ok(jugador)
    }

    @PostMapping("/addPlayer")
    private fun addplayerInTeam(@RequestBody player: CreatePlayerInTeam): ResponseEntity<Jugador> {

        var jugador = jugadoresService.addJugadorAlEquipo(player)

        return ResponseEntity<Jugador>.ok(jugador)
    }


    @PutMapping("/updatePlayer/{id}")
    private fun updateplayer(@PathVariable id: Int,@RequestBody player: CreatePlayerInTeam): ResponseEntity<Jugador> {

        var jugador = jugadoresService.updatePlayerById(id, player)

        if(jugador != null){
            return ResponseEntity<Jugador>.ok(jugador)
        }else{
            return ResponseEntity.notFound().build()
        }
    }


    @DeleteMapping("/removePlayer/{id}")
    private fun removeplayer(@PathVariable id: Int): ResponseEntity<Jugador> {

        var jugador = jugadoresService.deletePlayerById(id)

        if(jugador != null){
            return ResponseEntity<Jugador>.ok(jugador)
        }else{
            return ResponseEntity.notFound().build()
        }
    }

}


