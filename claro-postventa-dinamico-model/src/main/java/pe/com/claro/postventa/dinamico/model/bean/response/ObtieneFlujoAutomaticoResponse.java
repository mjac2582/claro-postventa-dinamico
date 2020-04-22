package pe.com.claro.postventa.dinamico.model.bean.response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.com.claro.common.bean.HeaderRequest;
import pe.com.claro.common.property.Constantes;
import pe.com.claro.common.util.ClaroUtil;
import pe.com.claro.postventa.dinamico.canonical.EjecutarFlujoAutomaticoRequest;
import pe.com.claro.postventa.dinamico.model.bean.types.CondicionesProcesosType;
import pe.com.claro.postventa.dinamico.model.bean.types.FlujoProcesosType;
import pe.com.claro.postventa.dinamico.model.bean.types.RelacionesProcesosType;


public class ObtieneFlujoAutomaticoResponse {
	
	private int idFlujo;
	private String descripcion;
	private int idTransaccion;
	private List<FlujoProcesosType> listaFlujoProcesos;
	private List<CondicionesProcesosType> listaCondicionesProcesos;
	private List<RelacionesProcesosType> listaRelacionesProcesos;
	private int codigoRespuesta;
	private String mensajeRespuesta;
	
	
	//agregar proceso comodín 0
	public List<FlujoProcesosType> agregaProcesoComodin(HeaderRequest header, EjecutarFlujoAutomaticoRequest request) throws JsonProcessingException{
		List<FlujoProcesosType> listaFlujoProcesos0 = this.listaFlujoProcesos;
		FlujoProcesosType flujoProcesosType0 = new FlujoProcesosType();
		flujoProcesosType0.setAbreviacion(Constantes.PROCESO_COMODIN);
		flujoProcesosType0.setIdProceso(Constantes.CERO);
		flujoProcesosType0.setEstado(Constantes.UNO);
		flujoProcesosType0.setReintentos(Constantes.CERO);
		flujoProcesosType0.setRequestHeader(ClaroUtil.printPrettyJSONString(header));
		flujoProcesosType0.setRequestBody(ClaroUtil.printPrettyJSONString(request));
		this.listaFlujoProcesos.add(flujoProcesosType0);
		return listaFlujoProcesos0;
	}
	
	//reemplaza FlujoProcesosType por idproceso
	public void reemplazaFlujoProcesoType(FlujoProcesosType flujoProcesosType) {
		for (int i = 0; i < this.listaFlujoProcesos.size(); i++) {
			if (flujoProcesosType.getIdProceso()==this.listaFlujoProcesos.get(i).getIdProceso()) {
				this.listaFlujoProcesos.set(i, flujoProcesosType);
			}
		}
		
	}
	
	//lista de relaciones por idproceso
	public List<RelacionesProcesosType> listaRelacionesProcesosPorIdProceso(int idProceso){
		List<RelacionesProcesosType> listRelacionesProcesos = new ArrayList<RelacionesProcesosType>();
		for (int i = 0; i < this.listaRelacionesProcesos.size(); i++) {
			if(this.listaRelacionesProcesos.get(i).getIdProcesoPost()== idProceso) {
				listRelacionesProcesos.add(listaRelacionesProcesos.get(i));
			}
		}
		return listRelacionesProcesos;
	}
	
	//lista de condiciones por idcondicion
	public List<CondicionesProcesosType> listaCondicionesProcesosByIdCondicion(int idCondicion){
		List<CondicionesProcesosType> listCondicionesProcesos = new ArrayList<CondicionesProcesosType>();
		for (int i = 0; i < this.listaCondicionesProcesos.size(); i++) {
			if(this.listaCondicionesProcesos.get(i).getIdCondicion()== idCondicion) {
				listCondicionesProcesos.add(listaCondicionesProcesos.get(i));
			}
		}
		return listCondicionesProcesos;
	}
	
	//obtener flujo proceso por idproceso
	public FlujoProcesosType obtenerFlujoProcesosTypePorIdProceso(int idProceso) {
		FlujoProcesosType flujoProcesosType = new FlujoProcesosType();
		for (int i = 0; i < this.listaFlujoProcesos.size(); i++) {
			if(this.listaFlujoProcesos.get(i).getIdProceso()== idProceso) {
				flujoProcesosType = this.listaFlujoProcesos.get(i);
			}
		}
		return flujoProcesosType;
	}
	
	//obtener flujo proceso por preproceso
	public FlujoProcesosType obtenerFlujoProcesosTypePorPreProceso(String preProceso) {
		FlujoProcesosType flujoProcesosType = new FlujoProcesosType();
		for (int i = 0; i < this.listaFlujoProcesos.size(); i++) {
			if(this.listaFlujoProcesos.get(i).getPreProceso()!=null){
				if(this.listaFlujoProcesos.get(i).getPreProceso().equals(preProceso)) {
					flujoProcesosType =  this.listaFlujoProcesos.get(i);
				}
			}
		}
		return flujoProcesosType;
	}
	
	//reemplazar texto request dinamico
		public void formatearRequest() {
			CondicionesProcesosType condicionesProcesosType = new CondicionesProcesosType();
			for (int i = 0; i < this.listaCondicionesProcesos.size(); i++) {
				condicionesProcesosType = this.listaCondicionesProcesos.get(i);
				String llaves = condicionesProcesosType.getParametro();
				String idProceso = llaves.split(Constantes.PUNTO_CARACTER)[1];
				//System.out.println(llaves);
				if (0==Integer.parseInt(idProceso)) {//hacer cambio
					//System.out.println("entra");
					//request.body. parametros.parametro.telefonia_device_identifier
					String [] listaLlaves = llaves.split(Constantes.PUNTO_CARACTER);
					llaves = listaLlaves[0]+"."+listaLlaves[1]+"."+listaLlaves[2]+"."+listaLlaves[3]+"."+reemplazaLlave(obtieneLlave(obtieneLlave(llaves)));
					condicionesProcesosType.setParametro(llaves);
					System.out.println("transformado: "+llaves);
					//request.body. parametros.20.valor
					this.listaCondicionesProcesos.set(i, condicionesProcesosType);
				}
			}
			RelacionesProcesosType relacionesProcesosType = new RelacionesProcesosType();
			for (int i = 0; i < this.listaRelacionesProcesos.size(); i++) {
				relacionesProcesosType = this.listaRelacionesProcesos.get(i);
				String llaves = relacionesProcesosType.getCampoPre();
				//System.out.println(llaves);
				int idProceso = relacionesProcesosType.getIdProcesoPre();
				if (0==idProceso) {//hacer cambio
					//System.out.println("entra");
					//proceso.0.request.body.parametros.20.valor
					String [] listaLlaves = llaves.split(Constantes.PUNTO_CARACTER);
					llaves = listaLlaves[0]+"."+listaLlaves[1]+"."+reemplazaLlave(obtieneLlave(llaves));
					relacionesProcesosType.setCampoPre(llaves);
					System.out.println("transformado: "+llaves);
					//request.body. parametros.20.valor
					this.listaRelacionesProcesos.set(i, relacionesProcesosType);
					
				}
			}
		}
		private static String obtieneLlave(String llave) {
			String [] llaves = llave.split(Constantes.PUNTO_CARACTER);
			llave = Constantes.TEXTO_VACIO;
			for (int i = 2; i < llaves.length; i++) {
				llave = llave+llaves[i];
				if(i<llaves.length-1) {
					llave=llave+Constantes.PUNTO;
				}
			}
			return llave;
		}
		public String reemplazaLlave(String llaves) {
			//parametros.20.valor
			//llaves = "parametros.parametro.telefonia_device_identifier";
			System.out.println("sin transformar: "+llaves);
			String[] listaLlaves = llaves.split(Constantes.PUNTO_CARACTER);
			FlujoProcesosType flujoProcesosType = obtenerFlujoProcesosTypePorIdProceso(0);
			String json = flujoProcesosType.getRequestBody();
			JsonParser jsonParser = new JsonParser();
		     JsonElement jsonElement = jsonParser.parse(json);
			
			JsonElement valor = getLlave(jsonElement, listaLlaves[0]);
			//System.out.println(valor.toString());
			int indParametro = -1;
			if (valor.isJsonArray()) {
				JsonArray array = valor.getAsJsonArray();
				Iterator<JsonElement> iter = array.iterator();
				int j = 0;
				while (iter.hasNext()) {
					JsonElement entrada = iter.next();
					//System.out.println(entrada.toString());
					entrada = getLlave(entrada, listaLlaves[1]);
					String parametro = entrada.getAsJsonPrimitive().getAsString();
					if (parametro.equals(listaLlaves[2])) {
						indParametro = j;
						break;
					}
					//System.out.println(entrada.getAsJsonPrimitive().getAsString());
					j++;
				}
			}
			if(indParametro>=0) {
				llaves = listaLlaves[0] + "." + indParametro + "." + "valor";
			}
			return llaves;
		}
		
		public static JsonElement getLlave(JsonElement jsonElement, String llaves) {
			String [] listaLlaves = llaves.split(Constantes.PUNTO_CARACTER);
			for (int i = 0; i < listaLlaves.length; i++) {
				if (jsonElement.isJsonObject()) {
					JsonObject jsonObject = jsonElement.getAsJsonObject();
					jsonElement = jsonObject.get(listaLlaves[i]);
					if (i+1 == listaLlaves.length) {//último nivel
						return jsonElement;
					}
				}else if(jsonElement.isJsonArray()){
					JsonArray array = jsonElement.getAsJsonArray();
			        Iterator<JsonElement> iter = array.iterator();
			        int j = 0;
			        while (iter.hasNext()) {
			            JsonElement entrada = iter.next();
			            if (listaLlaves[i].equals(Constantes.TEXTO_VACIO+j)) {
			            	jsonElement = entrada;
			            	if(i+1 == listaLlaves.length) {//último nivel
								return jsonElement;
			            	}
			            	break;
			            }
			            j++;
			        }
				}
			}
			return null;
		}
	
	/**
	 * @return the idFlujo
	 */
	public int getIdFlujo() {
		return idFlujo;
	}
	/**
	 * @param idFlujo the idFlujo to set
	 */
	public void setIdFlujo(int idFlujo) {
		this.idFlujo = idFlujo;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the idTransaccion
	 */
	public int getIdTransaccion() {
		return idTransaccion;
	}
	/**
	 * @param idTransaccion the idTransaccion to set
	 */
	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	/**
	 * @return the listaFlujoProcesos
	 */
	public List<FlujoProcesosType> getListaFlujoProcesos() {
		return listaFlujoProcesos;
	}
	/**
	 * @param listaFlujoProcesos the listaFlujoProcesos to set
	 */
	public void setListaFlujoProcesos(List<FlujoProcesosType> listaFlujoProcesos) {
		this.listaFlujoProcesos = listaFlujoProcesos;
	}
	/**
	 * @return the listaCondicionesProcesos
	 */
	public List<CondicionesProcesosType> getListaCondicionesProcesos() {
		return listaCondicionesProcesos;
	}
	/**
	 * @param listaCondicionesProcesos the listaCondicionesProcesos to set
	 */
	public void setListaCondicionesProcesos(List<CondicionesProcesosType> listaCondicionesProcesos) {
		this.listaCondicionesProcesos = listaCondicionesProcesos;
	}
	/**
	 * @return the codigoRespuesta
	 */
	public int getCodigoRespuesta() {
		return codigoRespuesta;
	}
	/**
	 * @param codigoRespuesta the codigoRespuesta to set
	 */
	public void setCodigoRespuesta(int codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	/**
	 * @return the mensajeRespuesta
	 */
	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}
	/**
	 * @param mensajeRespuesta the mensajeRespuesta to set
	 */
	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}
	public List<RelacionesProcesosType> getListaRelacionesProcesos() {
		return listaRelacionesProcesos;
	}
	public void setListaRelacionesProcesos(List<RelacionesProcesosType> listaRelacionesProcesos) {
		this.listaRelacionesProcesos = listaRelacionesProcesos;
	}
	
}