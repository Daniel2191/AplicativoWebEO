package co.edu.poli.ppi.eficienciaorganizacional.entidades;

public class GdSdTr implements RegistrosServicios{

    private int codigo;
    private int entidad;
    private String descripcion;

    public GdSdTr (int numreg, int entidad){
        int codigo;
        codigo = numreg*entidad;
        this.codigo = codigo;
        this.entidad = entidad;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getEntidad() {
        String ent;
        if(entidad==1){
            ent="Alcaldia de Betania";
        }else if(entidad==2){
            ent="EPMB";
        }else if(entidad==3){
            ent="Alcaldia de Hispania";
        }else {
            ent="EPH";
        }
        return ent;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public String toString(){
        return codigo + " Area de Gobierno y Seguridad Digital y Ley de Transparencia"
                + " Codigo entidad " + entidad
                + " Actividad " + (descripcion);
    }

    public void setEntidad(int entidad1, String entidad) {

        String ent;
        int nuevocodigo = this.codigo;
        if(entidad=="EPH"){
            nuevocodigo = nuevocodigo/4;
        }else if(entidad=="EPMB"){
            nuevocodigo = nuevocodigo/2;
        }else if(entidad=="Alcaldia de Hispania"){
            nuevocodigo = nuevocodigo/3;
        }

        nuevocodigo = nuevocodigo*entidad1;

        this.entidad = entidad1;
        this.codigo = nuevocodigo;
    }
}
