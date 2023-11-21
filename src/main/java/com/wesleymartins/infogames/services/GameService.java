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

    @Transactional(readOnly = false)
    public void delete(Long id){
        gameRepository.deleteById(id);
    }

    @Transactional(readOnly = false)
    public Game update(Long id, Game obj) {
    Game entity = gameRepository.getReferenceById(id);
    updateEntity(entity, obj);
    return gameRepository.save(entity);
    }

    private void updateEntity (Game entity, Game obj){
        entity.setImgUrl(obj.getImgUrl());
        entity.setScore(obj.getScore());
        entity.setPlatforms(obj.getPlatforms());
        entity.setTitle(obj.getTitle());
    }

    @Transactional(readOnly = false)
    public Game updateTitle (Long id, Game obj){
        Game entity = gameRepository.getReferenceById(id);
        updateTitleMethod(entity, obj);
        return gameRepository.save(entity);
    }

    private void updateTitleMethod(Game entity, Game obj) {
        entity.setTitle(obj.getTitle());
    }

    @Transactional(readOnly = false)
    public Game updateScore (Long id, Game obj){
        Game entity = gameRepository.getReferenceById(id);
        updateScoreMethod(entity, obj);
        return gameRepository.save(entity);
    }

    private void updateScoreMethod(Game entity, Game obj) {
        entity.setScore(obj.getScore());
    }

    public  Game updateImgUrl (Long id, Game obj){
        Game entity = gameRepository.getReferenceById(id);
        updateImgUrlMethod(entity, obj);
        return gameRepository.save(entity);
    }

    private void updateImgUrlMethod(Game entity, Game obj) {
        entity.setImgUrl(obj.getImgUrl());
    }

    public Game updatePlatforms (Long id, Game obj){
        Game entity = gameRepository.getReferenceById(id);
        updatePlatformsMethod(entity, obj);
        return gameRepository.save(entity);
    }

    private void updatePlatformsMethod(Game entity, Game obj) {
        entity.setPlatforms(obj.getPlatforms());
    }
}
