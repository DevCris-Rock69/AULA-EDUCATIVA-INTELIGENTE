import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
        Propósito:
 - Monitorear continuamente la disponibilidad del AVA (Ambiente Virtual de Aprendizaje).
 - Medir tiempos de respuesta en cada intento.
 - Registrar fallos de conexión con descripción del error.
 - Calcular porcentajes de éxito, fallos y estabilidad.
 - Realizar intentos cada 30 segundos de forma indefinida.
 - Mostrar estadísticas finales al presionar Ctrl+C.

Detener: Presionar Ctrl+C
*/
public class Monitor_Checkeo_AVA {

    // Configuración
    private static final String URL_AVA = "http://127.0.0.1:5500/AULA%20EDUCATIVA%20INTELIGENTE.html";
    private static final int TIMEOUT_MS = 10000; // 10 segundos
    private static final int INTERVALO_SEGUNDOS = 30;

    // Colores ANSI para terminal
    private static final String ROJO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String AZUL = "\u001B[34m";
    private static final String RESET = "\u001B[0m";

    // Estadísticas
    private static int totalIntentos = 0;
    private static int intentosExitosos = 0;
    private static int intentosFallidos = 0;
    private static int caidasConexion = 0;
    private static long tiempoRespuestaTotal = 0;
    private static double tiempoRespuestaPromedio = 0;
    private static long tiempoRespuestaMinimo = Long.MAX_VALUE;
    private static long tiempoRespuestaMaximo = 0;

    // Variables de estado
    private static boolean ultimoEstadoOK = true;
    private static SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        System.out.println(AZUL + "=".repeat(80) + RESET);
        System.out.println(AZUL + "MONITOR DE DISPONIBILIDAD - AMBIENTE VIRTUAL DE APRENDIZAJE (AVA)" + RESET);
        System.out.println(AZUL + "=".repeat(80) + RESET);
        System.out.println();
        System.out.println("URL de monitoreo: " + URL_AVA);
        System.out.println("Timeout máximo: " + TIMEOUT_MS / 1000 + " segundos");
        System.out.println("Intervalo entre intentos: " + INTERVALO_SEGUNDOS + " segundos");
        System.out.println("Estado: Monitorando... (Presiona Ctrl+C para detener)");
        System.out.println();

        // Hook para capturar Ctrl+C y mostrar estadísticas
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            mostrarEstadisticasFinales();
        }));

        // Loop infinito de monitoreo
        while (true) {
            realizarIntento();

            try {
                Thread.sleep(INTERVALO_SEGUNDOS * 1000); // Esperar 30 segundos
            } catch (InterruptedException e) {
                System.out.println(ROJO + "[INTERRUPCIÓN] Monitoreo detenido por el usuario." + RESET);
                break;
            }
        }
    }

    /**
     * Realiza un intento de conexión al AVA.
     * Mide tiempo de respuesta, detecta fallos y actualiza estadísticas.
     */
    private static void realizarIntento() {
        totalIntentos++;
        String timestamp = formatoFecha.format(new Date());

        try {
            // Crear conexión HTTP
            URL url = new URL(URL_AVA);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("HEAD"); // Solo obtener headers (más rápido)
            conexion.setConnectTimeout(TIMEOUT_MS);
            conexion.setReadTimeout(TIMEOUT_MS);

            // Medir tiempo de respuesta
            long tiempoInicio = System.currentTimeMillis();
            int codigoRespuesta = conexion.getResponseCode();
            long tiempoFin = System.currentTimeMillis();
            long tiempoRespuesta = tiempoFin - tiempoInicio;

            // Procesar respuesta
            if (codigoRespuesta >= 200 && codigoRespuesta < 300) {
                // Conexión exitosa (2xx - Success)
                intentosExitosos++;
                tiempoRespuestaTotal += tiempoRespuesta;

                // Actualizar estadísticas de tiempo
                if (tiempoRespuesta < tiempoRespuestaMinimo) {
                    tiempoRespuestaMinimo = tiempoRespuesta;
                }
                if (tiempoRespuesta > tiempoRespuestaMaximo) {
                    tiempoRespuestaMaximo = tiempoRespuesta;
                }

                // Mostrar en verde
                System.out.println(VERDE + "[" + timestamp + "] Test AVA #" + totalIntentos + ": OK - "
                        + tiempoRespuesta + "ms" + RESET);

                // Detectar recuperación de caída
                if (!ultimoEstadoOK) {
                    System.out.println(VERDE + "[" + timestamp + "] ✓ Conexión RECUPERADA" + RESET);
                    ultimoEstadoOK = true;
                }

            } else {
                // Código de error HTTP (4xx, 5xx)
                intentosFallidos++;
                System.out.println(ROJO + "[" + timestamp + "] Test AVA #" + totalIntentos + ": FALLO - Código HTTP "
                        + codigoRespuesta + RESET);
                registrarCaidaConexion();
            }

            conexion.disconnect();

        } catch (SocketTimeoutException e) {
            // Timeout: conexión tardó más de 10 segundos
            intentosFallidos++;
            System.out.println(ROJO + "[" + timestamp + "] Test AVA #" + totalIntentos
                    + ": FALLO - Timeout (conexión excedió " + TIMEOUT_MS / 1000 + "s)" + RESET);
            registrarCaidaConexion();

        } catch (java.net.ConnectException e) {
            // Conexión rechazada: servidor no responde
            intentosFallidos++;
            System.out.println(ROJO + "[" + timestamp + "] Test AVA #" + totalIntentos
                    + ": FALLO - Conexión rechazada (servidor no disponible)" + RESET);
            registrarCaidaConexion();

        } catch (java.net.UnknownHostException e) {
            // Host desconocido: problema de DNS o direccion incorrecta
            intentosFallidos++;
            System.out.println(ROJO + "[" + timestamp + "] Test AVA #" + totalIntentos
                    + ": FALLO - Host desconocido (problema de DNS)" + RESET);
            registrarCaidaConexion();

        } catch (java.net.SocketException e) {
            // Problema general de socket: conexión perdida, red inalámbrica, etc.
            intentosFallidos++;
            System.out.println(ROJO + "[" + timestamp + "] Test AVA #" + totalIntentos + ": FALLO - Error de socket ("
                    + e.getMessage() + ")" + RESET);
            registrarCaidaConexion();

        } catch (IOException e) {
            // Otros errores de I/O
            intentosFallidos++;
            System.out.println(ROJO + "[" + timestamp + "] Test AVA #" + totalIntentos + ": FALLO - Error de I/O ("
                    + e.getMessage() + ")" + RESET);
            registrarCaidaConexion();

        } catch (Exception e) {
            // Errores inesperados
            intentosFallidos++;
            System.out.println(ROJO + "[" + timestamp + "] Test AVA #" + totalIntentos + ": FALLO - Error inesperado ("
                    + e.getClass().getSimpleName() + ": " + e.getMessage() + ")" + RESET);
            registrarCaidaConexion();
        }

        // Mostrar métricas actuales después de cada intento
        mostrarMetricasActuales();
    }

    /**
     * Registra una caída de conexión cuando el estado pasa de OK a FALLO.
     */
    private static void registrarCaidaConexion() {
        if (ultimoEstadoOK) {
            caidasConexion++;
            ultimoEstadoOK = false;
        }
    }

    /**
     * Muestra las métricas actuales en cada intento.
     */
    private static void mostrarMetricasActuales() {
        double porcentajeExito = (totalIntentos > 0) ? (intentosExitosos * 100.0 / totalIntentos) : 0;
        double porcentajeFallos = (totalIntentos > 0) ? (intentosFallidos * 100.0 / totalIntentos) : 0;
        tiempoRespuestaPromedio = (intentosExitosos > 0) ? (tiempoRespuestaTotal / intentosExitosos) : 0;

        System.out.println(AMARILLO + "  Intentos: " + totalIntentos +
                " | Éxitos: " + intentosExitosos +
                " (" + String.format("%.1f", porcentajeExito) + "%)" +
                " | Fallos: " + intentosFallidos +
                " (" + String.format("%.1f", porcentajeFallos) + "%)" +
                " | Caídas: " + caidasConexion +
                " | Tiempo promedio: " + tiempoRespuestaPromedio + "ms" + RESET);
        System.out.println();
    }

    /**
     * Muestra estadísticas finales cuando se presiona Ctrl+C.
     */
    private static void mostrarEstadisticasFinales() {
        System.out.println();
        System.out.println(AZUL + "=".repeat(80) + RESET);
        System.out.println(AZUL + "ESTADÍSTICAS FINALES DEL MONITOREO" + RESET);
        System.out.println(AZUL + "=".repeat(80) + RESET);
        System.out.println();

        // Cálculos finales
        double porcentajeExito = (totalIntentos > 0) ? (intentosExitosos * 100.0 / totalIntentos) : 0;
        double porcentajeFallos = (totalIntentos > 0) ? (intentosFallidos * 100.0 / totalIntentos) : 0;
        double estabilidad = porcentajeExito; // Porcentaje de estabilidad = % de éxito
        tiempoRespuestaPromedio = (intentosExitosos > 0) ? (tiempoRespuestaTotal / intentosExitosos) : 0;

        // Mostrar resumen
        System.out.println(VERDE + "✓ Total de intentos: " + RESET + totalIntentos);
        System.out.println(VERDE + "✓ Intentos exitosos: " + RESET + intentosExitosos +
                " (" + String.format("%.2f", porcentajeExito) + "%)");
        System.out.println(ROJO + "✗ Intentos fallidos: " + RESET + intentosFallidos +
                " (" + String.format("%.2f", porcentajeFallos) + "%)");
        System.out.println();

        System.out.println(AMARILLO + "📊 ESTADÍSTICAS DE CONECTIVIDAD:" + RESET);
        System.out.println("  • Estabilidad del internet: " + String.format("%.2f", estabilidad) + "%");
        System.out.println("  • Tasa de éxito: " + String.format("%.2f", porcentajeExito) + "%");
        System.out.println("  • Tasa de fallos: " + String.format("%.2f", porcentajeFallos) + "%");
        System.out.println("  • Caídas de conexión detectadas: " + caidasConexion);
        System.out.println();

        System.out.println(AMARILLO + "⏱️  ESTADÍSTICAS DE TIEMPO DE RESPUESTA:" + RESET);
        System.out.println("  • Tiempo promedio: " + String.format("%.2f", tiempoRespuestaPromedio) + " ms");
        System.out.println("  • Tiempo mínimo: "
                + (tiempoRespuestaMinimo == Long.MAX_VALUE ? "N/A" : tiempoRespuestaMinimo + " ms"));
        System.out
                .println("  • Tiempo máximo: " + (tiempoRespuestaMaximo == 0 ? "N/A" : tiempoRespuestaMaximo + " ms"));
        System.out.println();

        // Valoración general
        String valoracion;
        String color;
        if (estabilidad >= 95) {
            valoracion = "EXCELENTE ✓";
            color = VERDE;
        } else if (estabilidad >= 80) {
            valoracion = "BUENO ✓";
            color = VERDE;
        } else if (estabilidad >= 50) {
            valoracion = "ACEPTABLE ⚠";
            color = AMARILLO;
        } else {
            valoracion = "CRÍTICO ✗";
            color = ROJO;
        }

        System.out.println(color + "==>VALORACIÓN GENERAL: " + valoracion + RESET);
        System.out.println();
        System.out.println(AZUL + "=".repeat(80) + RESET);
        System.out.println(AZUL + "Monitoreo finalizado." + RESET);
        System.out.println(AZUL + "=".repeat(80) + RESET);
    }
}
