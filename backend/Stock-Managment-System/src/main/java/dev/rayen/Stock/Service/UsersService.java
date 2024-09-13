package dev.rayen.Stock.Service;

import dev.rayen.Stock.dto.UsersDto;

import java.util.List;

public interface UsersService {

    UsersDto save(UsersDto dto);

    UsersDto findById(Integer id);

    List<UsersDto> findAll();

    void delete(Integer id);
}
