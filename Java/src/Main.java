
import javax.swing.JOptionPane;

public class Main
{
    public static void mostrarVector(Ordenamiento obj)
    {
        String datosVector = "";
        for (int i = 0; i < obj.getTamano(); i++)
        {
            datosVector = datosVector+String.valueOf("ID: " + obj.getVectorDocentes(i).getId() + "\n" +
                    "Nombre: " + obj.getVectorDocentes(i).getNombre() + "\n" +
                    "Asignatura: " + obj.getVectorDocentes(i).getAsignatura() + "\n" +
                    "Numero telefonico: " + obj.getVectorDocentes(i).getNumeroTelefono() + "\n\n");
        }
        JOptionPane.showMessageDialog(null, "============ ELEMENTOS DEL VECTOR ============" + "\n" + datosVector);
    }
    public static void llenar(Docentes est)
    {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite ID del docente:"));
        est.setId(id);
        String nom = JOptionPane.showInputDialog("Digite nombre del docente:");
        est.setNombre(nom);
        String asig =JOptionPane.showInputDialog("Digite la asignatura del docente:");
        est.setAsignatura(asig);
        int tel = Integer.parseInt(JOptionPane.showInputDialog("Digite número telefonico del docente:"));
        est.setNumeroTelefono(tel);
    }
    public static int menu()
    {
        int opcion = 0;
        do
        {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("====== MENU ====== \n" +
                "1. Buscar docente mediante el ID\n" +
                "2. Buscar docente mediante el número telefonico\n" +
                "3. Ordenar por Nombres \n" +
                "4. Ordenar por Asignaturas\n" +
                "5. Salir \n\n" +
                "Seleccione una opcion del 1 al 5"));
        }
        while(opcion <= 0 || opcion > 5);
        return opcion;
    }
     public static void main(String[] args)
     {
        Ordenamiento obj = new Ordenamiento();
        Docentes est;
        int numeroElementos = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el número de elementos del vector:"));
        obj.setTamano(numeroElementos); // se pasa el dato capturado al respectivo metodo modificador.
        // se llama al metodo que crea el vector en tiempo de ejecución.
        obj.crearVector();
        for(int i = 0; i < obj.getTamano(); i++)
        {
            est = new Docentes();
            JOptionPane.showMessageDialog(null, "============ DOCENTES ============" + "\n \n" +
                    "Ingresar la Informacón del estudiante (" + (i+1) + ")");
            llenar(est);
            obj.setVectorDocentes(i, est);
        }
        mostrarVector(obj);
        int datoBuscar; 
        int posicionDato; 
        int opcion;
        do{
            opcion = menu();
            switch(opcion) {
            case 1:
                datoBuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el ID del docente que desea buscar:"));
                posicionDato = obj.bsuquedaBinaria(datoBuscar);
                if(posicionDato != -1)
                {
                    JOptionPane.showMessageDialog(null, "Nombre: " + obj.getVectorDocentes(posicionDato).getNombre() + "\n" +
                    "Asignatura: " + obj.getVectorDocentes(posicionDato).getAsignatura() + "\n" +
                    "Numero de telefono: " + obj.getVectorDocentes(posicionDato).getNumeroTelefono());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El docente no se encuentra en el vector");
                }
                break;
            case 2:
                datoBuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el numero del docente que desea buscar:"));
                posicionDato = obj.busquedaLineal(datoBuscar);
                if(posicionDato != -1)
                {
                    JOptionPane.showMessageDialog(null, "Nombre: " + obj.getVectorDocentes(posicionDato).getNombre() + "\n" +
                    "Asignatura: " + obj.getVectorDocentes(posicionDato).getAsignatura() + "\n" +
                    "Numero de telefono: " + obj.getVectorDocentes(posicionDato).getNumeroTelefono());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El docente no se encuentra en el vector");
                }
                break;    
            case 3:
                obj.ordenarShell();
                mostrarVector(obj);
                break;
            case 4:
                obj.ordenarIntercambio();
                mostrarVector(obj);
                break;
            default:
                break;
            }
        }while(opcion != 5);
    }
}
