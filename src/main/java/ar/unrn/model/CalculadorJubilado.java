package ar.unrn.model;

import static java.time.LocalDate.now;
import static java.time.Month.of;
public class CalculadorJubilado extends Calculadora{
	public CalculadorJubilado(LogTransaction log, MesPromocion mesEnPromocion, double descuentoPromocion){
		super(log, mesEnPromocion, descuentoPromocion);
	}

	@Override
	protected double mesConPromocion(double precioProducto) {
		return precioProducto * descuentoPromocion + precioProducto;
	}

	@Override
	protected double mesSinPromocion(double precioProducto) {
		return precioProducto;
	}

	@Override
	public String className() {
		return CalculadorJubilado.class.getName();
	}
}
