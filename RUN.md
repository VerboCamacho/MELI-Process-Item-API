# Guía rápida de ejecución

## Prerrequisitos
- Java 17
- Maven 3.9.x o superior
- Puerto 8080 libre

### Ir al directorio raiz del proyecto abrir una linea de comandos en ese directorio para correr los siguientes comandos

## Construir
Compilar y empacar:
    
    mvn clean package

## Ejecutar
con Maven
    
    mvn spring-boot:run


## Verificar
Swagger UI:
- http://localhost:8080/swagger-ui/index.html

Endpoints:
- Lista de productos:
    
    http://localhost:8080/v1/products

- Detalle por id (ejemplo):
    
    http://localhost:8080/v1/products/1001

## Datos de ejemplo
Archivo: src/main/resources/products.json

    [
      { "id": "w-001", "name": "Apple Watch Series 9", "price": 399.99 },
      { "id": "w-002", "name": "Samsung Galaxy Watch 6", "price": 299.99 }
    ]

## Resolución de problemas
- Swagger UI no carga:
  - Verifica que la dependencia `springdoc-openapi-starter-webmvc-ui` esté en el `pom.xml`.
  - Asegura que la app corre en `8080` o ajusta la URL si cambiaste el puerto.
- Error leyendo `products.json`:
  - Confirma que exista `src/main/resources/products.json` y que el JSON sea válido.
- 404 en `/products/{id}`:
  - Revisa que el id exista en el archivo `products.json` (por ejemplo, `w-001`).

## Notas
- La API no usa base de datos. Todos los datos provienen del archivo JSON en el classpath.
