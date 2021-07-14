package com.IHI.productservice.dto;

import java.time.LocalDate;

public class Product {
	private String codigo;
	private String producto;
	private String descripcion;
	private double precio;
	private int cantidad;
	private LocalDate fecha_creacion;
	private int idCategoria;
	
	public Product() {super();}

	public Product(String codigo, String producto, String descripcion, double precio, int cantidad,
			LocalDate fecha_creacion, int idCategoria) {
		super();
		this.codigo = codigo;
		this.producto = producto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fecha_creacion = fecha_creacion;
		this.idCategoria = idCategoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
}
