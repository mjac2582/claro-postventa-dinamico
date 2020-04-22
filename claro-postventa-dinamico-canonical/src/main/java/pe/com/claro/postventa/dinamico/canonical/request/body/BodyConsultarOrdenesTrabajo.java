package pe.com.claro.postventa.dinamico.canonical.request.body;

import pe.com.claro.postventa.dinamico.canonical.request.input.ConsultarOrdenesTrabajoRequest;

public class BodyConsultarOrdenesTrabajo {
	
	private ConsultarOrdenesTrabajoRequest ordenTrabajoRequest;

	public ConsultarOrdenesTrabajoRequest getOrdenTrabajoRequest() {
		return ordenTrabajoRequest;
	}

	public void setOrdenTrabajoRequest(ConsultarOrdenesTrabajoRequest ordenTrabajoRequest) {
		this.ordenTrabajoRequest = ordenTrabajoRequest;
	}
}
