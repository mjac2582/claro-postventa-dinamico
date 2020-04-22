package pe.com.claro.postventa.dinamico.resource.mapper;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import pe.com.claro.common.property.Constantes;

public class CastingMapper {
	
	/**
	 * * ********************************
	 * CONFIGURABLE POR EL AP
	 * *********************************
     * [FASE 1] - Metodo de evaluacion de parametros Mandatorios, se agregara configuracion adicional cuando el Bean tenga SUB objetos, ejemplo Insertar Pago
     *
     * @param1 Object request
     * @return String Retornara el mensaje de error, si no existe retornara vacio.
     */
	public static String requestConfirmValues(Object beanRequest) {
		
		String msgError = Constantes.TEXTO_VACIO;
		
		if (beanRequest == null) {
			
			msgError = "El objeto de entrada no debe ser nulo";

		} else {		
			msgError = beanHaveViolations(beanRequest);			
		}
		
		return msgError;
	}
	
	/**
	 * * ********************************
	 * NO ES NECESARIO SER CONFIGURADO
	 * *********************************
     * Instancia y enlaza los objetos request con sus respectivos Response canonicos (Se envia ).
     * (vacio).
     *
     * @param1 Objeto request
     * @return String si existio un error de validacion retorna el detalle del error.
     */
	public static String beanHaveViolations(Object request){
		
		String msgError = Constantes.TEXTO_VACIO;
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);
		if (constraintViolations.size() >= Constantes.UNO)
			for (ConstraintViolation<Object> cv : constraintViolations) {
				msgError = cv.getPropertyPath() + " - " + cv.getMessage();
				break;
			}
		return msgError;
	}
}