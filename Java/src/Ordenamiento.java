public class Ordenamiento
{
    // se define un atributo para asignar el tamaño que tendrá el vector.
    int tamano;
    
    private Docentes vectorDocentes[];
    // Docentes vectorEstudiantes[20]; Esta seria forma de declarar el vector de objetos con tamaño fijo.
    
    public Ordenamiento()
    {
        tamano = 0;
        vectorDocentes = null;
    }
    public void crearVector()
    {
        vectorDocentes = new Docentes[tamano];
    }
    
    // métodos modificadores y selectores para asignar y obtener el tamaño del vector.
    public void setTamano(int val)
    {
        tamano = val;
    }
    public int getTamano()
    {
        return tamano;
    }
    
    // los métodos modificadores y selectores para agregar información al vector y obtener elementos del vector.
    //sSe pasan como parámetros la posición (dato entero) y un objeto de la clase Estudiantes (obj).
    public void setVectorDocentes(int p, Docentes obj)
    {
        vectorDocentes[p] = obj;
    }
    
    public Docentes getVectorDocentes(int p)
    {
        return vectorDocentes[p];
    }
    public void cambiar(int p1, int p2)
    {
        Docentes temp;
        temp = getVectorDocentes(p1);
        setVectorDocentes(p1, getVectorDocentes(p2));
        setVectorDocentes(p2, temp);
    }
     public void ordenarShell()
     {
        int n, cont;
        n = (getTamano()-1)/2;
        while (n != 0)
        {
            cont = 1;
            while (cont != 0)
            {
                cont = 0;
                for (int i = n; i < getTamano(); i++)
                {
                    if (getVectorDocentes(i-n).getNombre().compareTo(getVectorDocentes(i).getNombre()) > 0){
                        cambiar(i, i-n);
                        cont = cont + 1;
                    }
                }
            }
            n = n/2;
        }
    }
     public void ordenarIntercambio()
     {
        for (int i = 0; i < getTamano(); i++)
        {
            for (int j = i+1; j < getTamano(); j++)
            {
                if (getVectorDocentes(i).getAsignatura().compareTo(getVectorDocentes(j).getAsignatura()) > 0)
                {
                    cambiar(i, j);
                }
            }
        }
    }
    public void ordenarBurbuja()
    {
        for (int i=0; i < getTamano(); i++)
        {
            for (int j = 0; j < getTamano()-2; j++)
            {
                if (getVectorDocentes(j).getId() > getVectorDocentes(j+1).getId())
                {
                    cambiar(j, j+1); 
                }
            }
        }
    }
    
    public int bsuquedaBinaria(int dato)
    {
        int posicion, izq, der, centro; // estas 4 variables almacenan posiciones del vector.
        ordenarBurbuja(); // para realizar la busqueda el vector primero debera estar ordenado.
        izq = 0; // primera posición del vector
        der = getTamano()-1; // ultima posición del vector
        posicion = -1;
        while ((izq <= der) && (posicion == -1))
        {
            centro = (izq + der) / 2;
            if (dato == (getVectorDocentes(centro).getId()))
            {
                posicion = centro;
            }
            else
            {
                if (dato < (getVectorDocentes(centro).getId()))
                {
                    der = centro-1;
                }
                else
                {
                    izq = centro+1;
                }
            }
        }
        return posicion;
    }
    
    public int busquedaLineal(int dato)
    {
        int i; // variable para controlar el ciclo while.
        int posicion; /* variable que devuelve la posición en la que se encuentra el elemento buscado en el vector.
                       * se Asigna el valor de -1 a la variable posición para devolver este valor en el supuesto caso de que no se
                       * encuentre el valor buscado dentro del vector.
                       */
        posicion = -1;
        i = 0;
        // mientra que no se llegue al final del vector y no se haya encontrado el dato buscado en el vector.
        while ((i <= getTamano()-1) && (posicion == -1))
        {
            // si el contenido del vector en la posición i-esima es igual al dato que se esta buscando, entonces el dato si
            // esta en el vector y se devuelve la posición en donde se encuentra el dato dentro del vector. Sino que el dato, no
            // se encuentra en esa posición, y se incrementa la posición (i) para una nueva comparación.
            if (getVectorDocentes(i).getNumeroTelefono() == dato)
            {
                posicion=i;
            }
            else
            {
                i = i+1;
            }
        }
        return posicion;
    }
}