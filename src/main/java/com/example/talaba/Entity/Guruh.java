package com.example.talaba.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Guruh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)

    private String guruhnomi;
    @OneToOne
    Fakultet fakultet;
    @ManyToMany
    List<Fanlar> fanlarList;
    @OneToMany
    List<Talaba>talabaList;
}
