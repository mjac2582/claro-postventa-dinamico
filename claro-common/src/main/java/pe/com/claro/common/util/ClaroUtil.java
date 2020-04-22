package pe.com.claro.common.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.HttpHeaders;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import pe.com.claro.common.bean.HeaderRequest;
import pe.com.claro.common.property.Constantes;

public class ClaroUtil {

	private static final Logger LOG = LoggerFactory.getLogger(ClaroUtil.class);

	public static String getAllHttpHeaders(HttpHeaders httpHeaders) {
		StringBuffer data = new StringBuffer();

		Set<String> headerKeys = httpHeaders.getRequestHeaders().keySet();
		for (String header : headerKeys) {
			data.append(header + ":" + httpHeaders.getRequestHeader(header).get(Constantes.CERO) + "\n");
		}
		return data.toString().trim();
	}

	public static String getHttpHeaders(HeaderRequest headerRequest) {

		if (headerRequest.getAccept() == null)
			return null;
		if (headerRequest.getIdTransaccion() == null)
			return null;
		if (headerRequest.getMsgid() == null)
			return null;
		if (headerRequest.getTimestamp() == null)
			return null;
		if (headerRequest.getUserId() == null)
			return null;

		String idTransaccion = headerRequest.getIdTransaccion() != null ? headerRequest.getIdTransaccion()
				: Constantes.TEXTO_VACIO;
		String msgid = headerRequest.getMsgid() != null ? headerRequest.getMsgid() : Constantes.TEXTO_VACIO;
		String timestamp = headerRequest.getTimestamp() != null ? headerRequest.getTimestamp() : Constantes.TEXTO_VACIO;
		String userId = headerRequest.getUserId() != null ? headerRequest.getUserId() : Constantes.TEXTO_VACIO;
		String accept = headerRequest.getAccept() != null ? headerRequest.getAccept() : Constantes.TEXTO_VACIO;

		StringBuffer data = new StringBuffer();
		data.append(Constantes.CORCHETE_INI + Constantes.SALTO_LINEA);
		data.append(Constantes.TABULAR + Constantes.IDTRANSACCION + Constantes.IGUAL);
		data.append(idTransaccion + Constantes.SALTO_LINEA);
		data.append(Constantes.TABULAR + Constantes.MSGID + Constantes.IGUAL);
		data.append(msgid + Constantes.SALTO_LINEA);
		data.append(Constantes.TABULAR + Constantes.TIMESTAMP + Constantes.IGUAL);
		data.append(timestamp + Constantes.SALTO_LINEA);
		data.append(Constantes.TABULAR + Constantes.USERID + Constantes.IGUAL);
		data.append(userId + Constantes.SALTO_LINEA);
		data.append(Constantes.TABULAR + Constantes.ACCEPT + Constantes.IGUAL);
		data.append(accept + Constantes.SALTO_LINEA);
		data.append(Constantes.CORCHETE_FIN);

		return data.toString();
	}

	public static String getAllProperties(Configuration configuration) {

		StringBuffer data = new StringBuffer();
		Set<String> properties = configuration.getProperties().keySet();
		for (String prop : properties) {
			data.append(prop + ":" + configuration.getProperty(prop).toString() + "\n");
		}
		return data.toString().trim();
	}

	public static String nuloAVacio(Object object) {

		if (object == null) {
			return Constantes.TEXTO_VACIO;
		} else {
			return object.toString();
		}
	}

	public static Object nuloAVacioObject(Object object) {
		if (object == null) {
			return Constantes.TEXTO_VACIO;
		} else {
			return object;
		}
	}

	public static String verifiyNull(Object object) {
		String a = null;
		if (object != null) {
			a = object.toString();
		}
		return a;
	}

	public static String convertProperties(Object object) {
		String a = null;
		if (object != null) {
			a = object.toString();
			try {
				a = new String(a.getBytes(Constantes.defaulEncodingProperties), Constantes.defaulEncodingApi);
			} catch (Exception e) {
				LOG.error("Error getProperties Encoding Failed, trayendo Encoding por defecto", e);
			}
		}
		return a;
	}

	public static Integer convertirInteger(Object object) {

		Integer res = null;
		if (object != null) {
			if (object instanceof BigDecimal) {
				BigDecimal bd = (BigDecimal) object;
				res = bd.intValueExact();
			} else {
				System.out.println(object.getClass().getSimpleName());
			}
		}
		return res;
	}

	public static Float convertirFloat(Object object) {
		Float res = null;
		if (object != null) {
			if (object instanceof BigDecimal) {
				BigDecimal bd = (BigDecimal) object;
				res = bd.floatValue();
			}
		}
		return res;
	}

	/**
	 * Genera un String a partir de un Date, si fecha es NULL retorna "" (vacio).
	 *
	 * @param fecha tipo Date
	 * @return String de la forma dd/MM/yyyy
	 */
	public static String dateAString(Date fecha) {
		if (fecha == null) {
			return Constantes.TEXTO_VACIO;
		}
		return dateAString(fecha, Constantes.FORMATO_FECHA_DEFAULT);
	}

	/**
	 * Genera un String a partir de un Date de acuerdo al fomrato enviado, si fecha
	 * es NULL toma la fecha actual.
	 *
	 * @param fecha
	 * @param formato
	 * @return
	 */
	public static String dateAString(Date fecha, String formato) {
		SimpleDateFormat formatoDF = new SimpleDateFormat(formato, Locale.getDefault());
		return formatoDF.format(fecha);
	}

	public static String parseoFecha(String fecha, String formartoIn, String formatoParseo) {
		// Parseo
		SimpleDateFormat parseador = new SimpleDateFormat(formartoIn);
		// Formateo
		SimpleDateFormat formateador = new SimpleDateFormat(formatoParseo);

		Date date = null;
		String fechaParseo = null;
		try {

			date = parseador.parse(fecha);
			fechaParseo = formateador.format(date);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return fechaParseo;
	}

	public static Date getDateFromString(String dateString) {

		Date date = (Date) Constantes.NULO;

		if (dateString != null && !dateString.isEmpty()) {
			try {
				DateFormat df = new SimpleDateFormat(Constantes.FORMATO_FECHA_iso8601);
				date = df.parse(dateString);
				if (!dateString.equals(df.format(date))) {
					date = null;
				}
			} catch (ParseException ex) {
				date = null;
			}
		}

		return date;
	}

	public static Calendar toCalendar(final String iso8601string) {
		Calendar calendar = GregorianCalendar.getInstance();
		try {
			boolean exito = false;
			String s = iso8601string.replace("Z", "+00:00");
			if (iso8601string.length() == Constantes.VEINTE) { // *** Sin Precision de Milisegundos
				s = s.substring(0, 22) + s.substring(23);
				Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault()).parse(s);
				calendar.setTime(date);
				exito = true;
			}
			if (iso8601string.length() == Constantes.VEINTICUATRO) { // *** Con Precision de Milisegundos
				s = s.substring(0, 26) + s.substring(27);
				Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(s);
				calendar.setTime(date);
				exito = true;
			}
			if (!exito) {
				calendar = null;
			}
		} catch (IndexOutOfBoundsException e) {
			LOG.error("Ocurrio un error al recorrer la cadena de Fecha", e);
			calendar = null;
		} catch (ParseException e) {
			LOG.error("Ocurrio un error al convertir a Date la cadena de la fecha", e);
			calendar = null;
		}
		return calendar;
	}

	public static boolean isValidFormat(String format, String value) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException ex) {
			date = null;
		}
		return date != null;
	}

	public static Date getValidFormatDate(String format, String value) {
		Date date = null;
		if (value != null && !value.isEmpty()) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
				date = sdf.parse(value);
				if (!value.equals(sdf.format(date))) {
					date = null;
				}
			} catch (ParseException ex) {
				date = null;
			}
		}
		return date;
	}

	public static String getStoredProcedureByParameters(Object owner, Object packg, Object name) {
		StringBuffer storedProcedure = new StringBuffer();
		if (owner != null && !owner.toString().isEmpty()) {
			storedProcedure.append(owner.toString());
			storedProcedure.append(Constantes.PUNTO);
		}
		if (packg != null && !packg.toString().isEmpty()) {
			storedProcedure.append(packg.toString());
			storedProcedure.append(Constantes.PUNTO);
		}
		if (name != null && !name.toString().isEmpty()) {
			storedProcedure.append(name.toString());
		}
		return storedProcedure.toString();
	}

	public static String getExceptionToMensaje(Exception e) {
		String msg = Constantes.TEXTO_VACIO;
		if (e.getCause() != null) {
			msg = e.getCause().toString();
		} else {
			msg = e.toString();
		}
		return msg;
	}

	public static Float floatParse(String object) {
		if (object != null && !object.isEmpty()) {
			return Float.parseFloat(object);
		}
		return null;
	}

	public static String getStoredProcedureJDBC(String sp, int parameters) {
		StringBuilder call = new StringBuilder();
		call.append("call ");
		call.append(sp);
		call.append(Constantes.PARENTESIS_INI);
		for (int i = 0; i < parameters; i++) {
			call.append(Constantes.CHAR_INTERROGACION);
			if (i + 1 < parameters)
				call.append(Constantes.CHAR_COMA);
		}
		call.append(Constantes.PARENTESIS_FIN);
		return call.toString();
	}

	public static DateFormat getLocalFormat() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		dateFormat.setTimeZone(TimeZone.getDefault());
		return dateFormat;
	}

	public static String printPrettyJSONString(Object o) throws JsonProcessingException {
		return new ObjectMapper().setDateFormat(ClaroUtil.getLocalFormat())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writerWithDefaultPrettyPrinter()
				.writeValueAsString(o);
	}

	public static String printJSONString(Object o) {
		try {
			return new ObjectMapper().setDateFormat(ClaroUtil.getLocalFormat())
					.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writeValueAsString(o);
		} catch (JsonProcessingException e) {
			return Constantes.TEXTO_VACIO;
		}
	}

	public static boolean validarFechaExpiracion(String fecha) {
		try {
			String fechaActual = new SimpleDateFormat(Constantes.DD_MM_YYYY, Locale.getDefault()).format(new Date());
			Date dateExp = new SimpleDateFormat(Constantes.DD_MM_YYYY, Locale.getDefault()).parse(fecha);
			Date dateAct = new SimpleDateFormat(Constantes.DD_MM_YYYY, Locale.getDefault()).parse(fechaActual);

			if (dateExp.after(dateAct) || dateExp.compareTo(dateAct) == 0)
				return true;

			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static Double getDouble(Object valor) {
		try {
			return Double.valueOf(valor.toString());
		} catch (Exception e) {
			return new Double(0);
		}
	}

	public static Date convertirStringADate(String fecha, String formato) {

		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat(formato);

			Date fechaFormateada = formatoFecha.parse(fecha);

			return fechaFormateada;
		} catch (Exception e) {

			return null;
		}
	}

	public static double redondear(Object valor) {
		double dblValor = Double.parseDouble(valor.toString());
		return (double) Math.round(dblValor * 10) / 10;
	}

	public static String decimalesCadenasRound(Double valor) {
		valor = (double) Math.round(valor * 100) / 100.0;
		DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.US);
		DecimalFormat decimalFormat = new DecimalFormat("###0.00", simbolos);
		return decimalFormat.format(valor);
	}

	public static Date modificarFecha(Date fecha, int campo, int cantidad) {
		try {
			Calendar fechaFinal = Calendar.getInstance();
			fechaFinal.setTime(fecha);
			fechaFinal.add(campo, cantidad);
			return fechaFinal.getTime();
		} catch (Exception e) {
			return fecha;
		}
	}

	public static String dateToString(Date fecha, String formato) {
		try {
			return new SimpleDateFormat(formato, Locale.getDefault()).format(fecha);
		} catch (Exception e) {
			return Constantes.TEXTO_VACIO;
		}
	}

	public static String longADateString(Long fecha, String formato) {

		Date date = new Date(fecha);
		SimpleDateFormat df2 = new SimpleDateFormat(formato);
		String dateText = df2.format(date);

		return dateText;
	}

	public static boolean existStringSplitValue(String[] array, String value) {
		boolean existe = false;
		if (array != null) {
			for (String val : array) {
				if (val.equals(value)) {
					existe = true;
					break;
				}
			}
		}
		return existe;
	}

	public static Date stringToJavaDateLegado(String sDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat(Constantes.FORMATO_FECHA_DEFAULT, new Locale("es", "ES")).parse(sDate);
		} catch (ParseException e) {
			date = null;
		}
		return date;
	}

	public HashMap<String, String> obtenerMapConfiguracion(String cadenaValores, String delimitadorRegistros) {
		HashMap<String, String> mapConfiguracion = new HashMap<>();
		try {
			String strRegistros = cadenaValores;
			if (strRegistros != null && !strRegistros.isEmpty()) {
				String[] arrayRegistros = strRegistros.split(delimitadorRegistros);
				for (int i = 0; i < arrayRegistros.length; i++) {
					mapConfiguracion.put(arrayRegistros[i], arrayRegistros[i]);
				}
			}
		} catch (Exception e) {
			LOG.error("Error al obtener el Map de Configuracion: [" + cadenaValores + "]", e);
		}
		return mapConfiguracion;
	}

	public static String obtenerHora(String startTime) throws ParseException {
		if (startTime == null) {
			return "";
		}
		if (startTime.isEmpty()) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = sdf.parse(startTime);
		String strDateFormat = "hh:mm a";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate = dateFormat.format(start);
		return formattedDate;
	}

	public static XMLGregorianCalendar getXmlGregorianCalnedar() {

		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal = null;
		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return xgcal;

	}

	public static String eliminarCerosPlanoCodigo(String codigoZona, int cantidad) {
		if (codigoZona == null) {
			return "";
		}
		if (codigoZona.isEmpty()) {
			return "";
		}
		return codigoZona.substring(cantidad);
	}
}