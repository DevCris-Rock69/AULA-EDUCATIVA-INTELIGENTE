# AULA EDUCATIVA INTELIGENTE

Ambiente Virtual de Aprendizaje (AVA) para fortalecer competencias digitales básicas mediante cuatro módulos formativos: **Alfabetización Digital, Netiqueta, Computación Básica y Ciberseguridad**.

El proyecto parte de un sitio web estático accesible, construido con HTML, CSS, Bootstrap y PyScript. Su diseño permite evolucionar progresivamente hacia **Objetos Virtuales de Aprendizaje (OVAs)** reutilizables y, posteriormente, hacia un **Entorno Virtual de Aprendizaje (EVA)** con usuarios, actividades, seguimiento y evaluación.

## Propósito del proyecto

El AVA busca que los estudiantes desarrollen conocimientos y hábitos para desenvolverse en entornos digitales de forma **crítica, ética, segura e inclusiva**. La propuesta combina contenidos breves, ejemplos cotidianos, actividades prácticas y evidencias de aprendizaje.

La experiencia formativa sigue esta secuencia:

1. **Activación:** reconocer conocimientos previos y situaciones digitales cercanas.
2. **Desarrollo:** consultar conceptos, ejemplos y recursos accesibles.
3. **Aplicación:** resolver actividades relacionadas con problemas reales.
4. **Transferencia:** producir una evidencia que demuestre el desempeño.
5. **Retroalimentación:** revisar resultados, identificar mejoras y aplicar lo aprendido.

## Módulos del AVA

### 1. Alfabetización Digital

**Propósito:** desarrollar la capacidad de buscar, analizar, contrastar y utilizar información digital de manera crítica y ética.

**Contenidos principales:**

- Operadores y estrategias de búsqueda avanzada.
- Identificación de autoría, fecha, propósito y confiabilidad de una fuente.
- Prevención de noticias falsas, sesgos y desinformación.
- Uso de herramientas ofimáticas y recursos digitales.
- Citas y uso responsable de información en línea.

**Resultado de aprendizaje:** el estudiante valora la confiabilidad de una fuente digital y justifica su decisión con criterios verificables.

**Evidencia sugerida:** ficha de verificación y comparación de una fuente web.

### 2. Netiqueta

**Propósito:** promover una convivencia digital respetuosa, clara, empática y responsable en espacios educativos y colaborativos.

**Contenidos principales:**

- Redacción de mensajes claros y respetuosos.
- Buenas prácticas en foros, correos y videollamadas.
- Escucha activa, empatía y manejo de conflictos.
- Prevención del ciberacoso.
- Responsabilidad individual en el trabajo colaborativo.

**Resultado de aprendizaje:** el estudiante aplica normas de comunicación digital para resolver situaciones de interacción en línea de manera respetuosa.

**Evidencia sugerida:** resolución argumentada de un caso de convivencia digital.

### 3. Computación Básica

**Propósito:** proporcionar los fundamentos necesarios para reconocer el funcionamiento de un equipo informático y utilizarlo de forma eficiente.

**Contenidos principales:**

- Partes internas y externas de un computador.
- Diferencias entre hardware, software de sistema, aplicaciones y utilidades.
- Funciones de un sistema operativo.
- Gestión básica de archivos y recursos.
- Mantenimiento preventivo y buenas prácticas de uso.

**Resultado de aprendizaje:** el estudiante identifica componentes de hardware y software, y explica su función en situaciones de uso cotidiano.

**Evidencia sugerida:** infografía o ejercicio de clasificación de componentes y funciones.

### 4. Ciberseguridad

**Propósito:** fortalecer hábitos para proteger cuentas, datos personales y dispositivos frente a riesgos digitales frecuentes.

**Contenidos principales:**

- Creación y gestión de contraseñas robustas.
- Autenticación de dos factores.
- Identificación de phishing en correos, mensajes y enlaces.
- Configuración de privacidad.
- Copias de seguridad y protección de información sensible.

**Resultado de aprendizaje:** el estudiante identifica riesgos digitales y propone medidas concretas para proteger su información personal.

**Evidencia sugerida:** análisis de un caso de phishing y elaboración de un plan personal de protección.

## Articulación pedagógica de los módulos

Los módulos pueden cursarse de manera independiente, pero juntos forman una ruta progresiva:

1. **Computación Básica** proporciona las bases para comprender equipos, programas y sistemas operativos.
2. **Alfabetización Digital** desarrolla el uso crítico de la información y las herramientas digitales.
3. **Netiqueta** orienta la comunicación responsable con otras personas.
4. **Ciberseguridad** integra prácticas para proteger la identidad, los datos y los dispositivos.

Cada módulo debe conservar la alineación entre **competencia, objetivo observable, contenido, actividad, evidencia y criterio de evaluación**. Se recomienda incorporar evaluación diagnóstica al inicio, evaluación formativa durante el recorrido y evaluación sumativa mediante la evidencia final.

## De AVA a OVA y EVA escalables

### AVA: experiencia actual

El AVA es la propuesta educativa completa: organiza la ruta de aprendizaje, los módulos, la navegación, los recursos y las actividades. En esta versión funciona principalmente como un sitio estático sin cuentas ni persistencia centralizada.

### OVA: módulos reutilizables

Cada módulo puede convertirse en un OVA independiente, autocontenido y reutilizable en diferentes cursos o plataformas. Para ello, debe incluir:

- Título, propósito, público objetivo y prerrequisitos.
- Resultado de aprendizaje redactado con un verbo observable.
- Microcontenidos organizados en lecciones breves.
- Recursos variados: texto, imagen, audio, video o simulación.
- Actividad práctica relacionada con un contexto real.
- Evidencia descargable o entregable.
- Rúbrica o criterios de valoración comunicados previamente.
- Retroalimentación y actividad de refuerzo.
- Metadatos: autoría, versión, duración, licencia, idioma y accesibilidad.
- Formatos interoperables para facilitar su integración en un LMS.

La separación por OVA permite actualizar un tema sin reconstruir todo el AVA, reutilizar contenidos en otros programas y ofrecer rutas diferenciadas según el nivel del estudiante.

### EVA: plataforma escalable

El EVA será la plataforma que aloje y gestione los OVAs. Su evolución recomendada comprende:

- Autenticación y roles de estudiante, docente y administrador.
- Inscripción a módulos o rutas de aprendizaje.
- Registro de progreso por módulo, lección y actividad.
- Entrega versionada de evidencias.
- Evaluaciones, rúbricas y retroalimentación.
- Paneles de seguimiento para estudiantes y docentes.
- Gestión de contenidos y control de versiones.
- Notificaciones y calendario de actividades.
- Analítica orientada a mejorar el aprendizaje, sin decisiones discriminatorias automáticas.

La plataforma debe iniciar como un **monolito modular** con una base de datos relacional y evolucionar solo cuando el volumen de usuarios, contenidos o integraciones lo justifique. No se recomienda adoptar microservicios desde la primera versión.

## Ruta de escalabilidad

| Fase                     | Alcance                                                                                             | Resultado esperado                                    |
| ------------------------ | --------------------------------------------------------------------------------------------------- | ----------------------------------------------------- |
| **1. Prototipo**         | HTML, CSS, Bootstrap, PyScript y contenidos estáticos.                                              | Validar navegación, contenidos y accesibilidad.       |
| **2. OVAs**              | Convertir cada módulo en una unidad autocontenida con actividad, evidencia y metadatos.             | Reutilizar módulos en distintos cursos y plataformas. |
| **3. MVP del EVA**       | Usuarios, roles, base de datos, progreso, actividades y resultados básicos.                         | Ofrecer seguimiento individual y gestión inicial.     |
| **4. EVA institucional** | Rúbricas, retroalimentación, notificaciones, analítica y administración de contenidos.              | Gestionar múltiples grupos, docentes y rutas.         |
| **5. Escalamiento**      | Almacenamiento de objetos, copias de seguridad, caché, monitoreo, pruebas de carga e integraciones. | Atender mayor demanda con seguridad y disponibilidad. |

## Accesibilidad e inclusión

La accesibilidad es un requisito transversal del AVA, de los OVAs y del futuro EVA. La implementación actual incorpora:

- Estructura semántica con `header`, `nav`, `main`, `section` y `footer`.
- Enlace para saltar al contenido principal.
- Navegación mediante teclado y foco visible.
- Etiquetas ARIA y mensajes para lectores de pantalla.
- Diseño responsivo para diferentes tamaños de pantalla.
- Controles para aumentar o disminuir el tamaño de fuente.
- Modo de lectura y alto contraste.

En las siguientes fases se deben añadir texto alternativo, subtítulos y transcripciones, contraste suficiente, lenguaje claro, alternativas a recursos dependientes del color y pruebas con teclado, lectores de pantalla y usuarios reales.

## Evaluación y mejora continua

Cada OVA debe incluir criterios de evaluación claros, observables y diferenciables. Se recomienda valorar:

- **Participación:** acceso, permanencia e interacción con los recursos.
- **Logro:** cumplimiento de los resultados de aprendizaje.
- **Finalización:** actividades y evidencias completadas.
- **Satisfacción:** percepción de claridad, utilidad y accesibilidad.
- **Transferencia:** aplicación de lo aprendido en situaciones reales.

Los resultados deben utilizarse para mejorar contenidos, instrucciones y actividades. Las métricas no deben emplearse para sancionar automáticamente ni para discriminar a estudiantes por su ritmo, conectividad o necesidad de apoyo.

## Estructura técnica actual

```text
AVA_ARCH DATA/
├── AULA EDUCATIVA INTELIGENTE.html   # Página principal del AVA
├── style.css                          # Estilos compartidos
├── script.py                          # Funciones de accesibilidad con PyScript
├── alfabetizacion-digital/index.html  # Módulo 1
├── netiqueta/index.html               # Módulo 2
├── computacion-basica/index.html      # Módulo 3
├── ciberseguridad/index.html          # Módulo 4
└── MODELO_INFORMACION_Y_VIABILIDAD_AVA.md
```

## Tecnologías y evolución recomendada

La versión actual utiliza HTML, CSS, Bootstrap 5.3, PyScript y JavaScript del navegador. Para la evolución se recomienda:

- Backend modular con Node.js/TypeScript o Django, según la experiencia del equipo.
- PostgreSQL o una base relacional equivalente para usuarios, módulos, progreso, evidencias y evaluaciones.
- Almacenamiento de objetos para documentos, imágenes, audio, video y evidencias.
- API documentada para conectar frontend, OVAs, aplicaciones externas y futuros servicios.
- HTTPS, copias de seguridad, control de acceso, validación de entradas y revisión de dependencias.
- Control de versiones para contenidos, código y materiales pedagógicos.

## Cómo consultar el prototipo

1. Abrir `AULA EDUCATIVA INTELIGENTE.html` en un navegador o mediante un servidor local.
2. Seleccionar uno de los cuatro módulos desde el menú principal.
3. Probar la navegación con teclado y los controles de accesibilidad.
4. Revisar los documentos de modelo, viabilidad y criterios de calidad antes de ampliar el alcance.

La versión estática no incluye autenticación, persistencia de progreso ni entrega de evidencias. Esas capacidades corresponden a la evolución hacia el EVA.

## Documentación relacionada

- [Modelo de información y estudio de viabilidad](MODELO_INFORMACION_Y_VIABILIDAD_AVA.md)
- [Guía para subir el repositorio](GUIA_SUBIR_REPOSITORIO.md)
- [Checklist para subir el repositorio](CHECKLIST_SUBIR_REPO.md)
- [Instrucciones del monitor de chequeo AVA](INSTRUCCIONES_Monitor_Checkeo_AVA.md)

## Estado del proyecto

**Estado actual:** prototipo educativo web accesible.

**Próximo paso recomendado:** especificar cada módulo como OVA, incorporando actividad, evidencia, rúbrica, alternativas accesibles y metadatos de reutilización antes de implementar autenticación y persistencia.
