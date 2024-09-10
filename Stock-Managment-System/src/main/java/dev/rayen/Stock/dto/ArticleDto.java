/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:13.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import dev.rayen.Stock.model.Article;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {

    private Integer id;

    private String ArticleCode;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;

    private CategoryDto category;

    private Integer idCompany;

    public static ArticleDto fromEntity(Article article) {
        if(article == null)
            return null;
        // TODO: handle exception

        return  ArticleDto.builder()
                .ArticleCode(article.getArticleCode())
                .designation(article.getDesignation())
                .tauxTva(article.getTauxTva())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .photo(article.getPhoto())
                .idCompany(article.getIdCompany())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDto articleDto) {
        if(articleDto == null) return null;
        // todo handle exception
        Article article = new Article();
       article.setId(articleDto.getId());
       article.setArticleCode(articleDto.getArticleCode());
       article.setDesignation(articleDto.getDesignation());
       article.setPhoto(articleDto.getPhoto());
       article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
       article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
       article.setTauxTva(articleDto.getTauxTva());
       article.setIdCompany(articleDto.getIdCompany());
       article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));
       return article;
    }
}
