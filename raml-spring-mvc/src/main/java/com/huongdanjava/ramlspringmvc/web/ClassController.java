
package com.huongdanjava.ramlspringmvc.web;

import java.util.List;
import javax.validation.Valid;
import com.huongdanjava.ramlspringmvc.web.model.Clazz;
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
@RequestMapping("/api/classes")
public interface ClassController {


    /**
     * No description
     * 
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Clazz>> getClazzs();

    /**
     * No description
     * 
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createClazz(
        @Valid
        @RequestBody
        Clazz clazz);

    /**
     * No description
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Clazz> getClazzById(
        @PathVariable
        String id);

    /**
     * No description
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateClazz(
        @PathVariable
        String id,
        @Valid
        @RequestBody
        Clazz clazz);

    /**
     * No description
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClassCustomById(
        @PathVariable
        String id);

    /**
     * No description
     * 
     */
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<Clazz> getClazz();

}
