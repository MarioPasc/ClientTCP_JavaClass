# ClientTCP

Cliente TCP simple escrito en Java para establecer conexiones TCP con un servidor y enviar/recebir datos.

## Descripción

El programa `ClientTCP` permite a los usuarios conectarse a un servidor TCP especificando la dirección IP y el puerto del servidor. Una vez conectados, los usuarios pueden enviar mensajes al servidor y recibir respuestas de eco.

## Características

- Establecimiento de conexión TCP con el servidor especificado.
- Envío de mensajes al servidor.
- Recepción de respuestas de eco del servidor.
- Gestión de errores de conexión y desconocidos.
- Finalización de la conexión mediante el mensaje "END-TCP".

## Uso

Para ejecutar el cliente, se necesita Java y el siguiente comando:

```bash
java ClientTCP <dirección_servidor> <puerto_servidor>

