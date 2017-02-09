public class Docentes
{
    private int id;
    private String nombre;
    private String asignatura;
    private int num_telefono;
    
    public Docentes()
    {
        id = 0;
        String nombre = "";
        String asignatura = "";
        num_telefono = 0;
    }
    public void setId(int val)
    {
        id = val;
    }
    public void setNombre(String val)
    {
        nombre = val;
    }
    public void setAsignatura(String val)
    {
        asignatura = val;
    } 
    public void setNumeroTelefono(int val)
    {
        num_telefono = val;
    }
    public int getId()
    {
        return id;
    }
    public String getNombre()
    {
        return nombre;
    }
    public String getAsignatura()
    {
        return asignatura;
    }
    public int getNumeroTelefono()
    {
        return num_telefono;
    }
}
