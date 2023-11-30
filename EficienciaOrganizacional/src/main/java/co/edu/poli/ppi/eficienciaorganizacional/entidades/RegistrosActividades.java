package co.edu.poli.ppi.eficienciaorganizacional.entidades;

import java.util.HashMap;

public class RegistrosActividades {

    private HashMap<Integer, RegistrosServicios> registros;

    private int siguienteRegistro;

    public RegistrosActividades(){
        this.registros = new HashMap();
        this.siguienteRegistro = 1000;
    }

    public int nuevoRegistro(int area, int entidad, String descripcion){
        int numreg = this.siguienteRegistro++;
        RegistrosServicios reg_ser;
        if(area == 1){
            reg_ser = new GdSdTr(numreg, entidad);
        } else if(area == 2){
            reg_ser = new SgSst(numreg, entidad);
        } else{
            reg_ser = new Mipg(numreg, entidad);
        }
        reg_ser.setDescripcion(descripcion);
        numreg = numreg*entidad;
        this.registros.put(numreg, reg_ser);
        return numreg;
    }

    public HashMap<Integer, RegistrosServicios> getRegistros() {
        return registros;
    }

    public void setEntidad (int codigo, int entidad1, String entidad){
        RegistrosServicios rs = this.registros.get(codigo);
        rs.setEntidad(entidad1, entidad);
    }

    public void setDescripcion (int codigo,String descripcion){
        RegistrosServicios rs = this.registros.get(codigo);
        rs.setDescripcion(descripcion);
    }

}
