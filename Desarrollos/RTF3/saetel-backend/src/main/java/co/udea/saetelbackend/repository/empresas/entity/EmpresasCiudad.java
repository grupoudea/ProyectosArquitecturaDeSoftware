package co.udea.saetelbackend.repository.empresas.entity;

import javax.persistence.*;

@Entity
@Table(name = "empresas_ciudad")
public class EmpresasCiudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_empresa", nullable = false)
    private Integer idEmpresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_empresa", insertable = false, updatable = false, nullable = false)
    private Empresa empresa;

    @Column(name = "id_ciudad", nullable = false)
    private Integer idCiudad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_ciudad", insertable = false, updatable = false, nullable = false)
    private Ciudad ciudad;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
