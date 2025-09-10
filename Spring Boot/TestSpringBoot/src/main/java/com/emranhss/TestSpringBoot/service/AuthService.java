package com.emranhss.TestSpringBoot.service;


import com.emranhss.TestSpringBoot.entity.Role;
import com.emranhss.TestSpringBoot.entity.Student;
import com.emranhss.TestSpringBoot.entity.Token;
import com.emranhss.TestSpringBoot.entity.User;
import com.emranhss.TestSpringBoot.jwt.JwtService;
import com.emranhss.TestSpringBoot.repository.IStudentRepo;
import com.emranhss.TestSpringBoot.repository.IUserRepo;
import com.emranhss.TestSpringBoot.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IStudentRepo studentRepo;

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private  StudentService studentService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private TokenRepository tokenRepository;




    public void registerStudent(User user, Student student) {


        // Encode password before saving User
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.STUDENT);
        user.setActive(true);

        // Save User FIRST and get persisted instance
        User savedUser = userRepo.save(user);

        // Now, associate saved User with JobSeeker and save JobSeeker
        student.setUser(savedUser);
        studentService.save(student);

        // Now generate token and save Token associated with savedUser
        String jwt = jwtService.generateToken(savedUser);
        saveUserToken(jwt, savedUser);

        // Send Activation Email
        //sendActivationEmail(savedUser);
    }



    private void saveUserToken(String jwt, User user) {
        Token token = new Token();
        token.setToken(jwt);
        token.setLogout(false);
        token.setUser(user);

        tokenRepository.save(token);

    }


}
