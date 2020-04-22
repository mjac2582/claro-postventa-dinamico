package pe.com.claro.common.bean;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ParametrosType {
	
	private String campo;
	private String valor;
	
	// *** Como usar la lista de parametros opcionales en metodos GET
	// *** http:/host:port/........?listaRequestOpcional={"campo":"campo1", "valor":"valor1"}&listaRequestOpcional={"campo":"campo2", "valor":"valor2"}
	public static ParametrosType fromString(String jsonRepresentation) {
        ObjectMapper mapper = new ObjectMapper();
        ParametrosType  o = null;
        try {
        	o = mapper.readValue(jsonRepresentation, ParametrosType.class );
        } catch (IOException e) {
        	o = null;
        }
        return o;
	}
	
	public ParametrosType() {
		super();
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
