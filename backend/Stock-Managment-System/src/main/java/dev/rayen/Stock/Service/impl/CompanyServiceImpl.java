/**
 * Made  by rayen.
 * Date: 12/09/2024.
 * Time: 09:44.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.Service.impl;


import dev.rayen.Stock.Service.CompanyService;
import dev.rayen.Stock.Service.UsersService;
import dev.rayen.Stock.dto.ArticleDto;
import dev.rayen.Stock.dto.CompanyDto;
import dev.rayen.Stock.dto.UsersDto;
import dev.rayen.Stock.exeption.EntityNotFoundException;
import dev.rayen.Stock.exeption.ErrorCodes;
import dev.rayen.Stock.exeption.InvalidEntityException;
import dev.rayen.Stock.repository.CompanyRepository;
import dev.rayen.Stock.repository.RolesRepository;
import dev.rayen.Stock.repository.UsersRepository;
import dev.rayen.Stock.validator.CompanyValidator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(rollbackOn = Exception.class)
@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private UsersService usersService;
    private RolesRepository rolesRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, UsersService usersService, RolesRepository rolesRepository) {
        this.companyRepository = companyRepository;
        this.usersService = usersService;
        this.rolesRepository = rolesRepository;
    }


    @Override
    public CompanyDto save(CompanyDto companyDto) {
        List<String> errors = CompanyValidator.validate(companyDto);
        if(!errors.isEmpty()) {
            log.error("company is not valid {}", companyDto);
            throw  new InvalidEntityException("the company is not valid",
                    ErrorCodes.COMPANY_NOT_VALID,
                    errors);
        }
        return CompanyDto.fromEntity(
                companyRepository.save(
                        CompanyDto.toEntity(companyDto)
                )
        );

    }

    @Override
    public CompanyDto findById(Integer id) {
        if (id == null) {
            log.error("Entreprise ID is null");
            return null;
        }
        return companyRepository.findById(id)
                .map(CompanyDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "no company with Id = " + id + "found in our database",
                        ErrorCodes.COMPANY_NOT_FOUND)
                );
    }

    @Override
    public List<CompanyDto> findAll() {
        return companyRepository.findAll().stream()
                .map(CompanyDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("companu id is invalid");
            return;
        }
        companyRepository.deleteById(id);
    }
}
