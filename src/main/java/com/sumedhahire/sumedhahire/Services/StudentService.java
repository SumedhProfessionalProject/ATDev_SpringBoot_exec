package com.sumedhahire.sumedhahire.Services;

import com.sumedhahire.sumedhahire.Exceptions.StudentNotFoundException;
import com.sumedhahire.sumedhahire.POJO.Student;
import com.sumedhahire.sumedhahire.Repos.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    //create
    public Student save(Student student){
        studentRepo.save(student);
        return student;
    }

    //read
    public Student get(Integer id){
        return studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found!"));
    }

    //update
    public Student update(Student student){
        studentRepo.save(student);
        return student;
    }

    //delete
    public void del(Integer id){
        studentRepo.deleteById(id);
    }
}
