package pe.com.claro.common.util;

import javax.ws.rs.core.Configuration;

public class PropertiesExternos {  
	

	////////////////////INICIO/////////////////////////
	//------------ BD PESGAPRD ------------//
	//Extraer flujo//
	public String vBdFlujoAutomaticoNombre;
	public String vBdFlujoAutomaticoJndi;
	public String vBdFlujoAutomaticoEsquema;
	public String vBdFlujoAutomaticoPaquete;
	public String vBdFlujoAutomaticoSP;
	public String vBdFlujoAutomaticoTimeout;
	
	public int vIdTransversal;
	

	//Extraer flujo 2//
	public String vBdFlujoAutomaticoNombre2;
	public String vBdFlujoAutomaticoJndi2;
	public String vBdFlujoAutomaticoEsquema2;
	public String vBdFlujoAutomaticoPaquete2;
	public String vBdFlujoAutomaticoSP2;
	public String vBdFlujoAutomaticoTimeout2;
	
	public int vIdTransversal2;
	

	//Evalua Condicion//
	public String vBdEvaluaCondicionNombre;
	public String vBdEvaluaCondicionJndi;
	public String vBdEvaluaCondicionEsquema;
	public String vBdEvaluaCondicionPaquete;
	public String vBdEvaluaCondicionSP;
	public String vBdEvaluaCondicionTimeout;

	//Registra Transaccion//
	public String vBdRegistraTransaccionNombre;
	public String vBdRegistraTransaccionJndi;
	public String vBdRegistraTransaccionEsquema;
	public String vBdRegistraTransaccionPaquete;
	public String vBdRegistraTransaccionSP;
	public String vBdRegistraTransaccionTimeout;
	
	//Transforma Valor//
	public String vBdTransformaValorNombre;
	public String vBdTransformaValorJndi;
	public String vBdTransformaValorEsquema;
	public String vBdTransformaValorPaquete;
	public String vBdTransformaValorSP;
	public String vBdTransformaValorTimeout;
	
	
	public String OBTIENE_FLUJO_AUTOMATICO_COD_IDF0;
	public String OBTIENE_FLUJO_AUTOMATICO_MSG_IDF0;
	public String OBTIENE_FLUJO_AUTOMATICO_COD_IDF1;
	public String OBTIENE_FLUJO_AUTOMATICO_MSG_IDF1;
	public String OBTIENE_FLUJO_AUTOMATICO_COD_IDF2;
	public String OBTIENE_FLUJO_AUTOMATICO_MSG_IDF2;
	public String OBTIENE_FLUJO_AUTOMATICO_COD_IDF3;
	public String OBTIENE_FLUJO_AUTOMATICO_MSG_IDF3;
	public String OBTIENE_FLUJO_AUTOMATICO_COD_IDF4;
	public String OBTIENE_FLUJO_AUTOMATICO_MSG_IDF4;
	
	public String OBTIENE_FLUJO_AUTOMATICO_COD_IDT1;
	public String OBTIENE_FLUJO_AUTOMATICO_MSG_IDT1;
	public String OBTIENE_FLUJO_AUTOMATICO_COD_IDT2;
	public String OBTIENE_FLUJO_AUTOMATICO_MSG_IDT2;
	public String OBTIENE_FLUJO_AUTOMATICO_COD_IDT3;
	public String OBTIENE_FLUJO_AUTOMATICO_MSG_IDT3;
	public String OBTIENE_FLUJO_AUTOMATICO_COD_IDT4;
	public String OBTIENE_FLUJO_AUTOMATICO_MSG_IDT4;

	public String OBTIENE_FLUJO_AUTOMATICO_COD_IDT5;
	public String OBTIENE_FLUJO_AUTOMATICO_MSG_IDT5;
	

	//FALTA REFERENCIAR

	////////////////////FIN/////////////////////////

	
	public PropertiesExternos(Configuration configuration) {
		super();

		////////////////////INICIO/////////////////////////
		this.vBdFlujoAutomaticoNombre = ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.nombre"));
		this.vBdFlujoAutomaticoJndi = ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.jndi"));
		this.vBdFlujoAutomaticoEsquema = ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.esquema"));
		this.vBdFlujoAutomaticoPaquete = ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.paquete"));
		this.vBdFlujoAutomaticoSP = ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.sp"));
		this.vBdFlujoAutomaticoTimeout = ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.timeout"));
		
		this.vIdTransversal = Integer.parseInt(ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.idtransversal")));
		

		this.vBdFlujoAutomaticoNombre2 = ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.nombre2"));
		this.vBdFlujoAutomaticoJndi2 = ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.jndi2"));
		this.vBdFlujoAutomaticoEsquema2 = ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.esquema2"));
		this.vBdFlujoAutomaticoPaquete2 = ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.paquete2"));
		this.vBdFlujoAutomaticoSP2 = ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.sp2"));
		this.vBdFlujoAutomaticoTimeout2 = ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.timeout2"));
		
		this.vIdTransversal2 = Integer.parseInt(ClaroUtil.convertProperties(configuration.getProperty("bd.flujoautomatico.idtransversal2")));
		

		this.vBdEvaluaCondicionNombre = ClaroUtil.convertProperties(configuration.getProperty("bd.evaluacondicion.nombre"));
		this.vBdEvaluaCondicionJndi = ClaroUtil.convertProperties(configuration.getProperty("bd.evaluacondicion.jndi"));
		this.vBdEvaluaCondicionEsquema = ClaroUtil.convertProperties(configuration.getProperty("bd.evaluacondicion.esquema"));
		this.vBdEvaluaCondicionPaquete = ClaroUtil.convertProperties(configuration.getProperty("bd.evaluacondicion.paquete"));
		this.vBdEvaluaCondicionSP = ClaroUtil.convertProperties(configuration.getProperty("bd.evaluacondicion.sp"));
		this.vBdEvaluaCondicionTimeout = ClaroUtil.convertProperties(configuration.getProperty("bd.evaluacondicion.timeout"));
		
		this.vBdRegistraTransaccionNombre = ClaroUtil.convertProperties(configuration.getProperty("bd.registratransaccion.nombre"));
		this.vBdRegistraTransaccionJndi = ClaroUtil.convertProperties(configuration.getProperty("bd.registratransaccion.jndi"));
		this.vBdRegistraTransaccionEsquema = ClaroUtil.convertProperties(configuration.getProperty("bd.registratransaccion.esquema"));
		this.vBdRegistraTransaccionPaquete = ClaroUtil.convertProperties(configuration.getProperty("bd.registratransaccion.paquete"));
		this.vBdRegistraTransaccionSP = ClaroUtil.convertProperties(configuration.getProperty("bd.registratransaccion.sp"));
		this.vBdRegistraTransaccionTimeout = ClaroUtil.convertProperties(configuration.getProperty("bd.registratransaccion.timeout"));
		
		this.vBdTransformaValorNombre = ClaroUtil.convertProperties(configuration.getProperty("bd.transformavalor.nombre"));
		this.vBdTransformaValorJndi = ClaroUtil.convertProperties(configuration.getProperty("bd.transformavalor.jndi"));
		this.vBdTransformaValorEsquema = ClaroUtil.convertProperties(configuration.getProperty("bd.transformavalor.esquema"));
		this.vBdTransformaValorPaquete = ClaroUtil.convertProperties(configuration.getProperty("bd.transformavalor.paquete"));
		this.vBdTransformaValorSP = ClaroUtil.convertProperties(configuration.getProperty("bd.transformavalor.sp"));
		this.vBdTransformaValorTimeout = ClaroUtil.convertProperties(configuration.getProperty("bd.transformavalor.timeout"));
		
		this.OBTIENE_FLUJO_AUTOMATICO_COD_IDF0 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.codigo.idf0"));
		this.OBTIENE_FLUJO_AUTOMATICO_MSG_IDF0 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.mensaje.idf0"));
		this.OBTIENE_FLUJO_AUTOMATICO_COD_IDF1 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.codigo.idf1"));
		this.OBTIENE_FLUJO_AUTOMATICO_MSG_IDF1 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.mensaje.idf1"));
		this.OBTIENE_FLUJO_AUTOMATICO_COD_IDF2 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.codigo.idf2"));
		this.OBTIENE_FLUJO_AUTOMATICO_MSG_IDF2 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.mensaje.idf2"));
		this.OBTIENE_FLUJO_AUTOMATICO_COD_IDF3 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.codigo.idf3"));
		this.OBTIENE_FLUJO_AUTOMATICO_MSG_IDF3 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.mensaje.idf3"));
		this.OBTIENE_FLUJO_AUTOMATICO_COD_IDF4 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.codigo.idf4"));
		this.OBTIENE_FLUJO_AUTOMATICO_MSG_IDF4 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.mensaje.idf4"));
		
		this.OBTIENE_FLUJO_AUTOMATICO_COD_IDT1 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.codigo.idt1"));
		this.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT1 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.mensaje.idt1"));
		this.OBTIENE_FLUJO_AUTOMATICO_COD_IDT2 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.codigo.idt2"));
		this.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT2 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.mensaje.idt2"));
		this.OBTIENE_FLUJO_AUTOMATICO_COD_IDT3 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.codigo.idt3"));
		this.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT3 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.mensaje.idt3"));
		this.OBTIENE_FLUJO_AUTOMATICO_COD_IDT4 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.codigo.idt4"));
		this.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT4 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.mensaje.idt4"));
		this.OBTIENE_FLUJO_AUTOMATICO_COD_IDT5 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.codigo.idt5"));
		this.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT5 = ClaroUtil.convertProperties(configuration.getProperty("obtiene.flujo.automatico.mensaje.idt5"));
		
		////////////////////FIN/////////////////////////
		
		
	}
}