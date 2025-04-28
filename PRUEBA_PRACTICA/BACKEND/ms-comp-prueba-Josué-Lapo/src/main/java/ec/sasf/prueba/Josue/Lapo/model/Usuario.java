package ec.sasf.prueba.Josue.Lapo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "tipo_usuario", nullable = false)
    private String tipoUsuario; // ADMIN, CREADOR, CONSUMIDOR

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fe_creacion", nullable = false)
    private Date feCreacion;

    //Recomendación: usar tipo de dato Date para fechas y horas
    // en lugar de LocalDateTime, ya que Date es más compatible con JPA y Hibernate.
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fe_actualizacion")
    private Date feActualizacion;

    @Column(nullable = false)
    private Boolean estado = true;

    // Constructores
    public Usuario() {}

    public Usuario(Long id) { // Para relaciones sin cargar el objeto completo
        this.id = id;
    }

    public Usuario(String apellidos, String email, Date feActualizacion, Date feCreacion, Long id, String nombres, String password, String tipoUsuario) {
        this.apellidos = apellidos;
        this.email = email;
        this.feActualizacion = feActualizacion;
        this.feCreacion = feCreacion;
        this.id = id;
        this.nombres = nombres;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Date getFeCreacion() {
        return feCreacion;
    }

    public void setFeCreacion(Date feCreacion) {
        this.feCreacion = feCreacion;
    }

    public Date getFeActualizacion() {
        return feActualizacion;
    }

    public void setFeActualizacion(Date feActualizacion) {
        this.feActualizacion = feActualizacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
