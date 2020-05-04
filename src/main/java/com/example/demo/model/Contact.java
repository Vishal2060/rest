package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.demo.config.validation.group.OnCreate;
import com.example.demo.config.validation.group.OnUpdate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter

@NoArgsConstructor
@AllArgsConstructor

@Builder

@EqualsAndHashCode
@ToString

@Entity
@Table(name = "contact")
public class Contact {

	@Schema(description = "Unique identifier of the Contact.", example = "1", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Null(groups = OnCreate.class)
	@NotNull(groups = OnUpdate.class)
	@Column(name = "id")
	private Integer id;

	@Schema(description = "Name of the contact.", example = "Jessica Abigail", required = true)
	@NotBlank
	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@Schema(description = "Phone number of the contact.", example = "62482211", required = false)
	@Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number")
	@Size(max = 25)
	@Column(name = "phone")
	private String phone;

	@Schema(description = "Email address of the contact.", example = "jessica@ngilang.com", required = false)
	@Email(message = "Email Address")
	@Size(max = 100)
	@Column(name = "email")
	private String email;

	@Schema(description = "Address line 1 of the contact.", example = "888 Constantine Ave, #54", required = false)
	@Size(max = 50)
	@Column(name = "address1")
	private String address1;

	@Schema(description = "Address line 2 of the contact.", example = "San Angeles", required = false)
	@Size(max = 50)
	@Column(name = "address2")
	private String address2;

	@Schema(description = "Postal code of the contact.", example = "32106", required = false)
	@Size(max = 20)
	@Column(name = "postal_code")
	private String postalCode;

}
