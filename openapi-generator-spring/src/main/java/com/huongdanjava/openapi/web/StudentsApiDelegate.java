package com.huongdanjava.openapi.web;

import com.huongdanjava.openapi.dto.AddNewStudentResponse;
import com.huongdanjava.openapi.dto.DeleteStudentResponse;
import com.huongdanjava.openapi.dto.GetAllStudentsResponse;
import com.huongdanjava.openapi.dto.GetStudentByIdResponse;
import com.huongdanjava.openapi.dto.InlineObject;
import com.huongdanjava.openapi.dto.InlineObject1;
import com.huongdanjava.openapi.dto.Student;
import com.huongdanjava.openapi.dto.UpdateStudentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.codec.multipart.Part;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link StudentsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-28T20:23:53.641444+08:00[Asia/Singapore]", comments = "Generator version: 7.15.0")
public interface StudentsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /students : Add a new student
     *
     * @param student  (optional)
     * @return Add new student successfully (status code 200)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see StudentsApi#addNewStudent
     */
    default Mono<ResponseEntity<AddNewStudentResponse>> addNewStudent(Mono<Student> student,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"data\" : { \"code\" : 1234, \"name\" : \"Khanh\", \"id\" : 1 } }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"success\" : false, \"message\" : \"Internal Server Error\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(student).then(Mono.empty());

    }

    /**
     * DELETE /students/{id} : Delete a student by Id
     *
     * @param id Student Id (required)
     * @return Delete student information successfully (status code 200)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see StudentsApi#deleteStudentById
     */
    default Mono<ResponseEntity<DeleteStudentResponse>> deleteStudentById(String id,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"success\" : true, \"message\" : \"Student deleted!\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"success\" : false, \"message\" : \"Internal Server Error\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * GET /students : Get all students
     *
     * @param page Page number (1-based). (optional, default to 1)
     * @param size Number of items per page. (optional, default to 10)
     * @return Get all students successfully (status code 200)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see StudentsApi#getAllStudents
     */
    default Mono<ResponseEntity<GetAllStudentsResponse>> getAllStudents(Integer page,
        Integer size,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"totalItems\" : 99, \"size\" : 10, \"data\" : [ { \"code\" : 1234, \"name\" : \"Khanh\", \"id\" : 1 }, { \"code\" : 1234, \"name\" : \"Khanh\", \"id\" : 1 } ], \"totalPages\" : 10, \"page\" : 1 }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"success\" : false, \"message\" : \"Internal Server Error\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * GET /students/{id} : Get a student by Id
     *
     * @param id Student Id (required)
     * @return Get student information successfully (status code 200)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see StudentsApi#getStudentById
     */
    default Mono<ResponseEntity<GetStudentByIdResponse>> getStudentById(String id,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"data\" : { \"code\" : 1234, \"name\" : \"Khanh\", \"id\" : 1 } }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"success\" : false, \"message\" : \"Internal Server Error\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * PUT /students/{id} : Update a student
     *
     * @param id Student Id (required)
     * @param student  (optional)
     * @return Update student information successfully (status code 200)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see StudentsApi#updateStudent
     */
    default Mono<ResponseEntity<UpdateStudentResponse>> updateStudent(String id,
        Mono<Student> student,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"data\" : { \"code\" : 1234, \"name\" : \"Khanh\", \"id\" : 1 } }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"success\" : false, \"message\" : \"Internal Server Error\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(student).then(Mono.empty());

    }

}
