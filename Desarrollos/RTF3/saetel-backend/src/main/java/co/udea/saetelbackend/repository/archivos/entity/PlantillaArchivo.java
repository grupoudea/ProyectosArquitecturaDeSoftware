package co.udea.saetelbackend.repository.archivos.entity;

import javax.persistence.*;

@Entity
@Table(name = "plantilla_archivo")
public class PlantillaArchivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "enlace", nullable = false)
    private String enlace;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "peso_maximo_megas", nullable = false)
    private Integer pesoMaximoMegas;

    @Column(name = "tipo_archivo", nullable = false)
    private String tipoArchivo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getPesoMaximoMegas() {
        return pesoMaximoMegas;
    }

    public void setPesoMaximoMegas(Integer pesoMaximoMegas) {
        this.pesoMaximoMegas = pesoMaximoMegas;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }
}
