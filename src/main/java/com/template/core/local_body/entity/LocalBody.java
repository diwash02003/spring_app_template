package com.template.core.local_body.entity;

import com.template.core.district.entity.District;
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
        name = "local_body",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_local_body_code", columnNames = {"code"})
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalBody {

    @Id
    @SequenceGenerator(name = "local_body_seq_gen", sequenceName = "local_body_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "local_body_seq_gen")
    private Long id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "code", nullable = false, length = 5)
    private String code;

    @Column(name = "total_wards")
    private String totalWards;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false, foreignKey = @ForeignKey(name = "fk_local_body_district_id"))
    private District district;
}

