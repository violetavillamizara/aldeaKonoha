/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.aldea;

import com.mycompany.aldea.modelo.Mision;
import com.mycompany.aldea.modelo.MisionDAO;
import com.mycompany.aldea.modelo.MisionNinja;
import com.mycompany.aldea.modelo.Ninja;
import com.mycompany.aldea.modelo.NinjaDAO;
import com.mycompany.aldea.persistencia.Operaciones;
import com.mycompany.aldea.persistencia.conexionBD;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Aldea {

    public static void main(String[] args) {
        Operaciones.setConexion(conexionBD.MySQLConnection());
        List<Mision> misiones = new ArrayList();
        Mision mision = new Mision();
        MisionDAO controller = new MisionDAO();

        misiones = controller.getAllMisiones();

        for (Mision misione : misiones) {
            System.out.println(misione.getMisionID() + " " + misione.getDescripcion() + " " + misione.getRango());
        }

        Ninja ninja1 = new Ninja(6L, "viole", "6", "Java");
        NinjaDAO ninjaDAO = new NinjaDAO();

        //ninjaDAO.insertNinja(ninja1);
        
        List<Ninja> ninjas = new ArrayList();
        ninjas = ninjaDAO.getAllNinjas();

        for (Ninja ninj : ninjas) {
            System.out.println(ninj.getNombre() + " " + ninj.getAldea() + " " + ninj.getRango());
        }

//        ninjaDAO.deleteNinja(6L);
        
        List<MisionNinja> misionesNull = new ArrayList();
        misionesNull = controller.misionesDisponibles();

        for (MisionNinja mision1 : misionesNull) {
            System.out.println(mision1.getId() + " " + mision1.getMisionID() + " " + mision1.getNinjaID() + " " + mision1.getFecha_inicio() + " " + mision1.getFecha_fin());
        }
        
        
//        MisionNinja misionN = new MisionNinja(6L, 4L, 2L, "2024,01,01", "2024-11-11");
//        MisionDAO misionDAO = new MisionDAO();
//        
//        misionDAO.insertMision(misionN);
        
        List<MisionNinja> misionesNoNull = new ArrayList();
        misionesNoNull = controller.misionesCompletadas();
        for (MisionNinja mision2 : misionesNoNull) {
            System.out.println(mision2.getId() + " " + mision2.getMisionID() + " " + mision2.getNinjaID() + " " + mision2.getFecha_inicio() + " " + mision2.getFecha_fin());
        }
    }
}
