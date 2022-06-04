package tests;

import daos.IDao;
import daos.OdontologoDaoH2;
import modelos.Odontologo;
import org.junit.jupiter.api.BeforeAll;
import servicios.OdontologoService;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoTest {

    private IDao<Odontologo> odontologoDaoH2 = new OdontologoDaoH2();
    private OdontologoService odontologoService = new OdontologoService();

    public static void main(String[] args) {

    }
    @BeforeAll
    public void cargarOdontologosDAO() {

        //En este caso estudianteDAO apuntará a un objeto del tipo EstudianteDaoH2
        odontologoService.setOdontologoDao(odontologoDaoH2);
        odontologoService.guardar(new Odontologo("Luis", "Sacamuela", 123));
    }

}
