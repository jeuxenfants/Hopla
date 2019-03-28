/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.MySQLConnection;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Sandra
 */
public interface DAO<T> {
    Connection connection = MySQLConnection.getInstance();
    
    /**
     * 
     * @param id identifiant de l'objet qu'on cherche
     * @retur object
     */
    T find(Integer id);
    /**
     * 
     * @param obj cree un nouveau objet de type T dans la database
     * @return l'objet 
     */
    
    T create(T obj);
    

    
    /**
     * 
     * @param obj supprime l'objet passer en parametre de la database 
     */
    
    void delete(T obj);
    
    /**
     * 
     * @param obj met a jour l'objet passer en parametre dans la database
     * @return l'objet 
     */
    T update (T obj);
    /**
     * 
     * @return une liste de tout les objets dans la database
     */
    List<T> findAll();
    
    public List<T> findByLevel(Integer lvl);
    

}
