package com.sumedhahire.sumedhahire.Services;

import com.sumedhahire.sumedhahire.Exceptions.StudentNotFoundException;
import com.sumedhahire.sumedhahire.POJO.Student;
import com.sumedhahire.sumedhahire.Repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
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
        if(studentRepo.findById(student.getId()).isEmpty())
            throw new StudentNotFoundException("Student not found");
        studentRepo.save(student);
        return student;
    }

    //delete
    public void del(Integer id){
        studentRepo.deleteById(id);
    }

    //getAll
    public List<Student> getAll(){
        return studentRepo.findAll();
    }
}
