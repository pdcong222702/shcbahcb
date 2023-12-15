package dev.QLNK.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// Tạm trú

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemporarilyStaying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "population_id")
    // mã nhân khẩu
    private Long populationID;

    // mã giấy tạm trú
    @Column(nullable = false, unique = true)
    private String documentCode;

    // số điện thoại đăng kí
    @Column(nullable = false, unique = true)
    private String numberPhone;

    // từ ngày
    @Column(nullable = false)
    private Date fromDate;

    // đến ngày
    @Column(nullable = false)
    private Date toDate;

    // lý do
    @Column(nullable = false)
    private String reason;


    @ManyToOne
    @JoinColumn(name = "population_id", insertable = false, updatable = false)
    private Population population;
}
