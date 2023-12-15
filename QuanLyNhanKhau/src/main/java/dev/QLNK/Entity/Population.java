package dev.QLNK.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.Collection;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Transactional
@Table(name = "populations", uniqueConstraints = @UniqueConstraint(columnNames = {"population_code", "image"}))
public class Population {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "population_id")
    private Long id;

    //Số cccd
    @Column(name = "population_code", length = 12)
    private String populationCode;

    // tên nhân khẩu
    private String populationName;

    @Column(columnDefinition = "MEDIUMBLOB")
    @Lob
    private String image;
    private String imageName;
//    public void setImage(byte[] imageFile){
//            this.image= imageFile;
//    }
//    public void setImage(MultipartFile imageFile){
//        try{
//            this.image= Base64.getEncoder().encode(imageFile.getBytes());
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//    }

    // Biệt danh nhân khẩu
    private String populationNickName;

    //Ngày sinh nhân khẩu
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dateOfBirth;

    //Giới tính nhân khẩu
    private String gender;

    // Nơi sinh nhân khẩu
    private String birthPlace;

    // dân tộc nhân khẩu
    private String ethnicity;

    // Tôn giáo nhân khẩu
    private String religion;

    // Nghề nghiệp
    private String job;

    // Quan he
    private String relationship;

    //Trang thai con song
    private boolean alive;

    //Trang thai da chet
    private boolean dead;

    // Ngay cap
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dateOfIssue;


    //Noi cap
    private String placeOfIssue;

    // Nơi làm việc
    private String workPlace;


    // Ngày vào sổ
    private String createDate;

    @Column(name = "population_booklet_code")
    private String residenceBookletCode;


    @ManyToOne
    @JoinColumn(name = "residence_booklet_code")
    private ResidenceBooklet residenceBooklet;

    @OneToMany
    @JoinColumn(name = "population_id")
    private Collection<TemporarilyAbsent> temporarilyAbsents;

    @OneToMany
    @JoinColumn(name = "population_id")
    private Collection<TemporarilyStaying> temporarilyStayings;
}
