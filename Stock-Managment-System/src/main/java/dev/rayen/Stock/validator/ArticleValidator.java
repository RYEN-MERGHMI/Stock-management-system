/**
 * Made  by rayen.
 * Date: 10/09/2024.
 * Time: 10:11.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.validator;

import dev.rayen.Stock.dto.ArticleDto;
import dev.rayen.Stock.dto.UsersDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto articleDto) {
        List<String> errors = new ArrayList<>();

        if(articleDto == null) {
            errors.add("reenter the article code ");
            errors.add("reenter the designation of the article ");
            errors.add("reenter the price of the article ");
            errors.add("reenter the tauxTva of the article ");
            errors.add("reenter the ttc price of the article ");
            errors.add("select a category ");
            return errors;
        }

        if(!StringUtils.hasLength(articleDto.getArticleCode())) {
            errors.add("reenter the article code ");
        }
        if(!StringUtils.hasLength(articleDto.getDesignation())) {
            errors.add("reenter the designation of the article ");
        }
        if(articleDto.getPrixUnitaireHt() == null) {
            errors.add("reenter the  price of the article ");
        }
        if(articleDto.getTauxTva() == null) {
            errors.add("reenter the tauxTva of the article ");
        }
        if(articleDto.getPrixUnitaireTtc() == null) {
            errors.add("reenter the ttc price of the article ");
        }
        if(articleDto.getCategory() == null) {
            errors.add("select a category ");
        }
        return errors;

    }
}
