package com.sumedhahire.sumedhahire.Controller;

import com.sumedhahire.sumedhahire.Enums.Gender;
import com.sumedhahire.sumedhahire.POJO.Student;
import com.sumedhahire.sumedhahire.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class GetStudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Integer id){
        try{
            Student student= service.get(id);
            return new ResponseEntity<>(student,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    if student dounf delete it and set status ok
    or give error
     */
    @PostMapping("/del/{id}")
    public ResponseEntity<String> del(@PathVariable("id") Integer id){
        try{
            service.del(id);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> up(@PathVariable("id") Integer id,@RequestBody Student student){
        try{
            service.update(student);
            return new ResponseEntity<>("Done", HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public Student create(@RequestBody Student student){
        if(student.getGender().equals(Gender.Male))
            student.setGender(Gender.Male);
        else if (student.getGender().equals(Gender.Female)) {
            student.setGender(Gender.Female);
        }else{
            throw new RuntimeException("Gender not valid");
        }
        service.save(student);
        return student;
    }



}
