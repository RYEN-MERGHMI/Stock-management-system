/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 09:37.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Article")
public class Article extends AbstractEntity {

    @Column(name = "ArticleCode")
    private String ArticleCode;

    @Column(name = "designation")
    private String designation;

    @Column(name = "prixUnitaireHt")
    private BigDecimal prixUnitaireHt;

    @Column(name = "tauxTva")
    private BigDecimal tauxTva;

    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaireTtc;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;

    @Column(name = "idCompany")
    private Integer idCompany;

    @OneToMany(mappedBy = "article")
    private List<SaleLine> saleLines;

    @OneToMany(mappedBy = "article")
    private List<ClientCodeLine> clientCodeLines;

    @OneToMany(mappedBy = "article")
    private List<SupplierCodeLine> supplierCodeLines;

    @OneToMany(mappedBy = "article")
    private List<StckMvmnt> stckMvmnts;

}





















