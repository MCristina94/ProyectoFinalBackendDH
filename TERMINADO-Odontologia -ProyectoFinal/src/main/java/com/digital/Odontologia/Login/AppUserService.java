package com.digital.Odontologia.Login;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Log4j2
@Service
@Transactional
public class AppUserService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AppUserService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("---------usuario-------");
        log.info(usuarioRepository.findByUsername(username));
        log.info(usuarioRepository.findByUsername(username).get().getAppUsuarioRoles());
        log.info("-----fin------");
        return usuarioRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("No se encontro usuario"));


    }

}
