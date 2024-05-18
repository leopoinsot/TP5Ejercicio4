package ar.unrn.model;

import static java.time.LocalDate.now;
import static java.time.Month.of;
public class CalculadorNoJubilado extends Calculadora{
	private double porcentajeSinPromocion;
	public CalculadorNoJubilado(LogTransaction log, MesPromocion mesEnPromocion, double descuentoPromocion, double porcentajeSinPromocion){
		super(log, mesEnPromocion, descuentoPromocion);
		this.porcentajeSinPromocion = porcentajeSinPromocion;
	}
	@Override
	protected double mesConPromocion(double precioProducto) {
		return precioProducto * descuentoPromocion + precioProducto;
	}
	@Override
	protected double mesSinPromocion(double precioProducto) {
		return precioProducto * porcentajeSinPromocion + precioProducto;
	}
	@Override
	public String className() {
		return CalculadorNoJubilado.class.getName();
	}
}
