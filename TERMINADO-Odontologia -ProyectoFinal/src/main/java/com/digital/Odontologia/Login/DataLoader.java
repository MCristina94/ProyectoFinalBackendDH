package com.digital.Odontologia.Login;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;

    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password1 = passwordEncoder.encode("1234");
        String password2 = passwordEncoder.encode("1234");

        //Usuarios para realizar pruebas en las vistas generadas en front
        usuarioRepository.save(new AppUser("Mauricio", "mau", "mau@gmail.com", password1, AppUsuarioRoles.ROLE_ADMIN)); //usuario admin
        usuarioRepository.save(new AppUser("Cristina", "cris", "cris@gmail.com", password2, AppUsuarioRoles.ROLE_USER)); //usuario común
    }
}
