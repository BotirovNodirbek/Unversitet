package com.example.talaba.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Qorovul")
//String ism;
public class Qoravul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false,name = "ism",length =5 , columnDefinition = "TEXT")
    private String qorovulism;
    @Column(nullable = false)
    private String qorovulfam;
    @Column(nullable = false)
    private String tel;

    @OneToOne
    private  Manzil manzil;

}
