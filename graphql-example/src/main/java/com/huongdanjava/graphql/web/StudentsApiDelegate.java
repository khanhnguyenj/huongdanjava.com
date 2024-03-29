package com.huongdanjava.graphql.web;

import com.huongdanjava.graphql.dto.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link StudentsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-27T15:23:22.901157-04:00[America/New_York]")
public interface StudentsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /students/names : Get student names
     *
     * @return Get student information (status code 200)
     * @see StudentsApi#getStudentNames
     */
    default ResponseEntity<List<String>> getStudentNames() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ \"\", \"\" ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /students : Get all students information, can be filtered by clazz name
     *
     * @param clazz Class of students (optional)
     * @return Get all students information (status code 200)
     * @see StudentsApi#getStudents
     */
    default ResponseEntity<List<Student>> getStudents(String clazz) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"code\" : \"code\", \"address\" : \"address\", \"name\" : \"name\", \"id\" : 0, \"clazz\" : \"clazz\", \"age\" : 6 }, { \"code\" : \"code\", \"address\" : \"address\", \"name\" : \"name\", \"id\" : 0, \"clazz\" : \"clazz\", \"age\" : 6 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
