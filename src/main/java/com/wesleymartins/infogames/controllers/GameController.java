package com.wesleymartins.infogames.controllers;

import com.wesleymartins.infogames.dto.GameDTO;
import com.wesleymartins.infogames.dto.GameMinDTO;
import com.wesleymartins.infogames.entities.Game;
import com.wesleymartins.infogames.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;
    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }
    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    @PostMapping
    public ResponseEntity<Game> insert(@RequestBody Game entity){
        entity = gameService.insert(entity);
        return ResponseEntity.ok().body(entity);
    }

   @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        gameService.delete(id);
        return ResponseEntity.noContent().build();
   }

   @PutMapping(value = "/{id}")
    public ResponseEntity<Game> update (@PathVariable Long id, @RequestBody Game entity){
        entity = gameService.update(id, entity);
        return ResponseEntity.ok().body(entity);
   }

   @PutMapping(value = "/{id}/title")
    public ResponseEntity<Game> updateTitle (@PathVariable Long id, @RequestBody Game entity){
        entity = gameService.updateTitle(id, entity);
        return ResponseEntity.ok().body(entity);
   }

    @PutMapping(value = "/{id}/score")
    public ResponseEntity<Game> updateScore (@PathVariable Long id, @RequestBody Game entity){
        entity = gameService.updateScore(id, entity);
        return ResponseEntity.ok().body(entity);
    }
}
