package com.redbee.batchjobs.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "b2c_transacciones")
public class Transaccion {

    @Id
    private Long id;

    @Column(name = "codigo_postal")
    private Long codigoPostal;

    @Column(name = "id_plan")
    private Long idPlan;

    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "nro_documento")
    private String nroDocumento;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "email")
    private String email;

    @Column(name = "calle")
    private String calle;

    @Column(name = "nro_calle")
    private Long nroCalle;

    @Column(name = "piso")
    private String piso;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "cod_area")
    private String codArea;

    @Column(name = "nro_celular")
    private String nroCelular;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "dominio")
    private String dominio;

    @Column(name = "anio_moto")
    private Long anioMoto;

    @Column(name = "nro_motor")
    private String nroMotor;

    @Column(name = "nro_chasis")
    private String nroChasis;

    @Column(name = "inicio_vigencia")
    @Temporal(TemporalType.DATE)
    private Date inicioVigencia;

    @Column(name = "id_poliza")
    private Long idPoliza;

    @Column(name = "id_rama")
    private Long idRama;

    @Column(name = "id_transaccion")
    private String idTransaccion;

    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Long codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Long getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Long idPlan) {
        this.idPlan = idPlan;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Long getNroCalle() {
        return nroCalle;
    }

    public void setNroCalle(Long nroCalle) {
        this.nroCalle = nroCalle;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }

    public String getNroCelular() {
        return nroCelular;
    }

    public void setNroCelular(String nroCelular) {
        this.nroCelular = nroCelular;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public Long getAnioMoto() {
        return anioMoto;
    }

    public void setAnioMoto(Long anioMoto) {
        this.anioMoto = anioMoto;
    }

    public String getNroMotor() {
        return nroMotor;
    }

    public void setNroMotor(String nroMotor) {
        this.nroMotor = nroMotor;
    }

    public String getNroChasis() {
        return nroChasis;
    }

    public void setNroChasis(String nroChasis) {
        this.nroChasis = nroChasis;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Long getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(Long idPoliza) {
        this.idPoliza = idPoliza;
    }

    public Long getIdRama() {
        return idRama;
    }

    public void setIdRama(Long idRama) {
        this.idRama = idRama;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
