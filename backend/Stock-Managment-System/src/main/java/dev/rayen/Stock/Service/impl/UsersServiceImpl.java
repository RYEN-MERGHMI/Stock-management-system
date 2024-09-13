/**
 * Made  by rayen.
 * Date: 12/09/2024.
 * Time: 09:45.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.Service.impl;

import dev.rayen.Stock.Service.UsersService;
import dev.rayen.Stock.dto.UsersDto;
import dev.rayen.Stock.exeption.EntityNotFoundException;
import dev.rayen.Stock.exeption.ErrorCodes;
import dev.rayen.Stock.exeption.InvalidEntityException;
import dev.rayen.Stock.repository.UsersRepository;
import dev.rayen.Stock.validator.UsersValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersDto save(UsersDto usersDto) {
        List<String> errors = UsersValidator.validate(usersDto);
        if (!errors.isEmpty()) {
            log.error("User is not valid {}", usersDto);
            throw new InvalidEntityException("user is not valid", ErrorCodes.USERS_NOT_VALID, errors);
        }
        return UsersDto.fromEntity(
                usersRepository.save(
                        UsersDto.toEntity(usersDto)
                )
        );
    }

    @Override
    public UsersDto findById(Integer id) {
        if (id == null) {
            log.error("user ID is null");
            return null;
        }
        return usersRepository.findById(id)
                .map(UsersDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "there is no user with ID = " + id + " found is our db",
                        ErrorCodes.USERS_NOT_FOUND)
                );
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll().stream()
                .map(UsersDto::fromEntity)
                .collect(Collectors.toList());    }

    @Override
    public void delete(Integer id) {

        if(id == null){
            log.error("user ID is null");
            return;
        }
        usersRepository.deleteById(id);

    }
}
