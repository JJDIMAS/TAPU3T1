
package com.T1;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class DataBaseManager {
    public String query;
  private Connection conexion;
    private Statement sentencia;  
    public DataBaseManager()throws Exception{
    Class.forName("com.mysql.jdbc.Driver");
    conexion= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cinetec","root",null);
    sentencia = (Statement) conexion.createStatement();
    }
   public ArrayList<String>ShowAll()throws Exception{
   String qry= "SELECT * FROM peliculas";
   ResultSet rs= sentencia.executeQuery(qry);
   ArrayList<String> resultados= new ArrayList<>();
   while(rs.next()){
   resultados.add(rs.getString("nombre")+"/"+rs.getString("genero")+"/"+rs.getString("dir"));
   }
  return resultados; }
     public ArrayList<String>Salas()throws Exception{
   String qry= "SELECT * FROM sala";
   ResultSet rs= sentencia.executeQuery(qry);
   ArrayList<String> resultados= new ArrayList<>();
   while(rs.next()){
   resultados.add(rs.getString("ID_Sala")+"-"+rs.getInt("butacas")+"-"+rs.getString("tipo"));
   }
  return resultados; }
   public ArrayList<String>Total()throws Exception{
   String qry= "SELECT * FROM peliculas";
   ResultSet rs= sentencia.executeQuery(qry);
   ArrayList<String> resultados= new ArrayList<>();
   while(rs.next()){
   resultados.add(rs.getString("ID_Pelicula")+"-"+rs.getString("nombre")+"-"+rs.getString("director")
   +"-"+rs.getInt("duracion")+"-"+rs.getString("genero")+"-"+rs.getString("clasificacion")+"-"+rs.getString("sala")
   +"-"+rs.getString("dir"));
   }
  return resultados; }
   public ArrayList<String>Venta()throws Exception{
   String qry= "SELECT * FROM sala";
   ResultSet rs= sentencia.executeQuery(qry);
   ArrayList<String> resultados= new ArrayList<>();
   while(rs.next()){
   resultados.add(String.valueOf(rs.getInt("butacas"))+String.valueOf(rs.getInt("reservadas")));
   }
  return resultados; }
   public ArrayList<String>Nombres()throws Exception{
   String qry= "SELECT * FROM peliculas";
   ResultSet rs= sentencia.executeQuery(qry);
   ArrayList<String> resultados= new ArrayList<>();
   while(rs.next()){
   resultados.add(rs.getString("nombre"));
   }
  return resultados; }
public void altas(String q) throws Exception{
    sentencia.executeUpdate(q);
}
public void modificar(String q)throws Exception{
sentencia.executeUpdate(q);
}
public void Eliminar(String q)throws Exception{
sentencia.executeUpdate(q);
}
public String ActSala(String q)throws Exception{
ResultSet rs=sentencia.executeQuery(q);
rs.next();
String u=rs.getString("sala");
return u;}
public String ActSala2(String q)throws Exception{
ResultSet rs=sentencia.executeQuery(q);
rs.next();
String u=rs.getString("reservadas");
return u;}
}
