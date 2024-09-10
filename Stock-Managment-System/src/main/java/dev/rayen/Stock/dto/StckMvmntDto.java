/**
 * Made  by rayen.
 * Date: 18/08/2024.
 * Time: 09:19.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.dto;

import dev.rayen.Stock.model.Article;
import dev.rayen.Stock.model.SourceStckMvmnt;
import dev.rayen.Stock.model.StckMvmnt;
import dev.rayen.Stock.model.TypeMvtStk;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class StckMvmntDto {

    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantity;

    private Integer idCompany;

    private SourceStckMvmnt sourceStckMvmnt;

    private TypeMvtStk typeMvt;

    private ArticleDto article;

    public static StckMvmntDto fromEntity(StckMvmnt stckMvmnt){
        if(stckMvmnt == null){
            return null;
        }
        return StckMvmntDto.builder()
                .id(stckMvmnt.getId())
                .dateMvt(stckMvmnt.getDateMvt())
                .quantity(stckMvmnt.getQuantity())
                .idCompany(stckMvmnt.getIdCompany())
                .sourceStckMvmnt(stckMvmnt.getSourceStckMvmnt())
                .typeMvt(stckMvmnt.getTypeMvt())
                .article(ArticleDto.fromEntity(stckMvmnt.getArticle()))
                .build();
    }

    public static StckMvmnt toEntity(StckMvmntDto stckMvmntDto) {
        if(stckMvmntDto == null)  return null;

        StckMvmnt stckMvmnt = new StckMvmnt();
        stckMvmnt.setId(stckMvmntDto.getId());
        stckMvmnt.setDateMvt(stckMvmntDto.getDateMvt());
        stckMvmnt.setQuantity(stckMvmntDto.getQuantity());
        stckMvmnt.setIdCompany(stckMvmntDto.getIdCompany());
        stckMvmnt.setSourceStckMvmnt(stckMvmntDto.getSourceStckMvmnt());
        stckMvmnt.setTypeMvt(stckMvmntDto.getTypeMvt());
        stckMvmnt.setArticle(ArticleDto.toEntity(stckMvmntDto.getArticle()));

        return stckMvmnt;
    }
}
