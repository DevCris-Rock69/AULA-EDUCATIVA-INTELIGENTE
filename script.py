"""
AVA - Script de interactividad y accesibilidad
Archivo: script.py
Tecnologia: PyScript (Python ejecutado en navegador)

Funciones principales solicitadas:
1) Aumentar y disminuir tamano de fuente del sitio.
2) Activar o desactivar modo de lectura (alto contraste).

Criterios de accesibilidad aplicados:
- Control por botones accesibles y operables por teclado.
- Retroalimentacion para lector de pantalla mediante aria-live.
- Persistencia de preferencias para mantener configuracion del usuario.
"""

# Importa dinamicamente APIs del navegador.
# Solo cuando se ejecuta en "PyScript".
# Esta estrategia evita errores de analisis local en VS Code (fuera del navegador).
try:
    js_module = __import__("js")
    document = js_module.document
    localStorage = js_module.localStorage

    pyodide_ffi = __import__("pyodide.ffi", fromlist=["create_proxy"])
    create_proxy = pyodide_ffi.create_proxy
    
    BROWSER_RUNTIME = True
except Exception:
    document = None
    localStorage = None
    def create_proxy(fn): return fn
    BROWSER_RUNTIME = False

"""
 -------------------------
 Configuracion inicial
 -------------------------
Rango permitido para tamano de fuente.
Evita valores extremos poco legibles.
"""

MIN_FONT = 85
MAX_FONT = 140
STEP_FONT = 5

# Claves para guardar preferencias de accesibilidad del usuario en localStorage.
KEY_FONT = "ava_font_size"
KEY_READ_MODE = "ava_read_mode"

"""
 -------------------------
 Utilidades de accesibilidad
 -------------------------
Devuelve el nodo aria-live para anunciar cambios
a lectores de pantalla.
"""
def get_status_region():
    if document is None:
        return None
    return document.getElementById("estado-accesibilidad")


# Region global para mensajes de accesibilidad.
status_region = get_status_region()


"""
    Publica mensajes cortos para lectores
     de pantalla usando aria-live.
"""
def announce(message: str):
    
    if status_region is not None:
        status_region.textContent = message




def get_font_size() -> int:
    """
    def get_font_size() -> int:
    Obtiene el tamano de fuente actual en porcentaje
     desde el estilo raiz del documento.
    """

    if document is None:
        return 100
    current = document.documentElement.style.fontSize
    if current and current.endswith("%"):
        return int(current.replace("%", ""))
    return 100



"""
Aplica y persiste el tamano de fuente, respetando limites de
legibilidad.
"""
def apply_font_size(value: int):
    if document is None or localStorage is None:
        return
    safe_value = max(MIN_FONT, min(MAX_FONT, value))
    document.documentElement.style.fontSize = f"{safe_value}%"
    localStorage.setItem(KEY_FONT, str(safe_value))
    announce(f"Tamano de fuente ajustado a {safe_value} por ciento")



"""
Incrementa el tamano de fuente en
pasos fijos para mejorar lectura.
"""
def increase_font(event=None):
    apply_font_size(get_font_size() + STEP_FONT)



"""
Reduce el tamano de fuente en pasos fijos 
para adaptarse a preferencia del usuario.
"""
def decrease_font(event=None):
    apply_font_size(get_font_size() - STEP_FONT)



"""
Indica si el modo lectura esta activo
en el cuerpo del documento.
"""
def is_read_mode_active() -> bool:
    if document is None:
        return False
    return document.body.classList.contains("read-mode")



    """
    Activa o desactiva el modo lectura:
    - Alterna clase CSS de alto contraste.
    - Actualiza estado ARIA del boton para lector de pantalla.
    - Guarda preferencia para siguientes visitas.
    """
def apply_read_mode(active: bool):
    if document is None or localStorage is None:
        return

    button = document.getElementById("btn-lectura")

    if active:
        document.body.classList.add("read-mode")
        if button is not None:
            button.setAttribute("aria-pressed", "true")
        localStorage.setItem(KEY_READ_MODE, "true")
        announce("Modo de lectura activado")
    else:
        document.body.classList.remove("read-mode")
        if button is not None:
            button.setAttribute("aria-pressed", "false")
        localStorage.setItem(KEY_READ_MODE, "false")
        announce("Modo de lectura desactivado")


def toggle_read_mode(event=None):
    # Cambia entre modo normal y modo lectura de alto contraste.
    apply_read_mode(not is_read_mode_active())

"""
-------------------------
Enlace de eventos
-------------------------
def bind_controls():
Conecta botones del panel de accesibilidad con funciones Python.
"""

def bind_controls():
    if document is None:
        return

    btn_plus = document.getElementById("btn-aumentar")
    btn_minus = document.getElementById("btn-disminuir")
    btn_read = document.getElementById("btn-lectura")

    if btn_plus is not None:
        btn_plus.addEventListener("click", create_proxy(increase_font))

    if btn_minus is not None:
        btn_minus.addEventListener("click", create_proxy(decrease_font))

    if btn_read is not None:
        btn_read.addEventListener("click", create_proxy(toggle_read_mode))

"""
--------------------------------
Restaurar preferencias previas
--------------------------------
"""



"""
Recupera configuracion guardada para brindar
continuidad de accesibilidad.
"""
def restore_user_preferences():
    if localStorage is None:
        return

    stored_font = localStorage.getItem(KEY_FONT)
    stored_mode = localStorage.getItem(KEY_READ_MODE)

    if stored_font is not None and stored_font.isdigit():
        apply_font_size(int(stored_font))

    if stored_mode == "true":
        apply_read_mode(True)
    else:
        apply_read_mode(False)


"""
-------------------------
Inicio del script
-------------------------
# 1) Vincula eventos de botones.
# 2) Restaura preferencias guardadas.
# 3) Publica aviso inicial de disponibilidad de controles.
"""

if BROWSER_RUNTIME:
    bind_controls()
    restore_user_preferences()
    announce("Controles de accesibilidad listos")

# Test de consola...
print("SCRIPT DONE!....")