package pe.com.claro.postventa.dinamico.canonical.types;

import java.util.List;

import pe.com.claro.common.property.Constantes;
import pe.com.claro.postventa.dinamico.canonical.bean.Contacto;
import pe.com.claro.postventa.dinamico.canonical.bean.DescripcionCortaDetalle;

public class ItemsResponseOrdenTrabajoType implements Comparable<ItemsResponseOrdenTrabajoType> {

	private String nroOrden;
	private String tipoOrden;
	private String subTipOrden;
	private String estadoAgenda;
	private String codEstadoAgenda;
	private String fecProg;
	private String desfase;
	private String idAgenda;
	private String numeroSot;
	private String departamento;
	private String provincia;
	private String distrito;
	private String direccion;
	private String referencia;
	private String codigoFranjaHoraria;
	private String horasInicio;
	private String horasFin;
	private int posicionRuta;
	private List<Contacto> contactoCliente;
	private String nombreCliente;
	private String tipoCliente;
	private String portabilidad;
	private String planContratado;
	private String planoCodigoZona;
	private String latitud;
	private String longitud;
	private boolean flagGeolocalizado;
	private String horaInicioProgramacion;
	private String horaFinProgramacion;
	private String codigoCliente;
	private String descripcion;
	private String codigoEscenario;
	private String escenario;
	private String codigoTecnologia;
	private String tecnologia;
	private String radio;
	private String segundosTracking;
	private List<DescripcionCortaDetalle> descripcionCortaDetalle;
	
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCodigoFranjaHoraria() {
		return codigoFranjaHoraria;
	}

	public void setCodigoFranjaHoraria(String codigoFranjaHoraria) {
		this.codigoFranjaHoraria = codigoFranjaHoraria;
	}

	public String getHorasInicio() {
		return horasInicio;
	}

	public void setHorasInicio(String horasInicio) {
		this.horasInicio = horasInicio;
	}

	public String getHorasFin() {
		return horasFin;
	}

	public void setHorasFin(String horasFin) {
		this.horasFin = horasFin;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getPortabilidad() {
		return portabilidad;
	}

	public void setPortabilidad(String portabilidad) {
		this.portabilidad = portabilidad;
	}

	public String getPlanContratado() {
		return planContratado;
	}

	public void setPlanContratado(String planContratado) {
		this.planContratado = planContratado;
	}

	public String getPlanoCodigoZona() {
		return planoCodigoZona;
	}

	public void setPlanoCodigoZona(String planoCodigoZona) {
		this.planoCodigoZona = planoCodigoZona;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public boolean isFlagGeolocalizado() {
		return flagGeolocalizado;
	}

	public void setFlagGeolocalizado(boolean flagGeolocalizado) {
		this.flagGeolocalizado = flagGeolocalizado;
	}

	public String getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(String nroOrden) {
		this.nroOrden = nroOrden;
	}

	public String getTipoOrden() {
		return tipoOrden;
	}

	public void setTipoOrden(String tipoOrden) {
		this.tipoOrden = tipoOrden;
	}

	public String getSubTipOrden() {
		return subTipOrden;
	}

	public void setSubTipOrden(String subTipOrden) {
		this.subTipOrden = subTipOrden;
	}

	public String getCodEstadoAgenda() {
		return codEstadoAgenda;
	}

	public void setCodEstadoAgenda(String codEstadoAgenda) {
		this.codEstadoAgenda = codEstadoAgenda;
	}

	public String getFecProg() {
		return fecProg;
	}

	public void setFecProg(String fecProg) {
		this.fecProg = fecProg;
	}

	public String getDesfase() {
		return desfase;
	}

	public void setDesfase(String desfase) {
		this.desfase = desfase;
	}

	public String getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(String idAgenda) {
		this.idAgenda = idAgenda;
	}

	public String getNumeroSot() {
		return numeroSot;
	}

	public void setNumeroSot(String numeroSot) {
		this.numeroSot = numeroSot;
	}

	public String getEstadoAgenda() {
		return estadoAgenda;
	}

	public void setEstadoAgenda(String estadoAgenda) {
		this.estadoAgenda = estadoAgenda;
	}

	public int getPosicionRuta() {
		return posicionRuta;
	}

	public void setPosicionRuta(int posicionRuta) {
		this.posicionRuta = posicionRuta;
	}

	public List<Contacto> getContactoCliente() {
		return contactoCliente;
	}

	public void setContactoCliente(List<Contacto> contactoCliente) {
		this.contactoCliente = contactoCliente;
	}	
	
	public String getHoraInicioProgramacion() {
		return horaInicioProgramacion;
	}

	public void setHoraInicioProgramacion(String horaInicioProgramacion) {
		this.horaInicioProgramacion = horaInicioProgramacion;
	}

	public String getHoraFinProgramacion() {
		return horaFinProgramacion;
	}

	public void setHoraFinProgramacion(String horaFinProgramacion) {
		this.horaFinProgramacion = horaFinProgramacion;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEscenario() {
		return escenario;
	}

	public void setEscenario(String escenario) {
		this.escenario = escenario;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getCodigoEscenario() {
		return codigoEscenario;
	}

	public void setCodigoEscenario(String codigoEscenario) {
		this.codigoEscenario = codigoEscenario;
	}

	public String getCodigoTecnologia() {
		return codigoTecnologia;
	}

	public void setCodigoTecnologia(String codigoTecnologia) {
		this.codigoTecnologia = codigoTecnologia;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}
	
	public String getSegundosTracking() {
		return segundosTracking;
	}

	public void setSegundosTracking(String segundosTracking) {
		this.segundosTracking = segundosTracking;
	}

	public List<DescripcionCortaDetalle> getDescripcionCortaDetalle(){
		return descripcionCortaDetalle;
	}
	
	public void setDescripcionCortaDetalle(List<DescripcionCortaDetalle> descripcionCortaDetalle){
		this.descripcionCortaDetalle = descripcionCortaDetalle;
	}

	@Override
	public int compareTo(ItemsResponseOrdenTrabajoType items) {
		int salida;
		if (items.getCodEstadoAgenda().compareTo(this.codEstadoAgenda) == Constantes.CERO) {
			if (items.getFecProg().compareTo(this.fecProg) > Constantes.CERO) {
				salida = Constantes.MENOS_UNO;
			} else {
				salida = Constantes.CERO;
			}
		} else if (items.getCodEstadoAgenda().compareTo(this.codEstadoAgenda) > Constantes.CERO) {
			salida = Constantes.MENOS_UNO;
		} else {
			salida = Constantes.UNO;
		}

		return salida;
	}

}
