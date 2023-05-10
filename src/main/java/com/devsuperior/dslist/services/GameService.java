package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true) // não bloqueia o bando de dados para escrita
    public GameDTO findById(Long gameId) {
        return new GameDTO(repository.findById(gameId).get());
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = repository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> searchByList(Long id) {
        List<GameMinProjection> result = gameListRepository.searchByList(id);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
