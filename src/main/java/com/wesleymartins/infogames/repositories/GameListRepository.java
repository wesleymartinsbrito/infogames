package com.wesleymartins.infogames.repositories;

import com.wesleymartins.infogames.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
