# OpenMOJ
Open Multimedia Over Java. Programa de dibujo y manejo de ficheros multimedia estilo *Paint* un poco más avanzado creado en JAVA.
Este repositoirio contiene el **programa principal** y una **librería de apoyo** para la gestión de la figuras.

###Características principales



####Gráficos

Se pueden dibujar hasta **9 figuras** en el lienzo. Las figuras disponibles son *trazo libre*, *segmento de linea*, *curva con un punto de control*, *curva con dos puntos de control*, *polilinea*, *rectángulo*, *rectángulo redondeado*, *elipse* y *arco*. Además pueden dibujarse texto con formato sencillo.

![](AllOpenMOJ/OpenMOJ/src/Img/Lapiz.gif)**Trazo libre**

Esta figura se compone de segmentos de linea conexos entre puntos que se van trazanado mientras el ratón hace *dragged* sobre el Lienzo. La edición sólo permite mover la figura.

![](AllOpenMOJ/OpenMOJ/src/Img/Linea.gif)**Linea**

Compuesta de dos puntos, posee dos puntos de control en los extremos de linea que permiten modificar su tamaño y posición. Esta figura puede moverse usando  cualquier otro punto que no sean puntos de control.

![](AllOpenMOJ/OpenMOJ/src/Img/cuad.png)**Curva con un punto de control**

Segmento de linea curvo con un punto de control. Modificables los extremos y el punto de control además puede moverse seleccionando la linea que forman los extremos (que no se muestran).

![](AllOpenMOJ/OpenMOJ/src/Img/cubic.png)**Curva con dos puntos de control**

Igual que la anterior pero con dos puntos de control.

![](AllOpenMOJ/OpenMOJ/src/Img/polyline.png)**Polilinea**

Se compone de lineas entre puntos que se van añadiendo al hacer click en el lienzo formando una figura general. Cada uno de los puntos es un punto de control que puede modificarse en modo edición y seleccionando cualquier parte de la figura puede moverse.

![](AllOpenMOJ/OpenMOJ/src/Img/Rectangulo.gif)**Rectángulo**

Figura que posee dos puntos de control en los extremos de su diagonal principal con los que puede modificarse. Puede moverse desde cualquier otro punto de su interior y es de las pocas a la que puede aplicársele **relleno**.

![](AllOpenMOJ/OpenMOJ/src/Img/RoundRectangulo.gif)**Rectángulo redondeado**

Igual que el rectángulo pero con los bordes redondeados.

![](AllOpenMOJ/OpenMOJ/src/Img/arc.png)**Arco**

Sección del perímetro de un círculo posee tres puntos de control con los que la figura puede moverse y además cambiar los ángulos, principio y fin, que definen el arco, así como su tamaño, definido por el radio.


![](AllOpenMOJ/OpenMOJ/src/Img/Texto.gif)**Texto**

Herramienta de creación de texto simple. Carga las fuentes del sistema y permite modificar el color, subrayar, tachar, hacer negrita y cursiva. La edición puede hacerse después de su escritura haciendo doble click sobre el texto para que la herramienta se vuelva a abrir.

![](AllOpenMOJ/OpenMOJ/src/Img/erase.png) Cualquiera de las figura **puede eliminarse** haciendo doble click con el botón derecho del ratón, habiéndo seleccionado la herramienta borrar.

![](AllOpenMOJ/OpenMOJ/src/Img/settings.png)  Se dispone de dos herramientas de edición para modificar el trazo de ls figuras y el relleno para aquellas que lo permitan. Además estas caracteristicas son propias de cada figura y de cada lienzo.


####Imagenes

El procesado de imágenes se realiza mediante módulos , herramientas externas que se abren en forma de ventana ofreciendo todos los ajustes posibles para la operación que se esté realizando a fin de no sobrecargar la GUI principal del programa.

######Lista de herramientas:

![](AllOpenMOJ/OpenMOJ/src/Img/brilloContrasteMini.png) Brillo y contraste

![](AllOpenMOJ/OpenMOJ/src/Img/negative.png) Negativo

![](AllOpenMOJ/OpenMOJ/src/Img/emborronamiento.png) Emborronamiento

![](AllOpenMOJ/OpenMOJ/src/Img/deteccionBordes.png) Detección frontera

![](AllOpenMOJ/OpenMOJ/src/Img/relieve.png) Relieve

![](AllOpenMOJ/OpenMOJ/src/Img/rotate.png) Rotar

![](AllOpenMOJ/OpenMOJ/src/Img/enfoque.png) Enfoque

![](AllOpenMOJ/OpenMOJ/src/Img/scale.png) Escalar

![](AllOpenMOJ/OpenMOJ/src/Img/umbralizacion.png) Umbralización

![](AllOpenMOJ/OpenMOJ/src/Img/grayScale.png) Escala de grises

![](AllOpenMOJ/OpenMOJ/src/Img/duplicate.png) Duplicar

![](AllOpenMOJ/OpenMOJ/src/Img/plus_subtraction.png) Operaciones binarias

![](AllOpenMOJ/OpenMOJ/src/Img/seno.png) Función seno



####Audio

Posee un reproductor simple de ficheros de audio.

####Video

Posee un reproductor simple de ficheros de video y la posibilidad de realizar capturas de medios como la webcam.



##Capturas del programa

Ejemplos de uso:

1.Edición de texto y de figuras:

![](AllOpenMOJ/Img/a.png)

2.Uso de herramientas para imagen:

![](AllOpenMOJ/Img/b.png)

3.Herramientas para definición de trazado y relleno:

![](AllOpenMOJ/Img/c.png)


##Licencia y publicación

**Programa bajo licencia [GPLv3](http://www.gnu.org/licenses/gpl-3.0.en.html).**

**Se agradece toda colaboración y contribución.**


######Publicado en GitHub (+doc en linea):
https://github.com/juanAFernandez/sistemasMultimediaJava
