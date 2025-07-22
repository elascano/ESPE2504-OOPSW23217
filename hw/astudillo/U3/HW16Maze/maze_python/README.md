# Maze Generator in Python

Este proyecto implementa un generador de laberintos en Python siguiendo los principios SOLID de desarrollo de software.

## Estructura del Proyecto

```
maze_python/
├── src/
│   └── maze/
│       ├── __init__.py
│       ├── controller/
│       │   ├── __init__.py
│       │   ├── door.py
│       │   ├── end_door.py
│       │   ├── maze.py
│       │   ├── path.py
│       │   ├── room.py
│       │   ├── setting_maze.py
│       │   └── start_door.py
│       ├── model/
│       │   ├── __init__.py
│       │   ├── coordinate.py
│       │   └── wall.py
│       └── view/
│           ├── __init__.py
│           └── system_maze.py
├── tests/
├── requirements.txt
└── README.md
```

## Principios SOLID Aplicados

### Single Responsibility Principle (SRP)
- **Wall**: Solo maneja el estado abierto/cerrado
- **Coordinate**: Solo representa coordenadas
- **Room**: Solo gestiona una habitación
- **Path**: Solo maneja caminos
- **SystemMaze**: Solo maneja interfaz de usuario

### Open/Closed Principle (OCP)
- **SettingMaze**: Clase abstracta que permite diferentes algoritmos de generación
- **Door**: Puede extenderse para tipos especiales (StartDoor, EndDoor)

### Liskov Substitution Principle (LSP)
- Las subclases pueden sustituir a sus clases padre sin romper funcionalidad

### Interface Segregation Principle (ISP)
- Interfaces mínimas con solo métodos necesarios

### Dependency Inversion Principle (DIP)
- Las clases dependen de abstracciones, no de implementaciones concretas

## Cómo Ejecutar

```bash
cd src
python -m maze.view.system_maze
```

## Ejemplo de Uso

```python
from maze.controller.setting_maze import DefaultMazeSetting

# Crear configuración
maze_setting = DefaultMazeSetting(5, 5)

# Generar laberinto
maze = maze_setting.generate_maze()

# Mostrar laberinto
maze.display()
```

## Características

- Generación aleatoria de laberintos usando algoritmo DFS (Depth-First Search)
- Entrada y salida automáticas
- Visualización en consola
- Arquitectura extensible siguiendo principios SOLID
- Separación clara de responsabilidades (MVC)

## Requisitos

- Python 3.7+
- No requiere dependencias externas
