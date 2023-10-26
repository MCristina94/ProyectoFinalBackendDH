package com.digital.Odontologia.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="DOMICILIOS")
public class Domicilio {
    @Id
    @GeneratedValue(generator = "idDomicilio",strategy = GenerationType.SEQUENCE)
    @Column(name = "DOMICILIO_ID")
    private Long idDomicilio;
    @Column(name = "CALLE")
    private String calle;
    @Column(name = "NUMERO")
    private int numero;
    @Column(name = "CIUDAD")
    private String ciudad;
    @Column(name = "DEPARTAMENTO")
    private String departamento;


    public Domicilio() {
    }
}
