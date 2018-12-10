Para ejecutar el el experimento se debe ingresar a la carpeta src/experiment

se debe compilar la clase Experiment: 
```
$ javac Experiment.java
```

y luego ejecutar con los parametros deseados:
el primer parametro corresponde al tipo de Dijkstra que se desea usar y
el segundo parametro corresponde al factor e (que puede ser 10, 100 o 1000)
donde la cantidad de aristas corresponde a e*n, n son la cantidad de nodos


Si se quiere usar el algorito naive con factor e = 10:

```
$ java Experiment naive 10
```

Classic heap con factor e = 0: 

```
$ java Experiment classicHeap 10
```

Fibonacci Queue con factor factor e = 0:

```
$ java Experiment fiboQueue 10
```

Hice todo en Eclipse, se recomienda probarlo usando eclipse.