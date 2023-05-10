package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;



@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true) // não bloqueia o bando de dados para escrita
    public GameDTO findById(Long gameId) {
        return new GameDTO(repository.findById(gameId).get());
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> gameList = repository.findAll();
        return gameList.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
