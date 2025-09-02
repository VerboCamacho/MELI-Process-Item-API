# Prompts Usados para esta prueba

### se usaron herramientas IA como Chatgpt,Gemini y chat.oracle

## 1. Generación de modelos de datos

Prompt:
    
    "Genera clases Java para representar un producto con sus características, información general y reseñas. Asegúrate de incluir buenas prácticas de encapsulamiento."

Uso: 
- Crear rápidamente las clases Product, Characteristics, GeneralInfo y Reviews.

## 2. Creación de repositorio JSON

Prompt:

    "Crea un repositorio en Java que lea datos de un archivo products.json y permita buscar productos por ID. Maneja el caso cuando no se encuentra el producto devolviendo null."

Uso: 
- Implementar JsonProductRepository.

## 3. Implementación de servicio

Prompt:

    "Genera una clase de servicio Java que reciba un repositorio de productos y permita obtener un producto por su ID. Incluye manejo de excepciones cuando no se encuentra el producto."

Uso: 
- Crear ProductServiceImpl.

## 4. Controlador REST

Prompt:

    "Dame un ejemplo de un controlador REST en Spring Boot que exponga el endpoint /products/{id}. Debe usar el servicio de productos, devolver 200 OK con JSON cuando existe el producto y 404 Not Found cuando no."

Uso: 
- Generar ProductController.

## 5. Generación de pruebas unitarias

Prompt:

    "Genera ejemplos de pruebas unitarias en JUnit para el controlador, servicio y repositorio. Asegúrate de cubrir escenarios de producto encontrado y no encontrado."

Uso: 
- Crear pruebas ProductControllerTest, ProductServiceImplTest y ProductRepositoryTest.

## 6. Documentación del proyecto

Prompt:

    "Genera la documentacion Javadoc para las siguientes clases que compartire, incluye documentacion de las funciones y constructores asi como de la clase (inserto codigo)"

Uso: 
- Documentar las clases profesionalmente.

## 7. Optimización y buenas prácticas

Prompt:

    "Sugiere mejoras,refactorizaciones y alternativas para eliminar el boilerplate code en un proyecto Spring Boot que expone productos desde un JSON. Considera SOLID,inversion de control, manejo de excepciones y pruebas."

Uso: 
- Mejorar la calidad de la prueba.