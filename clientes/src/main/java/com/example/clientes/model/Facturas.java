package com.example.clientes.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Factura_detalle")
public class Facturas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idFactura;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "importe")
	private int importe;

	@ManyToOne
	@JoinColumn(name = "pagado", nullable = false)
	private boolean pagado;

	public Facturas() {

	}

	public Facturas(String descripcion, int importe, boolean pagado) {

		this.descripcion = descripcion;
		this.importe = importe;
		this.pagado = pagado;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (!(o instanceof Facturas)) {
			return false;
		}
		Facturas that = (Facturas) o;
		return getIdFactura() == that.getIdFactura() && getImporte() == that.getImporte()
				&& Objects.equals(getDescripcion(), that.getDescripcion());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getIdFactura(), getDescripcion(), getImporte());
	}

	@Override
	public String toString() {

		return "Factura{" + "id=" + idFactura + '\'' + ", descripcion='" + descripcion + '\'' + ", orden=" + importe
				+ '}';
	}

	public long getIdFactura() {

		return idFactura;
	}

	public void setIdFactura(long idFactura) {

		this.idFactura = idFactura;
	}

	public String getDescripcion() {

		return descripcion;
	}

	public void setDescripcion(String descripcion) {

		this.descripcion = descripcion;
	}

	public int getImporte() {

		return importe;
	}

	public void setOrden(int importe) {

		this.importe = importe;
	}

	public boolean getTutorial() {

		return pagado;
	}

	public void setTutorial(boolean pagado) {

		this.pagado = pagado;
	}
}