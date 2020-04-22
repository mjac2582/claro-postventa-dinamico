package pe.com.claro.postventa.dinamico.domain.service;

import java.lang.reflect.Type;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import pe.com.claro.common.bean.HeaderRequest;
import pe.com.claro.common.property.Constantes;
import pe.com.claro.common.util.ClaroUtil;
import pe.com.claro.postventa.dinamico.canonical.EjecutarFlujoAutomaticoRequest;
import pe.com.claro.postventa.dinamico.canonical.TelefoniaServiceRequest;
import pe.com.claro.postventa.dinamico.model.bean.response.ObtieneFlujoAutomaticoResponse;

public class prueba {
	public static void main (String [ ] args) throws JsonProcessingException {
		String request = "{\r\n" + 
				"  \"transaccion\" : \"ACTIVAR SERVICIOS2\",\r\n" + 
				"  \"tecnologia\" : \"HFC\",\r\n" + 
				"  \"parametros\" : [ {\r\n" + 
				"    \"parametro\" : \"username\",\r\n" + 
				"    \"valor\" : \"RESTAPIHFC\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"password\",\r\n" + 
				"    \"valor\" : \"RESTAPIHFC\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"serviceProvider\",\r\n" + 
				"    \"valor\" : \"Incognito\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"language\",\r\n" + 
				"    \"valor\" : \"English\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"customerId\",\r\n" + 
				"    \"valor\" : \"987654321\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"firstName\",\r\n" + 
				"    \"valor\" : \"PEDRO\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"lastName\",\r\n" + 
				"    \"valor\" : \"ALIMAÑA\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"internet_identifier\",\r\n" + 
				"    \"valor\" : \"P2000000005159\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"internet_serviceType\",\r\n" + 
				"    \"valor\" : \"Infinitum_120M_12M\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"internet_attributes_HFC_NODE\",\r\n" + 
				"    \"valor\" : \"LMLV050\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"internet_attributes_HUB\",\r\n" + 
				"    \"valor\" : \"Hub Aviacion\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"internet_attributes_CPE_POOL\",\r\n" + 
				"    \"valor\" : \"cpe\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"internet_attributes_MAX_CPE\",\r\n" + 
				"    \"valor\" : \"2\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"internet_attributes_STATIC_IP_COUNT\",\r\n" + 
				"    \"valor\" : \"1\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"internet_device_identifier\",\r\n" + 
				"    \"valor\" : \"AC:3B:77:55:D1:100\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"internet_device_type\",\r\n" + 
				"    \"valor\" : \"FAST3686V2.2 CM\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"telefonia_identifier\",\r\n" + 
				"    \"valor\" : \"SGA_P1000000005158\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"telefonia_serviceType\",\r\n" + 
				"    \"valor\" : \"Telefonia_Servicio_Prepaid\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"telefonia_attributes_CALL_FEATURES\",\r\n" + 
				"    \"valor\" : \"LROA,CXR,CPC,CNDB,LROA\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"telefonia_attributes_TELEPHONY_PHONE_NUMBER\",\r\n" + 
				"    \"valor\" : \"16595371\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"telefonia_attributes_MTA_PORT\",\r\n" + 
				"    \"valor\" : \"1\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"telefonia_attributes_VOICE_NODE\",\r\n" + 
				"    \"valor\" : \"LIM\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"telefonia_attributes_IS_CENTREX_ENABLED\",\r\n" + 
				"    \"valor\" : \"NO\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"telefonia_attributes_CALL_BARRING_TYPE\",\r\n" + 
				"    \"valor\" : \"NCOS23\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"telefonia_device_identifier\",\r\n" + 
				"    \"valor\" : \"AC:3B:77:55:D1:99\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"telefonia_device_type\",\r\n" + 
				"    \"valor\" : \"FAST3686V2.2 MTA\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"telefonia_device_child_identifier\",\r\n" + 
				"    \"valor\" : \"AC:3B:77:55:D1:98\"\r\n" + 
				"  }, {\r\n" + 
				"    \"parametro\" : \"telefonia_device_child_type\",\r\n" + 
				"    \"valor\" : \"FAST3686V2.2 CM\"\r\n" + 
				"  } ]\r\n" + 
				"}";

		 JsonParser jsonParser = new JsonParser();
	     JsonElement jsonElement = jsonParser.parse(request);
	     String llaves = "parametros.0.valor";
	     JsonElement valor= getLlave2(jsonElement,llaves);
	     System.out.println(valor.toString());
	     
	     llaves = "parametros.parametro.telefonia_device_identifier";
	     String [] listaLlaves = llaves.split(Constantes.PUNTO_CARACTER);
	     valor= getLlave2(jsonElement,listaLlaves[0]);
	     System.out.println(valor.toString());
	     int indParametro = -1;
	     if(valor.isJsonArray()){
				JsonArray array = valor.getAsJsonArray();
		        Iterator<JsonElement> iter = array.iterator();
		        int j = 0;
		        while (iter.hasNext()) {
		            JsonElement entrada = iter.next();
		            System.out.println(entrada.toString());
		            entrada = getLlave2(entrada, listaLlaves[1]);
		            String parametro = entrada.getAsJsonPrimitive().getAsString();
		            if (parametro.equals(listaLlaves[2])) {
		            	indParametro = j;
		            	break;
		            }
		            System.out.println(entrada.getAsJsonPrimitive().getAsString());
		            j++;
		        }
	     }
	     llaves = listaLlaves[0]+"."+indParametro+"."+"valor";
	     System.out.println(llaves);
	     valor= getLlave2(jsonElement,llaves);
	     System.out.println(valor.toString());
//	     llaves = "parametros.parametro.username";
//	     valor= getLlave2(jsonElement,llaves);
//	     System.out.println(valor.toString());
	}
	
	
	
	public static JsonElement getLlave2(JsonElement jsonElement, String llaves) {
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
	
//	public static void main (String [ ] args) throws JsonProcessingException {
//		String abc = "{\r\n" + 
//				"  \"orden\" : 4,\r\n" + 
//				"  \"idProceso\" : 103,\r\n" + 
//				"  \"abreviacion\" : \"Inc󧮩to - Activar Internet\",\r\n" + 
//				"  \"preProceso\" : \"105,104\",\r\n" + 
//				"  \"postProceso\" : \"106\",\r\n" + 
//				"  \"flagMandatorio\" : \"SI\",\r\n" + 
//				"  \"ordenCondicion\" : 1,\r\n" + 
//				"  \"idcondicion\" : 42,\r\n" + 
//				"  \"flagRegistrarTransaccion\" : \"NO\",\r\n" + 
//				"  \"reintentos\" : 3,\r\n" + 
//				"  \"idProcesoError\" : null,\r\n" + 
//				"  \"ruta\" : \"http://172.19.91.219:2800/SACRestApi/api/services\",\r\n" + 
//				"  \"cabecera\" : \"{\\n  \\\"authorization\\\":\\\"authorization\\\"\\n}\",\r\n" + 
//				"  \"cuerpo\" : \"{\\n  \\\"identifier\\\": \\\"identifier\\\",\\n  \\\"subscriberIdentifier\\\": \\\"subscriberIdentifier\\\",\\n  \\\"serviceType\\\": \\\"serviceType\\\",\\n  \\\"attributes\\\": [\\n    {\\n      \\\"HFC_NODE\\\": \\\"HFC_NODE\\\",\\n      \\\"HUB\\\": \\\"HUB\\\",\\n      \\\"CPE_POOL\\\": \\\"CPE_POOL\\\",\\n      \\\"MAX_CPE\\\": \\\"MAX_CPE\\\",\\n      \\\"STATIC_IP_COUNT\\\": \\\"STATIC_IP_COUNT\\\"\\n    }\\n  ],\\n  \\\"device\\\": {\\n    \\\"identifier\\\": \\\"identifier\\\",\\n    \\\"type\\\": \\\"type\\\"\\n  }\\n}\",\r\n" + 
//				"  \"metodo\" : \"POST\",\r\n" + 
//				"  \"timeout\" : 5000,\r\n" + 
//				"  \"requestHeader\" : \"{\\n  \\\"authorization\\\":\\\"authorization\\\"\\n}\",\r\n" + 
//				"  \"requestBody\" : \"{\\n  \\\"identifier\\\": \\\"identifier\\\",\\n  \\\"subscriberIdentifier\\\": \\\"subscriberIdentifier\\\",\\n  \\\"serviceType\\\": \\\"serviceType\\\",\\n  \\\"attributes\\\": [\\n    {\\n      \\\"HFC_NODE\\\": \\\"HFC_NODE\\\",\\n      \\\"HUB\\\": \\\"HUB\\\",\\n      \\\"CPE_POOL\\\": \\\"CPE_POOL\\\",\\n      \\\"MAX_CPE\\\": \\\"MAX_CPE\\\",\\n      \\\"STATIC_IP_COUNT\\\": \\\"STATIC_IP_COUNT\\\"\\n    }\\n  ],\\n  \\\"device\\\": {\\n    \\\"identifier\\\": \\\"identifier\\\",\\n    \\\"type\\\": \\\"type\\\"\\n  }\\n}\",\r\n" + 
//				"  \"responseHeader\" : null,\r\n" + 
//				"  \"responseBody\" : null,\r\n" + 
//				"  \"estado\" : 1,\r\n" + 
//				"  \"numIntento\" : 0,\r\n" + 
//				"  \"codigoRespuesta\" : 0,\r\n" + 
//				"  \"mensajeRespuesta\" : null\r\n" + 
//				"}";
//		System.out.println(abc);
//		//abc=abc.replace(" \\\\", " \\");
//		abc=abc.replace("\\n", "\n").replace("\\\"", "\"");
//		System.out.println(abc);
//		EjecutarFlujoAutomaticoRequest ejecutarFlujoAutomaticoRequest= new EjecutarFlujoAutomaticoRequest();
//		System.out.println(ClaroUtil.printPrettyJSONString(ejecutarFlujoAutomaticoRequest));
//		String llave = "request.header.abc.qwe";
//		System.out.println(llave);
//		llave = obtieneLlave(llave);
//		System.out.println("obtiene: "+llave);
//		String json = "{\r\n" + 
//				" \"identifier\":\"identifier\",\r\n" + 
//				" \"subscriberIdentifier\":\"subscriberIdentifier\",\r\n" + 
//				" \"serviceType\":\"serviceType\",\r\n" + 
//				" \"attributes\":[\r\n" + 
//				" {\r\n" + 
//				"  \"CALL_FEATURES\":\"CALL_FEATURES\",\r\n" + 
//				"  \"TELEPHONY_PHONE_NUMBER\":\"TELEPHONY_PHONE_NUMBER\",\r\n" + 
//				"  \"MTA_PORT\":\"MTA_PORT\",\r\n" + 
//				"  \"VOICE_NODE\":\"VOICE_NODE\",\r\n" + 
//				"  \"IS_CENTREX_ENABLED\":\"IS_CENTREX_ENABLED\",\r\n" + 
//				"  \"CALL_BARRING_TYPE\":\"CALL_BARRING_TYPE\"\r\n" + 
//				" },\r\n" + 
//				" {\r\n" + 
//				"  \"CALL_FEATURES\":\"CALL_FEATURES2\",\r\n" + 
//				"  \"TELEPHONY_PHONE_NUMBER\":\"TELEPHONY_PHONE_NUMBER2\",\r\n" + 
//				"  \"MTA_PORT\":\"MTA_PORT2\",\r\n" + 
//				"  \"VOICE_NODE\":\"VOICE_NODE2\",\r\n" + 
//				"  \"IS_CENTREX_ENABLED\":\"IS_CENTREX_ENABLED2\",\r\n" + 
//				"  \"CALL_BARRING_TYPE\":\"CALL_BARRING_TYPE2\"\r\n" + 
//				" }\r\n" + 
//				"],\r\n" + 
//				" \"device\":{\r\n" + 
//				"   \"identifier\":\"identifier\",\r\n" + 
//				"   \"type\":\"type\",\r\n" + 
//				"   \"child\":{\r\n" + 
//				"     \"identifier\":\"identifier\",\r\n" + 
//				"     \"type\":\"type\"\r\n" + 
//				"   }\r\n" + 
//				" }\r\n" + 
//				"}";
//		
//		//System.out.println(retornaParametroDeJson(json,"status"));
//		System.out.println(json);
//		//debeDevolerLaRepresentacionJSONDeUnTipoGenerico();
//        //Aquí las instrucciones del método
//		 JsonParser jsonParser = new JsonParser();
//	     JsonElement jsonElement = jsonParser.parse(json);
//	     //JsonObject obj = jsonElement.getAsJsonObject();
//	     JsonElement jsonElementValue = getLlave(jsonElement,"attributes.1");
//	     System.out.println("valor a setear: "+jsonElementValue.toString());
//	     String json2 ="\r\n" + 
//	     		"{\r\n" + 
//	     		"  \"identifier\": \"SGA2000000005159\",\r\n" + 
//	     		"  \"subscriberIdentifier\": \"28708863\",\r\n" + 
//	     		"  \"serviceType\": \"Infinitum_120M_12M\",\r\n" + 
//	     		"  \"attributes\": [\r\n" + 
//	     		"    {\r\n" + 
//	     		"      \"HFC_NODE\": \"LMLV050\",\r\n" + 
//	     		"      \"HUB\": \"Hub Aviacion\",\r\n" + 
//	     		"      \"CPE_POOL\": \"cpe\",\r\n" + 
//	     		"      \"MAX_CPE\": \"2\",\r\n" + 
//	     		"      \"STATIC_IP_COUNT\": \"1\"\r\n" + 
//	     		"    }\r\n" + 
//	     		"  ],\r\n" + 
//	     		"  \"device\": {\r\n" + 
//	     		"    \"identifier\": \"AC:3B:77:55:D1:100\",\r\n" + 
//	     		"    \"type\": \"FAST3686V2.2 CM\"\r\n" + 
//	     		"  }\r\n" + 
//	     		"}";
//	     
//	     HeaderRequest headerRequest = new HeaderRequest();
//	     System.out.println(ClaroUtil.printPrettyJSONString(headerRequest));
//	     jsonElement = jsonParser.parse(json);
//	     System.out.println(json);
//	     jsonElement = setLlave(jsonElement, "attributes.0", jsonElementValue);
//	     System.out.println("elemento seteado: "+jsonElement.toString());
//		 //String valorLlave = dumpJSONElement(jsonElement,"attributes",0);
//		 //System.out.println("valor llave: "+valorLlave);
//		 //valorLlave = addLlave(jsonElement, "attributes");
//	     //String objeto = obj.get("status").toString();
//	     //System.out.println(objeto);
//	     /*JsonObject obj = jsonElement.getAsJsonObject();
//	        java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
//	        java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
//	        while (iter.hasNext()) {
//	            java.util.Map.Entry<String,JsonElement> entrada = iter.next();
//	            System.out.println("Clave: " + entrada.getKey());
//	            System.out.println("Valor:"+entrada.getValue().toString().replace("\"", ""));
//	            //dumpJSONElement(entrada.getValue());
//	        }*/
//	    //String valorLlave = dumpJSONElement(jsonElement,"attributes",0);
//	    //System.out.println("valor llave: "+valorLlave);
//
//}
	private static String obtieneLlave(String llave) {
		String [] llaves = llave.split("\\.");
		llave = "";
		for (int i = 2; i < llaves.length; i++) {
			llave = llave+llaves[i];
			if(i<llaves.length-1) {
				llave=llave+".";
			}
		}
		return llave;
	}
	public static JsonElement getLlave(JsonElement jsonElement, String llaves) {
		String [] listaLlaves = llaves.split("\\.");
		for (int i = 0; i < listaLlaves.length; i++) {
			if (jsonElement.isJsonObject()) {
				JsonObject jsonObject = jsonElement.getAsJsonObject();
				jsonElement = jsonObject.get(listaLlaves[i]);
				if (i+1 == listaLlaves.length) {//último nivel
					return jsonElement;
				}
			}else if(jsonElement.isJsonArray()){
				JsonArray array = jsonElement.getAsJsonArray();
		        System.out.println("Es array. Numero de elementos: " + array.size());
		        Iterator<JsonElement> iter = array.iterator();
		        int j = 0;
		        while (iter.hasNext()) {
		            JsonElement entrada = iter.next();
	            	System.out.println(entrada.toString());
		            if (listaLlaves[i].equals(""+j)) {
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
	
	public static JsonElement setLlave(JsonElement jsonElement, String llaves, JsonElement jsonElementValue) {
		String [] listaLlaves = llaves.split("\\.");
		JsonElement [] listaJsonElement = new JsonElement[listaLlaves.length];
		listaJsonElement[0] = jsonElement;
		
		for (int i = 0; i < listaLlaves.length-1; i++) {
			if (jsonElement.isJsonObject()) {
				JsonObject jsonObject = jsonElement.getAsJsonObject();
				System.out.println(jsonObject.toString());
				jsonElement = jsonObject.get(listaLlaves[i]);
				listaJsonElement[i+1] = jsonElement;
			}else if(jsonElement.isJsonArray()){
				JsonArray array = jsonElement.getAsJsonArray();
		        System.out.println("Es array. Numero de elementos: " + array.size());
		        Iterator<JsonElement> iter = array.iterator();
		        int j = 0;
		        while (iter.hasNext()) {
		            JsonElement entrada = iter.next();
	            	System.out.println(entrada.toString());
		            if (listaLlaves[i].equals(""+j)) {
		            	jsonElement = entrada;
						listaJsonElement[i+1] = jsonElement;
						break;
		            }
		            j++;
		        }
			}
		}
		jsonElement = jsonElementValue;
		System.out.println("imprimiendo lista listaJsonElement.length:"+listaJsonElement.length);
		for (int i = 0; i < listaJsonElement.length; i++) {
			System.out.println(listaJsonElement[i].toString());
		}
		System.out.println("seteando");
		for (int i = listaJsonElement.length-1; i > -1 ; i--) {
			if (listaJsonElement[i].isJsonObject()) {
				System.out.println("seteando");
				JsonObject jsonObject = listaJsonElement[i].getAsJsonObject();
				//se setea el jsonelement
				jsonObject.add(listaLlaves[i], jsonElement);
				jsonElement = jsonObject;
				System.out.println(jsonElement.toString());
			}else if(listaJsonElement[i].isJsonArray()){
				JsonArray array = listaJsonElement[i].getAsJsonArray();
		        System.out.println("Es array. Numero de elementos: " + array.size());
		        Iterator<JsonElement> iter = array.iterator();
		        int j = 0;
		        array = new JsonArray();
		        while (iter.hasNext()) {
		            JsonElement entrada = iter.next();
	            	System.out.println(entrada.toString());
		            if (listaLlaves[i].equals(""+j)) {
		            	array.add(jsonElement);
		            }else {
		            	array.add(entrada);
		            }
		            j++;
		        }
		        jsonElement = array;
			}
		}
		return jsonElement;
	}
	
	public static String addLlave(JsonElement jsonElement,String llaves) {
		 if (jsonElement.isJsonObject()) {
		        System.out.println("Es objeto");
		        JsonObject jsonObject = jsonElement.getAsJsonObject();
		        jsonObject.addProperty("lastModified", "qwe");
		        jsonElement = jsonObject;
		 }
		 System.out.println("ESTE ES:");
		System.out.println(jsonElement.toString());
		return jsonElement.toString();
	}
	public static String returnKeyJson(JsonElement jsonElement,String llaves, int nivel) {
		String key =null;
		String[] llaveString = null;
		llaveString = llaves.split("\\.");
		int cantidad = llaveString.length;
		if(nivel<cantidad) {
			key = llaveString[nivel];
			nivel++;
		}
		String valorParametro = null;
		System.out.println("Llave a encontrar: "+key);
	    if (jsonElement.isJsonObject()) {
	        System.out.println("Es objeto");
	        JsonObject jsonObject = jsonElement.getAsJsonObject();
	        jsonElement = jsonObject.get(key);
	        if(jsonElement.isJsonPrimitive()) {
        		System.out.println("objeto-primitive");
        		valorParametro = returnKeyJson(jsonElement, llaves, nivel);
        	}else if(jsonElement.isJsonObject()||jsonElement.isJsonArray()) {
        		System.out.println("objeto-(objeto,array)");
        		if(cantidad == nivel) {
            		System.out.println("es el ultimo nivel");
        			//es el ultimo nivel
            		valorParametro = jsonElement.toString();
        		}else {
            		System.out.println("no es ultimo nivel");
            		valorParametro = returnKeyJson(jsonElement, llaves, nivel);
            		//jsonElement.
        		}
        	}

	    } else if (jsonElement.isJsonArray()) {
	        JsonArray array = jsonElement.getAsJsonArray();
	        System.out.println("Es array. Numero de elementos: " + array.size());
	        valorParametro = array.toString();
	    } else if (jsonElement.isJsonPrimitive()) {
	        System.out.println("Es primitiva");
	        JsonPrimitive valor = jsonElement.getAsJsonPrimitive();
	        if (valor.isBoolean()) { 
	            System.out.println("Es booleano: " + valor.getAsBoolean());
	            valorParametro = ""+valor.getAsBoolean();
	        } else if (valor.isNumber()) {
	            System.out.println("Es numero: " + valor.getAsNumber());
	            valorParametro = ""+valor.getAsNumber();
	        } else if (valor.isString()) {
	            System.out.println("Es texto: " + valor.getAsString());
	            valorParametro = ""+valor.getAsString();
	        }
	    } else if (jsonElement.isJsonNull()) {
	        System.out.println("Es NULL");
	    } else {
	        System.out.println("Es otra cosa");
	    }
		return valorParametro;
	}

	
	/*
	public static String retornaParametroDeJson(String json,String llaves) {
		JsonParser jsonParser = new JsonParser();
	    JsonElement jsonElement = jsonParser.parse(json);
	    JsonObject jsonObject = jsonElement.getAsJsonObject();
		String[] llaveString = llaves.split("\\.");
		String valor = null;
		for (int i = 0; i < llaveString.length; i++) {
			//jsonObject = jsonObject.get(llaveString[i]).getAsJsonObject();
			if (jsonElement.isJsonObject()) {
				jsonElement = jsonObject.get(llaveString[i]);
				if() {
					
				}else if() {
					
				}
				valor = jsonElement.toString();
			}else if(jsonElement.isJsonPrimitive()) {
				JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
		        if (jsonPrimitive.isBoolean()) { 
		            valor =  ""+jsonPrimitive.getAsBoolean();
		        } else if (jsonPrimitive.isNumber()) {
		            valor =  ""+jsonPrimitive.getAsNumber();
		        } else if (jsonPrimitive.isString()) {
		            valor =  ""+jsonPrimitive.getAsString();
		        }
			}else if(jsonElement.isJsonArray()) {
				valor = jsonElement.getAsJsonArray().toString();
			}else if(jsonElement.isJsonNull()) {
				valor = "";
			}
		}
		return valor;
	}
	*/
	public static void debeDevolerLaRepresentacionJSONDeUnTipoGenerico() throws JsonProcessingException {
		
		String envoltorioGenericoJSON = "{\"objeto\":{\r\n" + 
				" \"identifier\":\"SGA1000000005158\",\r\n" + 
				" \"subscriberIdentifier\":\"28708863\",\r\n" + 
				" \"serviceType\":\"Telefonia_Servicio_Prepaid\",\r\n" + 
				" \"attributes\":[\r\n" + 
				" {\r\n" + 
				"  \"CALL_FEATURES\":\"LROA,CXR,CPC,CNDB,LROA\",\r\n" + 
				"  \"TELEPHONY_PHONE_NUMBER\":\"16595371\",\r\n" + 
				"  \"MTA_PORT\":\"1\",\r\n" + 
				"  \"VOICE_NODE\":\"LIM\",\r\n" + 
				"  \"IS_CENTREX_ENABLED\":\"NO\",\r\n" + 
				"  \"CALL_BARRING_TYPE\":\"NCOS23\"\r\n" + 
				" }\r\n" + 
				"],\r\n" + 
				" \"device\":{\r\n" + 
				"   \"identifier\":\"AC:3B:77:55:D1:99\",\r\n" + 
				"   \"type\":\"FAST3686V2.2 MTA\",\r\n" + 
				"   \"child\":{\r\n" + 
				"     \"identifier\":\"AC:3B:77:55:D1:98\",\r\n" + 
				"     \"type\":\"FAST3686V2.2 CM\"\r\n" + 
				"   }\r\n" + 
				" }\r\n" + 
				"}}";
		Type tipoEnvoltorioEmpleado = new TypeToken<ClaseGenerica<TelefoniaServiceRequest>>(){}.getType();
		Gson gson = new Gson();
		ClaseGenerica<TelefoniaServiceRequest> envoltorioEmpleado = gson.fromJson(envoltorioGenericoJSON, tipoEnvoltorioEmpleado);
		System.out.println(ClaroUtil.printPrettyJSONString(envoltorioEmpleado));
	}
	
	
	public static String dumpJSONElement(JsonElement elemento,String llaves, int nivel) {
		String key =null;
		String[] llaveString = null;
		llaveString = llaves.split("\\.");
		//System.out.println(llaveString[nivel]);
		int cantidad = llaveString.length;
		if(nivel<cantidad) {
			key = llaveString[nivel];
			nivel++;
		}
		System.out.println("Llave a encontrar: "+key);
	    if (elemento.isJsonObject()) {
	        System.out.println("Es objeto");
	        JsonObject obj = elemento.getAsJsonObject();
	        java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
	        java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
	        while (iter.hasNext()) {
	            java.util.Map.Entry<String,JsonElement> entrada = iter.next();
	            System.out.println("Clave: " + entrada.getKey());
	            System.out.println("Valor:"+entrada.getValue());
	            if (key.equals(entrada.getKey())) {
	            	if(entrada.getValue().isJsonPrimitive()) {
	            		System.out.println("objeto-primitive");
	            		return dumpJSONElement(entrada.getValue(), llaves, nivel);
	            	}else if(entrada.getValue().isJsonObject()||entrada.getValue().isJsonArray()) {
	            		System.out.println("objeto-(objeto,array)");
	            		if(cantidad == nivel) {
		            		System.out.println("es el ultimo nivel");
	            			//es el ultimo nivel
	            			return entrada.getValue().toString();
	            		}else {
		            		System.out.println("no es ultimo nivel");
	            			return dumpJSONElement(entrada.getValue(), llaves, nivel);
	            		}
	            	}
	            }
	        }

	    } else if (elemento.isJsonArray()) {
	        JsonArray array = elemento.getAsJsonArray();
	        System.out.println("Es array. Numero de elementos: " + array.size());
	        /*java.util.Iterator<JsonElement> iter = array.iterator();
	        while (iter.hasNext()) {
	            JsonElement entrada = iter.next();
	            //return dumpJSONElement(entrada, llaves, nivel);	
	        }*/
	        return array.getAsString();
	    } else if (elemento.isJsonPrimitive()) {
	        System.out.println("Es primitiva");
	        JsonPrimitive valor = elemento.getAsJsonPrimitive();
	        if (valor.isBoolean()) { 
	            System.out.println("Es booleano: " + valor.getAsBoolean());
	            return ""+valor.getAsBoolean();
	        } else if (valor.isNumber()) {
	            System.out.println("Es numero: " + valor.getAsNumber());
	            return ""+valor.getAsNumber();
	        } else if (valor.isString()) {
	            System.out.println("Es texto: " + valor.getAsString());
	            return ""+valor.getAsString();
	        }
	    } else if (elemento.isJsonNull()) {
	        System.out.println("Es NULL");
	    } else {
	        System.out.println("Es otra cosa");
	    }
		return null;
	}
}
