package com.example.demo.repository.jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "receipt")

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Builder
@EqualsAndHashCode(of = "id")
@ToString
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_id")
    private Integer id;

    @Column(name = "receipt_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "receipt_amount")
    private Integer amount;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            targetEntity = Student.class)
    @JoinColumn(name = "student_id_fk", referencedColumnName = "student_id",
            updatable = false, nullable = false,
            foreignKey = @ForeignKey(name = "student_receipt_relation"))
    private Student student;
}
