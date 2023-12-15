package dev.QLNK.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "residence_booklet", uniqueConstraints = @UniqueConstraint(columnNames = {"residence_booklet_code", "passport_code"}))
public class ResidenceBooklet {
    // Mã hộ khẩu
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "residence_booklet_code")
    private String residenceBookletCode;



    // Mã khu vực
    @Column(name = "booklet_area")
    private String bookletArea;


    // Địa chỉ
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "passport_code")
    private String passportCode;

    // Ngày tạo sổ
    @Column(name = "create_date")
    private Date createDate;

    // Ngày chuyển
    @Column(name = "move_date")
    private Date moveDate;

    // Lý do chuyển
    @Column(name = "move_reason")
    private String moveReason;

    @OneToMany(mappedBy = "residenceBooklet")
    private Collection<Population> populations;

}
