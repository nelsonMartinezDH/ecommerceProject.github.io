🛒 E-Commerce Microservices Architecture

Este proyecto es una arquitectura de e-commerce distribuida basada en microservicios, desarrollada con enfoque en escalabilidad, mantenibilidad y separación de responsabilidades. Cada componente del sistema representa una funcionalidad independiente que se comunica con los demás a través de servicios REST y descubrimiento de servicios.


📦 Microservicios del proyecto
api-Gateway: Puerta de entrada principal a todos los servicios. Maneja el enrutamiento, autenticación y balanceo de carga.

config-server: Servidor de configuración centralizada. Permite que los microservicios carguen su configuración desde un repositorio común.

eurekaserver: Registro de servicios (Service Registry) que permite el descubrimiento dinámico de los microservicios en la red.

Orders: Servicio de gestión de órdenes. Permite crear, consultar y actualizar pedidos.

Products: Servicio de catálogo. Gestiona los productos disponibles en el sistema.

Users: Servicio de gestión de usuarios. Maneja autenticación y datos del cliente.

service-configuration: Repositorio o módulo auxiliar que contiene los archivos de configuración para los servicios gestionados por config-server.


🧩 Arquitectura
Cada microservicio es autónomo, se despliega de forma independiente y puede escalar de manera horizontal. La arquitectura se basa en:

Spring Boot
-Spring Cloud (Eureka, Config, Gateway)

-Comunicación vía REST API

-Configuración centralizada


🚀 Cómo ejecutar el sistema

Clonar el repositorio.

Ejecutar primero eurekaserver y config-server.

Luego, levantar los demás microservicios (Users, Products, Orders, etc.).

Finalmente, iniciar el api-Gateway.

Todos los servicios deben estar configurados para leer su configuración desde config-server y registrarse en eurekaserver.



🔧 Tecnologías utilizadas
Java / Spring Boot
Spring Cloud (Eureka, Gateway, Config)
Maven / Gradle
Docker (opcional)
Git


👨‍💻 Autor
Nelson Martinez Hazbum - Ingeniero De Sistemas / Backend Developer
