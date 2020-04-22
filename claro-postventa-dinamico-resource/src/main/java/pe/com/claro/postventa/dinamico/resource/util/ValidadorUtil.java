package pe.com.claro.postventa.dinamico.resource.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.com.claro.common.bean.HeaderRequest;
import pe.com.claro.postventa.dinamico.resource.mapper.CastingMapper;

public class ValidadorUtil{
	
	private static final Logger LOG = LoggerFactory.getLogger(ValidadorUtil.class);
	
	public static final Set<ConstraintViolation<HeaderRequest>> validarParametrosObligatoriosHeader(String msgTransaction, HeaderRequest headerRequest){
		LOG.info(msgTransaction + "[Header] Evaluando Header Request ....");
		HeaderRequest header = new HeaderRequest(headerRequest);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		return validator.validate(header);
	}

	public static String validarParametrosObligatoriosBody(String msgTransaction, Object request){
		LOG.info(msgTransaction + "[BodyDatosTecnico] Evaluando BodyDatosTecnico Request .... ");		
		return CastingMapper.requestConfirmValues(request);
	}

}