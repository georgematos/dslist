package com.devsuperior.dslist.dto;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.devsuperior.dslist.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO() {
    }

    public GameListDTO(GameList gamelist) {
        BeanUtils.copyProperties(gamelist, this);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameListDTO id(Long id) {
        setId(id);
        return this;
    }

    public GameListDTO name(String name) {
        setName(name);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GameListDTO)) {
            return false;
        }
        GameListDTO gameListDTO = (GameListDTO) o;
        return Objects.equals(id, gameListDTO.id) && Objects.equals(name, gameListDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
