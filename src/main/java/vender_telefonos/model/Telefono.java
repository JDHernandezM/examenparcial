package vender_telefonos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del Telefono")
@Entity
@Table(name = "telefono")
public class Telefono {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_telefono;

	@ManyToOne
	@JoinColumn(name="id_modelo", 
		nullable = false, 
		foreignKey = @ForeignKey(name = "modeloTelefono"))
	Modelo modelo;	
	
	@ManyToOne
	@JoinColumn(name="id_marca", 
		nullable = false, 
		foreignKey = @ForeignKey(name = "marcaTelefono"))
	Marca marca;
	
	@ApiModelProperty(notes = "El precio con 2 decimales")
	@Digits(integer=10, fraction=2)
	@Column(name = "precio", nullable = false)
	Float precio;	

	@ApiModelProperty(notes = "Es el color del telefono")
	@Column(name = "color", nullable = false)
	String color;

	@ApiModelProperty(notes = "Es el espacio de almacenamiento del telefono")
	@Column(name = "espacio_almacenamiento", nullable = false)
	Integer espacio_almacenamiento;

	@ApiModelProperty(notes = "Es el camara del telefono en MP")
	@Digits(integer=10, fraction=2)
	@Column(name = "camara", nullable = false)
	Float camara;

	public Integer getId() {
		return id_telefono;
	}

	public void setId(Integer id_telefono) {
		this.id_telefono = id_telefono;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getEspacio_almacenamiento() {
		return espacio_almacenamiento;
	}

	public void setEspacio_almacenamiento(Integer espacio_almacenamiento) {
		this.espacio_almacenamiento = espacio_almacenamiento;
	}

	public Float getCamara() {
		return camara;
	}

	public void setCamara(Float camara) {
		this.camara = camara;
	}
}