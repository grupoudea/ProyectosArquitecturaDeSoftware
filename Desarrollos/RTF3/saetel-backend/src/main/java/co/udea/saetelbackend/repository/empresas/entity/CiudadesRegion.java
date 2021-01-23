package co.udea.saetelbackend.repository.empresas.entity;

import javax.persistence.*;

@Entity
@Table(name = "ciudades_region")
public class CiudadesRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_ciudad", nullable = false)
    private Integer idCiudad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_ciudad", insertable = false, updatable = false, nullable = false)
    private Ciudad ciudad;

    @Column(name = "id_region", nullable = false)
    private Integer idRegion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_region", insertable = false, updatable = false, nullable = false)
    private Region region;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
