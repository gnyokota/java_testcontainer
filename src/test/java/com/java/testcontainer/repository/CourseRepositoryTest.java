package com.java.testcontainer.repository;

import com.java.testcontainer.config.TestcontainerConfig;
import com.java.testcontainer.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Import(TestcontainerConfig.class)
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void saveACouseToDb(){
        assertThat(courseRepository.findAll().size()).isEqualTo(0);
        Course createdCourse =  new Course(null, "React for begginers","Programming", 119.90);
        courseRepository.save(createdCourse);
        assertThat(courseRepository.findAll().size()).isEqualTo(1);
    }

}