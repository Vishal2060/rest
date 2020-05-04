package com.example.demo.repository.jpa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.repository.jpa.listener.StudentListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student")

@EntityListeners({ AuditingEntityListener.class, StudentListener.class })

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Builder
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString
public class Student extends Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer id;

	@Column(name = "student_name")
	private String name;

	@Column(name = "student_age")
	private Integer age;

	@Builder.Default
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student", orphanRemoval = true, targetEntity = Receipt.class)
	private Set<Receipt> receipts = new HashSet<>();
}