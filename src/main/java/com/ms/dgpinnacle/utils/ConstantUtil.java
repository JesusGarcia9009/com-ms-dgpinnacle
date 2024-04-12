package com.ms.dgpinnacle.utils;

/**
 * ConstantUtil
 * 
 * @author Jesus Garcia - Open2000
 * @version 0.1
 * @since jdk-11.0.7
 */
public class ConstantUtil {

	private ConstantUtil() {

	}
	
	/**
	 * Errorres
	 */
	public static final String MSG_OPERATION_DUPL = "OPERATION_DUPL";
	public static final String MSG_REALTOR_DUPL = "MSG_REALTOR_DUPL";
	public static final String MSG_LOAN_DUPL = "MSG_LOAN_DUPL";
	public static final String MSG_CLIENT_DUPL = "MSG_CLIENT_DUPL";
	public static final String MSG_CLIENT_NOT_EXIST = "CLIENT_NOT_EXIST";
	public static final String MSG_LETTER_NOT_EXIST = "LETTER_NOT_EXIST";
	public static final String MSG_LOAN_NOT_EXIST_DUPL = "LOAN_NOT_EXIST";
	public static final String MSG_MAX_PAYMENT_TO_HIGH = "MSG_MAX_PAYMENT_TO_HIGH";
	public static final String MSG_MAIL_DUPL = "MAIL_DUPL";
	
	public static final String MSG_ERROR_TOKEN = "ERROR_TOKEN :: Response -> ";
	public static final String MSG_ERROR_LOAN = "ERROR_LOAN :: Response -> ";

	/**
	 * Logs
	 */
	public static final String LOG_START = "[INFO :: %s] - START.";
	public static final String LOG_END = "[INFO :: %s] - END.";
	public static final String LOG_START_END = "[INFO :: %s] - START-END.";
	public static final String EXCEPTION_DEPENDENCY = "Content not present.";
	
	/**
	 * Security
	 */
	public static final String[] PATH_ARRAY = new String[] { "/**/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
			"/api/dgpinnacle/login/**", "/configuration/security", "/**/swagger-ui/**", "/swagger-ui.html",
			"/webjars/**" };
	public static final String[] PATH_RESOURCES_ARRAY = new String[] { "/", "/favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg",
			"/**/*.html", "/**/*.css", "/**/*.js" };
	
	/**
	 * Errors
	 */
	public static final String ERROR_USER_NOT_FOUND = "Usuario no perfilado, por favor verifique sus credenciales.";
	public static final String EXCEPTION = "[ERROR -> METHOD: %s -> MSG: %s].";
	
    public static final String  PESO_ENTERO_SINGULAR = "peso";
    public static final String  PESO_ENTERO_PLURAL = "pesos";

	
	/**
	 * Ver
	 */
    public static final String MSG_REF_DUPL = "MSG_REF_DUPL";
    public static final String MSG_RENTA_ACTIVA = "MSG_RENTA_ACTIVA";
    public static final String MSG_CA_ACTIVO = "MSG_CA_ACTIVO";
    public static final String MSG_PERIODO_UTILIZADO = "MSG_PERIODO_UTILIZADO";
    public static final String MSG_NO_RENT_CARG = "MSG_NO_RENT_CARG";
    public static final String MSG_ARR_DUPL = "MSG_ARR_DUPL";

}
