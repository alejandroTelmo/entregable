package daos;

import modelos.Odontologo;
import  java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";

    private final static String DB_URL = "jdbc:h2:~/test";

    private final static String DB_USER ="sa";

    private final static String DB_PASSWORD = "123321";

    public OdontologoDaoH2() {
        super();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;

        PreparedStatement preparedStatement = null;



        try {

            //1 Levantar el driver y Conectarnos

            Class.forName(DB_JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);



            //2 Crear una sentencia

            preparedStatement = connection.prepareStatement("INSERT INTO odontologos VALUES(?,?,?,?)");

            preparedStatement.setLong(1,odontologo.getId());

            preparedStatement.setString(2, odontologo.getNombre());

            preparedStatement.setString(3, odontologo.getApellido());

            preparedStatement.setInt(4, odontologo.getNumeroMatricula());



            //3 Ejecutar una sentencia SQL

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {

            throwables.printStackTrace();

        }

        return odontologo;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {

            //1 Levantar el driver y Conectarnos

            Class.forName(DB_JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);



            //2 Crear una sentencia

            preparedStatement = connection.prepareStatement("DELETE FROM odontologos where id = ?");

            preparedStatement.setLong(1,id);



            //3 Ejecutar una sentencia SQL

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {

            throwables.printStackTrace();

        }




    }

    @Override
    public Odontologo buscar(Long id) {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        Odontologo odontologo = null;

        try {

            //1 Levantar el driver y Conectarnos

            Class.forName(DB_JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);



            //2 Crear una sentencia

            preparedStatement = connection.prepareStatement("SELECT id,nombre,apellido,numeroMatricula FROM odontologos where id = ?");

            preparedStatement.setLong(1,id);



            //3 Ejecutar una sentencia SQL

            ResultSet result = preparedStatement.executeQuery();



            //4 Obtener resultados

            while (result.next()) {

                Long idOdontologo = result.getLong("id");

                String nombre = result.getString("nombre");

                String apellido = result.getString("apellido");

               Integer numeroMatricula = result.getInt("numero_matricula");
                odontologo = new Odontologo(nombre, apellido,numeroMatricula);

            }



            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {

            throwables.printStackTrace();

        }



        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        List<Odontologo> odontologos = new ArrayList<Odontologo>();

        try {

            //1 Levantar el driver y Conectarnos

            Class.forName(DB_JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);



            //2 Crear una sentencia

            preparedStatement = connection.prepareStatement("SELECT *  FROM odontologos");



            //3 Ejecutar una sentencia SQL

            ResultSet result = preparedStatement.executeQuery();



            //4 Obtener resultados

            while (result.next()) {

                Integer numeroMatricula=result.getInt("numero_matricula");

                String nombre = result.getString("nombre");

                String apellido = result.getString("apellido");

                odontologos.add(new Odontologo( nombre, apellido,numeroMatricula));



            }



            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {

            throwables.printStackTrace();

        }



        return odontologos;
    }
}
