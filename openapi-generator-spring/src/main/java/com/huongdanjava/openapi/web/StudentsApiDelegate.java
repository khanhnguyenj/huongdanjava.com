package com.huongdanjava.openapi.web;

import com.huongdanjava.openapi.dto.AddNewStudentResponse;
import com.huongdanjava.openapi.dto.DeleteStudentResponse;
import com.huongdanjava.openapi.dto.GetAllStudentsResponse;
import com.huongdanjava.openapi.dto.GetStudentByIdResponse;
import com.huongdanjava.openapi.dto.InlineObject;
import org.springframework.lang.Nullable;
import com.huongdanjava.openapi.dto.Student;
import com.huongdanjava.openapi.dto.UpdateStudentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-04T11:28:38.966332+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.23.0")
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
    default ResponseEntity<AddNewStudentResponse> addNewStudent(Student student) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : true, \"message\" : \"message\", \"data\" : { \"id\" : 1, \"code\" : 1234, \"name\" : \"Khanh\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
    default ResponseEntity<DeleteStudentResponse> deleteStudentById(String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : true, \"message\" : \"Student deleted!\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
    default ResponseEntity<GetAllStudentsResponse> getAllStudents(Integer page,
        Integer size) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : true, \"message\" : \"message\", \"page\" : 1, \"size\" : 10, \"totalItems\" : 99, \"totalPages\" : 10, \"data\" : [ { \"id\" : 1, \"code\" : 1234, \"name\" : \"Khanh\" }, { \"id\" : 1, \"code\" : 1234, \"name\" : \"Khanh\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
    default ResponseEntity<GetStudentByIdResponse> getStudentById(String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : true, \"message\" : \"message\", \"data\" : { \"id\" : 1, \"code\" : 1234, \"name\" : \"Khanh\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
    default ResponseEntity<UpdateStudentResponse> updateStudent(String id,
        Student student) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : true, \"message\" : \"message\", \"data\" : { \"id\" : 1, \"code\" : 1234, \"name\" : \"Khanh\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
