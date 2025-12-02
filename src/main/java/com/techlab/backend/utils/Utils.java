package com.techlab.backend.utils;

public class Utils {

  public static String formatearNombreProducto(String cadena){
    cadena = cadena.trim().toLowerCase();

    String[] palabras = cadena.split(" ");

    StringBuilder cadenaFormateada = new StringBuilder();

    for (String palabra : palabras) {

      if (palabra.length() == 1) {
        cadenaFormateada.append(" ");
      }
      if (!palabra.isEmpty()) {
        String palabraLetraMayus = palabra.substring(0, 1).toUpperCase() + palabra.substring(1);
        cadenaFormateada.append(palabraLetraMayus).append(" ");
      }
    }

    return cadenaFormateada.toString().trim();
  }
}
