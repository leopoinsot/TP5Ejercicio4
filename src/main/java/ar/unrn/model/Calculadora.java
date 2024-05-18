package ar.unrn.model;

import static java.time.LocalDate.now;
import static java.time.Month.of;

public abstract class Calculadora {
	protected LogTransaction log;
	protected MesPromocion mesEnPromocion;
	protected double descuentoPromocion;

	public Calculadora(LogTransaction log, MesPromocion mesEnPromocion, double descuentoPromocion){
		this.log = log;
		this.mesEnPromocion = mesEnPromocion;
		this.descuentoPromocion = descuentoPromocion;
	}

	public double calcularPrecio(double precioProducto){
		double precioTotal;
		if (mesEnPromocion.isPromocion()) {
			precioTotal = mesConPromocion(precioProducto);
		} else {
			precioTotal = mesSinPromocion(precioProducto);
		}
		log.log(className());
		return precioTotal;
	}
	protected abstract double mesConPromocion(double precioProducto);
	protected abstract double mesSinPromocion(double precioProducto);
	 public abstract String className();
}
