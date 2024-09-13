package dev.rayen.Stock.Service;

import dev.rayen.Stock.dto.CategoryDto;

import javax.swing.*;
import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Integer id);

    CategoryDto findByCode(Spring code);

    List<CategoryDto> findAll();

    void delete(Integer id);

    CategoryDto findByCode(String code);
}
