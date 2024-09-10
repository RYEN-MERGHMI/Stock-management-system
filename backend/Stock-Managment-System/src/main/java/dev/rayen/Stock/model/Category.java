/**
 * Made  by rayen.
 * Date: 17/08/2024.
 * Time: 09:37.
 * Project Name : Stock-Managment-System.
 */

package dev.rayen.Stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Category")
public class Category  extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "designation")
    private String designation;

    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
