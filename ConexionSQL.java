package org.example.persistencia;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {
    private String baseDatos = "MineralesDB.db";
    public static ConexionSQL _instance;
    private Connection conexion;

    private ConexionSQL(String database) {
        this.baseDatos = database;
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:" + this.baseDatos);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConexionSQL getInstance(String baseDatos) {
        if (_instance == null) {
            _instance = new ConexionSQL(baseDatos);
        } else {
            System.out.println("Ya fué creada");
        }
        return _instance;
    }

    public Connection getConexion() {
        return conexion;
    }
}