# Ejr_Nro_14_Framework_HTML
Ejercicio numero 14 de la guia de ejercicios de Java
# Consigna
Una empresa lo contrata para programar un framework que permite escribir html con
objetos de java el html que vamos a utilizar no contendrá todos los elementos del
estándar. Dicho html está formado por los siguientes tags :
a. Tag body : contiene uno o más tags pero no puede contener otro body
b. Tag p: contiene texto o un tag
c. Tag img: contiene el nombre de una imagen.
d. Tag a: contiene un link y un texto o un tag.
Por ejemplo, una página formada por estos tags pueden ser :
<body>
<p> Este es el examen de poo </p>
<img href=”nombreDeUnaImg.jpg” />
<p> Espero que hayas estudiado </p>
<a href=”http://unlink.html”>texto del link </a>
</body>
Otro ejemplo:
Con el siguiente código:
var body = new Body();
body.add(new Text("hola"));
body.add(new Text(new Text("hola")));
body.print()
Debería imprimirse:
<body>
<p> hola </p>
<p> <p> hola </p> </p>
</body>
Santa Clara, California, USA
P: +1-XXX-XXX-XXXX W: GlobalLogic.com
Realice el modelado de las clases que permitan resolver el problema. Realice los
métodos que crea convenientes para imprimir el html por pantalla.
