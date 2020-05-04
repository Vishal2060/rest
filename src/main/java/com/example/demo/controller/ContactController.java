package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.config.validation.group.OnCreate;
import com.example.demo.config.validation.group.OnUpdate;
import com.example.demo.model.Contact;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(value = "contact", produces = { "application/json", "application/xml" }, consumes = {
		"application/json", "application/xml" })
@ResponseBody
@Tag(name = "contact", description = "Contact API")
@Validated
@ApiResponses(value = { @ApiResponse(responseCode = "400", description = "Bad Request"),
		@ApiResponse(responseCode = "401", description = "Unauthorized Error"),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Resource Not Found"),
		@ApiResponse(responseCode = "409", description = "Conflict"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error"),
		@ApiResponse(responseCode = "503", description = "Service Unavailable") })
public interface ContactController {

	@Operation(summary = "Find All Contacts", description = "Find All Contacts")
	@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class))))
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Contact> findAll(
			@Parameter(description = "Page Number, default is 1") @RequestParam(value = "page", defaultValue = "1") Integer page,
			@Parameter(description = "Page Size, default is 5") @RequestParam(value = "size", defaultValue = "5") Integer size);

	@Operation(summary = "Find contact by ID", description = "Returns a single contact")
	@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Contact.class)))
	@GetMapping(value = "{id}")
	@ResponseStatus(HttpStatus.OK)
	public Contact findById(
			@Parameter(description = "Id of the contact to be obtained. Cannot be empty.", required = true) @PathVariable("id") Integer id);

	@Operation(summary = "New Contact", description = "Add a new contact")
	@ApiResponse(responseCode = "201", description = "Contact created", content = @Content(schema = @Schema(implementation = Contact.class)))
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Contact add(
			@Parameter(description = "Contact to add. Cannot null or empty.", required = true, schema = @Schema(implementation = Contact.class)) @Validated(OnCreate.class) @RequestBody Contact contact);

	@Operation(summary = "Update Contact", description = "Update an existing contact")
	@ApiResponse(responseCode = "204", description = "No Content")
	@PutMapping(value = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(
			@Parameter(description = "Id of the contact to be update. Cannot be empty.", required = true) @PathVariable("id") Integer id,
			@Parameter(description = "Contact to update. Cannot null or empty.", required = true, schema = @Schema(implementation = Contact.class)) @Validated(OnUpdate.class) @RequestBody Contact contact);

	@Operation(summary = "Delete Contact", description = "Deletes a contact")
	@ApiResponse(responseCode = "204", description = "No Content")
	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(
			@Parameter(description = "Id of the contact to be delete. Cannot be empty.", required = true) @PathVariable("id") Integer id);
}
