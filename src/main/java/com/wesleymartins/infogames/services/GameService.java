package com.wesleymartins.infogames.services;

import com.wesleymartins.infogames.dto.GameDTO;
import com.wesleymartins.infogames.dto.GameListDTO;
import com.wesleymartins.infogames.dto.GameMinDTO;
import com.wesleymartins.infogames.entities.Game;
import com.wesleymartins.infogames.entities.GameList;
import com.wesleymartins.infogames.projections.GameMinProjection;
import com.wesleymartins.infogames.repositories.GameListRepository;
import com.wesleymartins.infogames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = false)
    public Game insert(Game entity) {
        return gameRepository.save(entity);
    }

    public void delete(Long id){
        gameRepository.deleteById(id);
    }
}
