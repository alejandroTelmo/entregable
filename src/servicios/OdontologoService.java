package servicios;

import daos.IDao;
import modelos.Odontologo;

import java.util.List;

public class OdontologoService implements IDao<Odontologo> {
    private IDao<Odontologo> odontologoDao;



    public OdontologoService() {

    }



    public OdontologoService( IDao<Odontologo> odontologoDao) {

        this.odontologoDao = odontologoDao;

    }



    public void setOdontologoDao( IDao<Odontologo> odontologoDao) {

        this.odontologoDao = odontologoDao;

    }



    public Odontologo guardar(Odontologo odontologo){

        odontologoDao.guardar(odontologo);

        return odontologo;

    }



    public void eliminar(Long id){

        odontologoDao.eliminar(id);

    }

    public Odontologo buscar(Long id){

        return odontologoDao.buscar(id);

    }



    public List<Odontologo> buscarTodos(){

        return odontologoDao.buscarTodos();

    }
}
