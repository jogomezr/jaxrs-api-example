package com.jogomezr.examples.restapi.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jogomezr.examples.restapi.domain.Student;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {

	@GET
	public List<Student> getAllStudents() {
		return Stream.of(new Student(1L, "Peter", "Griffin", 58), new Student(2L, "Peter", "Griffin", 58))
				.collect(Collectors.toList());
	}

	@GET
	@Path("/{id}")
	public Student getStudentById(@PathParam("id") Long id) {
		return new Student(id, "Peter", "Griffin", 58);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudent(Student student) {
		String message = "Student created successfully";
		return Response.status(201).entity(message).build();
	}

}
