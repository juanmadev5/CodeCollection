# Flask con Tailwind

Esta es una plantilla preconfigurada para poder agregar diseño a las plantillas HTML con TailwindCSS.

> [!IMPORTANT]
> Esta plantilla fue creado usando Python 3.13.0 y NodeJS 22.13.0 aunque debería funcionar con otras versiones anteriores que sean igual o
> superior a Python 2.8 y NodeJS 12.13.0 teniendo en cuenta lo mínimo requerido para Flask y TailwindCSS.

Primero empieza instalando todo lo necesario para que Tailwind funcione, solo ejecuta lo siguiente:
``` bash
    npm install
```

Para ejecutar Flask usa lo siguiente:

### Activación del entorno y ejecución
``` bash
    python -m venv .myvenv
    .myvenv\Scripts\activate
    pip install Flask
    flask --app main run or flask --app main run --debug
```

### Desactivación
``` bash
    deactivate
```

### TailwindCSS

Puedes usar el CDN en cada plantilla `HTML` que uses pero no es recomendado para producción:
``` HTML
    <script src="https://cdn.tailwindcss.com"></script>
```

Ejecuta el siguiente comando para generar las clases necesarias:

```bash
    npx tailwindcss -i ./static/src/input.css -o ./static/dist/css/output.css --watch
```
Y no olvides enlazar el `output.css` a cada plantilla `HTML`:
``` HTML
    <link rel="stylesheet" href="{{url_for('static',filename='dist/css/output.css')}}"> 
```
