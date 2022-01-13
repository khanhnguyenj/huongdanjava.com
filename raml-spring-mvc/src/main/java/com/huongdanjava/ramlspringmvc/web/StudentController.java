
package com.huongdanjava.ramlspringmvc.web;

import java.util.List;
import javax.validation.Valid;
import com.huongdanjava.ramlspringmvc.web.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * No description
 * (Generated with springmvc-raml-parser v.2.0.5)
 * 
 */
@RestController
@Validated
@RequestMapping("/api/students")
public interface StudentController {


    /**
     * No description
     * 
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudents();

    /**
     * No description
     * 
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createStudent(
        @Valid
        @RequestBody
        Student student);

    /**
     * No description
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(
        @PathVariable
        String id);

    /**
     * No description
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateStudent(
        @PathVariable
        String id,
        @Valid
        @RequestBody
        Student student);

    /**
     * No description
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudentById(
        @PathVariable
        String id);

}
