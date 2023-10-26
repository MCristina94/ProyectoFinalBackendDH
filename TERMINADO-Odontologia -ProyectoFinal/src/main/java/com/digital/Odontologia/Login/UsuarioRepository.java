package com.digital.Odontologia.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;


@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByUsername(String username);
}
