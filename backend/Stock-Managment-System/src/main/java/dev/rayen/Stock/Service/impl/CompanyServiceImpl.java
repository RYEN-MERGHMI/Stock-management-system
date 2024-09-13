/**
 * Made  by rayen.
 * Date: 12/09/2024.
 * Time: 09:44.
 * Project Name : Stck-Managment-System.
 */

package dev.rayen.Stock.Service.impl;


import dev.rayen.Stock.Service.CompanyService;
import dev.rayen.Stock.dto.CompanyDto;
import dev.rayen.Stock.repository.CompanyRepository;
import dev.rayen.Stock.repository.RolesRepository;
import dev.rayen.Stock.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional(rollbackOn = Exception.class)
@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private UsersRepository usersRepository;
    private RolesRepository rolesRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, UsersRepository usersRepository, RolesRepository rolesRepository) {
        this.companyRepository = companyRepository;
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
    }


    @Override
    public CompanyDto save(CompanyDto companyDto) {
        List<String> errors = CompanyValidator.validate(companyDto);
    }

    @Override
    public CompanyDto findById(Integer id) {
        return null;
    }

    @Override
    public List<CompanyDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }
}
