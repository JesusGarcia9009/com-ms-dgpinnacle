package com.ms.dgpinnacle.utils;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class NumberToWords {

	public static class ConvertidorPesos {

		private static final String[] UNIDADES = { "", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ",
				"ocho ", "nueve " };
		private static final String[] DECENAS = { "diez ", "once ", "doce ", "trece ", "catorce ", "quince ",
				"dieciseis ", "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ",
				"cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa " };
		private static final String[] CENTENAS = { "", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ",
				"quinientos ", "seiscientos ", "setecientos ", "ochocientos ", "novecientos " };

		public static String Convertir(long numeroL, String etiquetaEnteroSingular, String etiquetaEnteroPlural,
				String etiquetaFlotanteSingular, String etiquetaFlotantePlural, String etiquetaConector,
				boolean mayusculas) {
			String numero = Long.toString(numeroL);
			String literal = "";
			String parte_decimal = "";
			numero = numero.replace(".", ",");
			if (numero.indexOf(",") == -1) {
				numero = numero + ",00";
			}
			if (Pattern.matches("\\d{1,12},\\d{1,2}", numero)) {
				String Num[] = numero.split(",");
				if (Num[1].length() == 1) {
					Num[1] += "0";
				}
				String d = getDecenas(Num[1]);
				if (d != "") {
					if (etiquetaEnteroSingular != "")
						parte_decimal += " ";
					if (Integer.parseInt(Num[1]) == 1) {
						parte_decimal += etiquetaConector + " " + d + etiquetaFlotanteSingular;
					} else {
						parte_decimal += etiquetaConector + " " + d + etiquetaFlotantePlural;
					}
				}

				// se convierte el numero a literal
				BigInteger parteEntera = new BigInteger(Num[0]);

				if (parteEntera.compareTo(new BigInteger("0")) == 0) {
					literal = "cero ";
				} else if (parteEntera.compareTo(new BigInteger("999999999")) == 1) {
					literal = getBillones(Num[0]);
				} else if (parteEntera.compareTo(new BigInteger("999999")) == 1) {
					literal = getMillones(Num[0]);
				} else if (parteEntera.compareTo(new BigInteger("999")) == 1) {
					literal = getMiles(Num[0]);
				} else if (parteEntera.compareTo(new BigInteger("99")) == 1) {
					literal = getCentenas(Num[0]);
				} else if (parteEntera.compareTo(new BigInteger("9")) == 1) {
					literal = getDecenas(Num[0]);
				} else {
					literal = getUnidades(Num[0]);
				}
		
				if (parteEntera.compareTo(new BigInteger("1")) == 0) {
					literal += etiquetaEnteroSingular;
				} else {
					literal += etiquetaEnteroPlural;
				}

				if (mayusculas) {
					return (literal + parte_decimal).toUpperCase();
				} else {
					return (literal + parte_decimal);
				}
			} else {
				return literal = null;
			}
			
		}


		private static String getUnidades(String numero) {
			String num = numero.substring(numero.length() - 1);
			return UNIDADES[Integer.parseInt(num)];
		}

		private static String getDecenas(String num) {
			int n = Integer.parseInt(num);
			if (n < 10) {
				return getUnidades(num);
			} else if (n > 19) {
				String u = getUnidades(num);
				if (u.equals("")) { 
					return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
				} else {
					if (n == 21) {
						return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0, 5) + "i" + "ún ";
					}
					if (n == 22) {
						return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0, 5) + "i" + "dós ";
					}
					if (n == 23) {
						return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0, 5) + "i" + "trés ";
					}
					if (n == 24) {
						return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0, 5) + "i" + u;
					}
					if (n == 25) {
						return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0, 5) + "i" + u;
					}
					if (n == 26) {
						return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0, 5) + "i" + "séis ";
					}
					if (n == 27) {
						return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0, 5) + "i" + u;
					}
					if (n == 28) {
						return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0, 5) + "i" + u;
					}
					if (n == 29) {
						return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0, 5) + "i" + u;
					}
					return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
				}
			} else {
				return DECENAS[n - 10];
			}
		}

		private static String getCentenas(String num) {
			if (Integer.parseInt(num) > 99) {
				if (Integer.parseInt(num) == 100) {
					return " cien ";
				} else {
					return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
				}
			} else {
				return getDecenas(Integer.parseInt(num) + "");
			}
		}

		private static String getMiles(String numero) {
			String c = numero.substring(numero.length() - 3);
			String m = numero.substring(0, numero.length() - 3);
			String n = "";
			if (Integer.parseInt(m) > 0) {
				n = getCentenas(m);
				return n + "mil " + getCentenas(c);
			} else {
				return "" + getCentenas(c);
			}

		}

		private static String getMillones(String numero) { 
			String miles = numero.substring(numero.length() - 6);
			String millon = numero.substring(0, numero.length() - 6);
			String n = "";
			if (Integer.parseInt(millon) > 0) {
				if (Integer.parseInt(millon) == 1) {
					n = getUnidades(millon) + "millon ";
				} else {
					n = getCentenas(millon) + "millones ";
				}
			}

			return n + getMiles(miles);
		}

		private static String getBillones(String numero) { 
			String miles = numero.substring(numero.length() - 9);
			String millon = numero.substring(0, numero.length() - 9);
			String n = "";
			if (Integer.parseInt(millon) == 1) {
				n = getUnidades(millon) + "billon ";
			} else {
				n = getCentenas(millon) + "billones ";
			}
			return n + getMillones(miles);
		}

	}

}

