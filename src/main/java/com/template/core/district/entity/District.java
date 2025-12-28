package com.template.core.district.entity;

import com.template.core.province.entity.Province;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author diwash
 * @created 12/25/25
 */

@Entity
@Table(
        name = "district",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_district_code", columnNames = {"code"})
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class District {
    @Id
    @SequenceGenerator(name = "district_seq_gen", sequenceName = "district_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "district_seq_gen")
    private Long id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "code", nullable = false, length = 5)
    private String code;

    @ManyToOne
    @JoinColumn(name = "province_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_district_province_id"))
    private Province province;
}
