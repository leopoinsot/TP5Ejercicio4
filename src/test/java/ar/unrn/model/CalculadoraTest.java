package ar.unrn.model;

import static java.time.Month.of;
import static org.junit.jupiter.api.Assertions.*;
import static java.time.LocalDate.now;
class CalculadoraTest {

	@org.junit.jupiter.api.Test
	void calcularPrecioJubiladosConPromocion() {
		var log = new LogTransaction();
		var mesPromocion = new MesPromocion(){
			@Override
			public boolean isPromocion() {
				return true;
			}
		};
		var calculadorJubilado = new CalculadorJubilado(log,mesPromocion , 0.1);
		assertEquals(1650.0f, calculadorJubilado.calcularPrecio(1500));
	}

	@org.junit.jupiter.api.Test
	void calcularPrecioJubiladosSinPromocion() {
		var log = new LogTransaction();
		var mesPromocion = new MesPromocion(){
			@Override
			public boolean isPromocion() {
				return false;
			}
		};
		var calculadorJubilado = new CalculadorJubilado(log, mesPromocion, 0.1);
		assertEquals(1500.0f,calculadorJubilado.calcularPrecio(1500));
	}

	@org.junit.jupiter.api.Test
	void calcularPrecioNoJubiladosConPromocion() {
		var log = new LogTransaction();
		var mesPromocion = new MesPromocion(){
			@Override
			public boolean isPromocion() {
				return true;
			}
		};
		var calculadorNoJubilado = new CalculadorNoJubilado(log, mesPromocion, 0.15, 0.21);
		assertEquals(115d, calculadorNoJubilado.calcularPrecio(100));
	}

	@org.junit.jupiter.api.Test
	void calcularPrecioNoJubiladosSinPromocion() {
		var log = new LogTransaction();
		var mesPromocion = new MesPromocion(){
			@Override
			public boolean isPromocion() {
				return false;
			}
		};
		var calculadorNoJubilado = new CalculadorNoJubilado(log, mesPromocion, 0.15, 0.21);
		assertEquals(121d, calculadorNoJubilado.calcularPrecio(100));
	}



}