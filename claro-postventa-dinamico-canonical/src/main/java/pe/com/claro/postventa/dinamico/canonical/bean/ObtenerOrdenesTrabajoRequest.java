package pe.com.claro.postventa.dinamico.canonical.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObtenerOrdenesTrabajoRequest {
	
	private static final Logger logger = LoggerFactory.getLogger(ObtenerOrdenesTrabajoRequest.class);
	
	private String resources;
	
	private String dateFrom;
	
	private String dateTo;
	
	private String fields;

	public String getResources() {
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public static Logger getLogger() {
		return logger;
	}
	
}
