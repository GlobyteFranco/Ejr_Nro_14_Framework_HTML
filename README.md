# Ejr_Nro_14_Framework_HTML
Ejercicio numero 14 de la guia de ejercicios de Java
# Consigna
Una empresa lo contrata para programar un framework que permite escribir html con
objetos de java el html que vamos a utilizar no contendrá todos los elementos del
estándar. Dicho html está formado por los siguientes tags :
b. Tag p: contiene texto o un tag
d. Tag a: contiene un link y un texto o un tag.
a. Tag body : contiene uno o más tags pero no puede contener otro body
c. Tag img: contiene el nombre de una imagen.
Por ejemplo, una página formada por estos tags pueden ser :
<img href=”nombreDeUnaImg.jpg” />
<p> Espero que hayas estudiado </p>
<a href=”http://unlink.html”>texto del link </a>
</body>"
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
Realice el modelado de las clases que permitan resolver el problema. Realice los
métodos que crea convenientes para imprimir el html por pantalla.

# TESTING
Vamos a intentar probar todas las combinaciones posibles de tags (hasta el punto donde podaoms extender la verdad hasta el infinito o hasta que se rompa el stack trace)

