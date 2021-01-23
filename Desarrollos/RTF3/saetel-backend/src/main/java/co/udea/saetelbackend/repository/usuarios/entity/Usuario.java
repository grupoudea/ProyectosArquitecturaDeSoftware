package co.udea.saetelbackend.repository.usuarios.entity;

import co.udea.saetelbackend.repository.empresas.entity.Empresa;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "clave", nullable = false)
    private String clave;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "id_rol", nullable = false)
    private Integer idRol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_rol", insertable = false, updatable = false, nullable = false)
    private Rol rol;

    @Column(name = "id_empresa")
    private Integer idEmprsa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_empresa", insertable = false, updatable = false)
    private Empresa empresa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Integer getIdEmprsa() {
        return idEmprsa;
    }

    public void setIdEmprsa(Integer idEmprsa) {
        this.idEmprsa = idEmprsa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
