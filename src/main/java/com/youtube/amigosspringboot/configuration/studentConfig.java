// package com.youtube.amigosspringboot.configuration;

// import java.time.LocalDate;
// import java.time.Month;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import com.youtube.amigosspringboot.model.Student;
// import com.youtube.amigosspringboot.repository.studentRepository;

// import java.util.*;

// @Configuration
// public class studentConfig {
    
//     @Bean
//     CommandLineRunner commandLineRunner(studentRepository studRepository) {
        
//         return Argument -> {
            
//             List<Student> list = new LinkedList<>();

//             Student chudier = new Student(
//                 "Chudier",
//                 "chudiercodes@gmail.com",
//                 LocalDate.of(1924, Month.MARCH, 24)
//             );
    
//             Student ather = new Student(
//                 "Ather",
//                 "athersuper@gmail.com",
//                 LocalDate.of(1965, Month.JUNE, 1)
//             );
    
//             list.add(chudier);
//             list.add(ather);

//             studRepository.saveAll(list);
//         };
//     }

// }