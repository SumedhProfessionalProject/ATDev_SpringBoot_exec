package com.sumedhahire.sumedhahire.Repos;

import com.sumedhahire.sumedhahire.POJO.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
