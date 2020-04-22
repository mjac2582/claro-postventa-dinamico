package pe.com.claro.postventa.dinamico.canonical.request.body;

import pe.com.claro.postventa.dinamico.canonical.request.input.ConsultarDatosTecnicoRequest;

public class BodyConsultarDatosTecnico {
	
	private ConsultarDatosTecnicoRequest validaTecnicoRequest;

	public ConsultarDatosTecnicoRequest getValidaTecnicoRequest() {
		return validaTecnicoRequest;
	}

	public void setValidaTecnicoRequest(ConsultarDatosTecnicoRequest validaTecnicoRequest) {
		this.validaTecnicoRequest = validaTecnicoRequest;
	}

}
