package com.wesleymartins.infogames.services;

import com.wesleymartins.infogames.dto.GameDTO;
import com.wesleymartins.infogames.dto.GameListDTO;
import com.wesleymartins.infogames.dto.GameMinDTO;
import com.wesleymartins.infogames.entities.Game;
import com.wesleymartins.infogames.entities.GameList;
import com.wesleymartins.infogames.projections.GameMinProjection;
import com.wesleymartins.infogames.repositories.GameListRepository;
import com.wesleymartins.infogames.repositories.GameRepository;
import com.wesleymartins.infogames.services.exceptions.DatabaseException;
import com.wesleymartins.infogames.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new GameDTO(result);
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    public List<GameMinDTO> findByList(Long listId){
        try {
            List<GameMinProjection> result = gameRepository.searchByList(listId);
            return result.stream().map(GameMinDTO::new).toList();
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(readOnly = false)
    public Game insert(Game entity) {
        return gameRepository.save(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        try {
            gameRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    @Transactional(readOnly = false)
    public Game update(Long id, Game obj) {
        try {
            Game entity = gameRepository.getReferenceById(id);
            updateEntity(entity, obj);
            return gameRepository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
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

    @Transactional(readOnly = false)
    public  Game updateImgUrl (Long id, Game obj){
        Game entity = gameRepository.getReferenceById(id);
        updateImgUrlMethod(entity, obj);
        return gameRepository.save(entity);
    }

    private void updateImgUrlMethod(Game entity, Game obj) {
        entity.setImgUrl(obj.getImgUrl());
    }

    @Transactional(readOnly = false)
    public Game updatePlatforms (Long id, Game obj){
        Game entity = gameRepository.getReferenceById(id);
        updatePlatformsMethod(entity, obj);
        return gameRepository.save(entity);
    }

    private void updatePlatformsMethod(Game entity, Game obj) {
        entity.setPlatforms(obj.getPlatforms());
    }
}
