package dev.rayen.Stock.controller.api;

import dev.rayen.Stock.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

import static dev.rayen.Stock.Utils.Constants.APP_ROOT;

public interface ArticleApi {

    @PostMapping(value = APP_ROOT +  "/articles/cre_VALUE)ate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ArticleDto save( @RequestBody ArticleDto articleDto);


    @GetMapping(value = APP_ROOT + "/articles/{idArticle}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = APP_ROOT + "/articles/{codeArticle}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value = APP_ROOT + "/articles/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    List<ArticleDto> findAll();


    @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")
    void delete(@PathVariable("idArticle") Integer id);
}
