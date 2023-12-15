package dev.QLNK.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// Tạm vắng
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TemporarilyAbsent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "population_id")
    // mã nhân khẩu
    private Long populationID;

    // mã giấy tạm vắng
    @Column(name = "document_code", unique = true, nullable = false)
    private String documentCode;

    // địa chỉ tạm trú
    @Column(nullable = false)
    private String currentAddress;

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
