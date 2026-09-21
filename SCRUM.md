## PASO 1: COMPONENTES DEL PROYECTO DE GESTIÓN DEL CONOCIMIENTO (PGC)

```c
┌─────────────────────────────────────────────────────────────────┐
│ **AULA EDUCATIVA INTELIGENTE {SCRUM}**                          │
├─────────────────────────────────────────────────────────────────┤
│ FRONTEND (Bootstrap 5)      │ BACKEND (EN PROCESO)              │
│ ├── Components              │ ├── Models []                     │
│ │ ├── Website[x]            │ │ ├── User Management []          │
│ │ ├── Autenticador[]        │ │ ├── Course System []            │
│ │ ├── Dashboard [x]         | │ ├── Gamification []             │
│ │ ├── Teacher Panel []      │ │ └── Forum System [x]            │
│ │ └── Admin Panel []        │ │                                 │
│ │                           │ │                                 │
| |------── {**PENDIENTE**}   | |------── {**PENDIENTE**}         |
│ ├── Services                │ ├── ViewSets (API) []             │
│ │ ├── Auth Service []       │ │ ├── User API []                 │
│ │ ├── Course Service []     │ │ ├── Course API []               │
│ │ ├── Gamification []       │ │ ├── Gamification API []         │
│ │ └── Forum Service []      │ │ └── Forum API []                │
│ ├── Guards & Interceptors   │ |                                 │
│ └── Routing System []       │ └── Authentication []             │
├─────────────────────────────────────────────────────────────────┤
```

## PASO 2: Estructura del Proyecto

```py
AVA_PROG 2/
├── .github/
│   ├── Logs
├── alfabetizacion-digital
│   └── index.html
├── ciberseguridad
│   └── index.html
├── computacion-basica
│   └── index.html
├── netiqueta
│   └── index.html
├── AULA EDUCATIVA INTELIGENTE.html
├── CHECKLIST_SUBIR_REPO.md
├── GUIA_SUBIR_REPOSITORIO.md
├── ICON_AVA.png
├── INSTRUCCIONES_Monitor_Checkeo_AVA.md
├── Monitor_Checkeo_AVA.java
├── script.py
├── SCRUM.md
└── style.css
```

### Resumen de actividades pendientes

- **Frontend**: Falta implementar los componentes de Autenticador, Teacher Panel,
  Admin Panel, y el sistema de rutas.

- **Backend**: Pendiente la creación de modelos, sistemas de gestión de usuarios,
  cursos, gamificación y foros, así como la autenticación y aplicar endpoints API correspondientes.

- Se requiere completar los servicios asociados y
  la integración entre frontend y backend.

---

## RESUMEN: Descripción de Funciones por Archivo

### Estructura Principal

| Archivo/Directorio                    | Función                                                                                                                                |
| ------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------- |
| **`.github/`**                        | Configuración de repositorio GitHub, logs, agentes e instrucciones de CI/CD                                                            |
| **`AULA EDUCATIVA INTELIGENTE.html`** | Interfaz principal del AVA - página de inicio y navegación central                                                                     |
| **`style.css`**                       | Hoja de estilos global (Bootstrap 5 + estilos personalizados) para toda la plataforma                                                  |
| **`script.py`**                       | Script de interactividad y accesibilidad en PyScript: control de tamaño de fuente, modo alto contraste, y persistencia de preferencias |

### Módulos Temáticos

| Directorio                    | Función                                                                             |
| ----------------------------- | ----------------------------------------------------------------------------------- |
| **`alfabetizacion-digital/`** | Módulo educativo sobre alfabetización digital (habilidades computacionales básicas) |
| **`ciberseguridad/`**         | Módulo educativo sobre ciberseguridad (protección de datos y privacidad online)     |
| **`computacion-basica/`**     | Módulo educativo sobre computación básica (fundamentos informáticos)                |
| **`netiqueta/`**              | Módulo educativo sobre netiqueta (normas de comportamiento en internet)             |

Cada módulo contiene un `index.html` con el contenido interactivo del tema.

### Documentación y Gestión

| Archivo                                    | Función                                                                                       |
| ------------------------------------------ | --------------------------------------------------------------------------------------------- |
| **`SCRUM.md`**                             | Planificación y seguimiento ágil del proyecto (componentes, estructura, actividades y estado) |
| **`CHECKLIST_SUBIR_REPO.md`**              | Lista de verificación antes de subir cambios al repositorio                                   |
| **`GUIA_SUBIR_REPOSITORIO.md`**            | Instructivo paso a paso para contribuir al repositorio                                        |
| **`INSTRUCCIONES_Monitor_Checkeo_AVA.md`** | Documentación sobre el uso del monitor de calidad                                             |

### Herramientas y Utilidades

| Archivo                        | Función                                                               |
| ------------------------------ | --------------------------------------------------------------------- |
| **`Monitor_Checkeo_AVA.java`** | Aplicación Java para monitorear, validar y auditar la calidad del AVA |
| **`ICON_AVA.png`**             | Icono/logo de la plataforma para branding e identidad visual          |

---

## Flujo de Uso del AVA

```
Usuario → AULA EDUCATIVA INTELIGENTE.html
          ↓
          Selecciona módulo (alfabetizacion-digital, ciberseguridad, etc.)
          ↓
          index.html del módulo (contenido temático)
          ↓
          script.py (interactividad + accesibilidad)
          ↓
          style.css (estilos y diseño)
```

---

## PASO 4: Enfoques y Metodologías Pedagógicas para el AVA

### Metodologías Recomendadas Similares a ABP

#### 1. **Aprendizaje Basado en Problemas (ABP/PBL)**

- **Descripción**: Los estudiantes resuelven problemas reales como punto de partida del aprendizaje
- **Aplicación en AVA**:
  - _Ciberseguridad_: "Tu cuenta fue hackeada, ¿qué hiciste mal? Identifica vulnerabilidades"
  - _Netiqueta_: "Analiza un caso de ciberacoso y propón soluciones"
- **Ventajas**: Motivación, pensamiento crítico, aplicabilidad inmediata

---

#### 2. **Aprendizaje Basado en Casos (ABC)**

- **Descripción**: Análisis profundo de situaciones reales o hipotéticas
- **Aplicación en AVA**:
  - Casos de estudio de incidentes de seguridad
  - Análisis de comportamientos en redes sociales (netiqueta)
  - Construcción de sistemas básicos (computación)
- **Ventajas**: Contextualización, análisis crítico, transferencia de conocimiento

---

#### 3. **Aprendizaje Basado en Proyectos (ABProy/PjBL)**

- **Descripción**: Desarrollar proyectos significativos a lo largo del módulo
- **Aplicación en AVA**:
  - Proyecto: "Crear una estrategia de seguridad para una PYME"
  - Proyecto: "Diseñar una guía de netiqueta para tu comunidad"
  - Proyecto: "Montar un servidor seguro básico"
- **Ventajas**: Autonomía, aplicabilidad, portafolio de competencias

---

#### 4. **Aprendizaje Basado en Retos (Challenge-Based Learning - CBL)**

- **Descripción**: Resolver desafíos progresivos que aumentan en complejidad
- **Aplicación en AVA**:
  - Reto 1: "Identifica 5 mejores prácticas de seguridad" (fácil)
  - Reto 2: "Configura contraseñas fuertes y autenticación" (medio)
  - Reto 3: "Diseña un plan de respuesta a incidente" (complejo)
- **Ventajas**: Motivación progresiva, gamificación natural, competencia construida

---

#### 5. **Aprendizaje Colaborativo y Social**

- **Descripción**: Construcción conjunta del conocimiento mediante interacción
- **Aplicación en AVA** (requiere Forum System + Teacher Panel):
  - Trabajos en equipo para resolver problemas
  - Foros de discusión con evaluación entre pares
  - Proyectos colaborativos por módulo
- **Ventajas**: Competencias blandas, networking, aprendizaje social

---

#### 6. **Aula Invertida (Flipped Classroom)**

- **Descripción**: Teoría en casa (videos, lecturas), práctica en clase
- **Aplicación en AVA**:
  - Videos de concepto teórico en módulos
  - Ejercicios prácticos interactivos en el AVA
  - Asesorías del docente para dudas complejas
- **Ventajas**: Control del ritmo, tiempo de clase optimizado, enfoque en habilidades

---

#### 7. **Microaprendizaje (Microlearning)**

- **Descripción**: Contenido en dosis pequeñas, focalizadas y reutilizables
- **Aplicación en AVA**:
  - Módulos de 3-5 minutos: "Consejo de ciberseguridad del día"
  - Lecciones cortas: "¿Qué es phishing? (2 min)"
  - Píldoras de netiqueta y buenas prácticas
- **Ventajas**: Retención, flexibilidad, accesibilidad móvil

---

#### 8. **Gamificación**

- **Descripción**: Integración de mecánicas de juego en aprendizaje (ya parcialmente en proyecto)
- **Aplicación en AVA** (requiere Gamification System):
  - Puntos por completar lecciones
  - Badges/insignias por logros (ej: "Experto en Ciberseguridad")
  - Leaderboards de progreso
  - Niveles desbloqueables
- **Ventajas**: Motivación, adherencia, feedback inmediato

---

#### 9. **Aprendizaje por Descubrimiento**

- **Descripción**: Estudiante construye conocimiento mediante exploración guiada
- **Aplicación en AVA**:
  - Simuladores interactivos (ej: "Configura tu primer router seguro")
  - Laboratorios virtuales de seguridad
  - Experimentos de computación básica
- **Ventajas**: Autonomía, comprensión profunda, motivación intrínseca

---

#### 10. **Metodología Socrática**

- **Descripción**: Aprendizaje mediante preguntas guiadas y reflexión
- **Aplicación en AVA**:
  - "¿Por qué crees que esto es vulnerable?"
  - "¿Cómo verificarías si esto es seguro?"
  - Cuestionarios reflexivos al final de lecciones
- **Ventajas**: Pensamiento crítico, metacognición, comprensión

---

### Matriz de Metodologías por Módulo

|           Módulo           |  ABP   |  ABC   | ABProy |  CBL   | Colaborativo | Flipped | Microlearning | Gamificación | Descubrimiento | Socrática |
| :------------------------: | :----: | :----: | :----: | :----: | :----------: | :-----: | :-----------: | :----------: | :------------: | :-------: |
| **Alfabetización Digital** |  ⭐⭐  |  ⭐⭐  | ⭐⭐⭐ | ⭐⭐⭐ |     ⭐⭐     | ⭐⭐⭐  |     ⭐⭐      |    ⭐⭐⭐    |     ⭐⭐⭐     |   ⭐⭐    |
|     **Ciberseguridad**     | ⭐⭐⭐ | ⭐⭐⭐ | ⭐⭐⭐ | ⭐⭐⭐ |    ⭐⭐⭐    |  ⭐⭐   |    ⭐⭐⭐     |    ⭐⭐⭐    |     ⭐⭐⭐     |  ⭐⭐⭐   |
|   **Computación Básica**   |  ⭐⭐  | ⭐⭐⭐ | ⭐⭐⭐ | ⭐⭐⭐ |     ⭐⭐     | ⭐⭐⭐  |     ⭐⭐      |     ⭐⭐     |     ⭐⭐⭐     |   ⭐⭐    |
|       **Netiqueta**        |  ⭐⭐  | ⭐⭐⭐ |  ⭐⭐  | ⭐⭐⭐ |    ⭐⭐⭐    |  ⭐⭐   |    ⭐⭐⭐     |     ⭐⭐     |      ⭐⭐      |  ⭐⭐⭐   |

_⭐⭐⭐ = Altamente recomendado | ⭐⭐ = Recomendado | ⭐ = Complementario_

---

### Estrategia Integrada Recomendada

**Combinar múltiples metodologías de forma híbrida:**

1. **Núcleo (Siempre)**: Gamificación + Microlearning + Aula Invertida
2. **Módulo 1 (Alfabetización Digital)**: + Aprendizaje por Descubrimiento + Retos
3. **Módulo 2 (Ciberseguridad)**: + ABP + Casos + Retos progresivos + Colaboración
4. **Módulo 3 (Computación Básica)**: + Proyectos + Descubrimiento + Socrática
5. **Módulo 4 (Netiqueta)**: + Casos + Análisis colaborativo + Socrática

---

### Componentes Técnicos Necesarios para Implementar

Para aprovechar estas metodologías, requiere desarrollar:

| Metodología     | Componente Técnico Necesario                | Estado         |
| --------------- | ------------------------------------------- | -------------- |
| ABP, ABC, Retos | Gestor de problemas/casos y evaluación      | ⏳ Pendiente   |
| Proyectos       | Sistema de entregas y rúbricas              | ⏳ Pendiente   |
| Colaborativo    | Forum System + Chat en tiempo real          | ⏳ En progreso |
| Descubrimiento  | Simuladores/laboratorios interactivos       | ⏳ Pendiente   |
| Gamificación    | Sistema de puntos, badges y leaderboards    | ⏳ En progreso |
| Aula Invertida  | Gestor de recursos (videos, lecturas, PDFs) | ⏳ Pendiente   |
