/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Question;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sandra
 */
public class DAOQuestion implements DAO<Question> {
       private final String table= "question";

    @Override
    public Question find(Integer id) {
    Question retObj=null;
       String sql = "SELECT * FROM "
               + table
               + " WHERE id_question= ?";
        try
        {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first())
            {
                retObj = new Question(id,result.getString("question"), result.getString("answer"), result.getInt("level"));
            }
        } catch (SQLException ex)
            {
               Logger.getLogger(DAOQuestion.class.getName()).log(Level.SEVERE, null, ex);
            }
        return retObj;
    }    

    @Override
    public Question create(Question obj) {
        Question retObj=null;
        // requete SQL : Attention aux espaces !
        String sql = "INSERT INTO "
               + table
               + " (question,answer) "
               + " VALUES (?,?,?) ";
        
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,obj.getQuestion());
            pstmt.setString(2,obj.getAnswer());
            pstmt.setInt(3,obj.getLevel());
            //il va generer la clef automatiquement pour qu'on puisse plus tard identifier le nv object
            pstmt.executeUpdate(); 
            ResultSet generateKeys = pstmt.getGeneratedKeys();
            if (generateKeys.first())
            {
                //Deux methodes : 
                //1 : obj.setId_personne(generateKeys.getInt(1));
                //1 c'est la colonne dans laquelle il doit aller chercher l'info
                retObj= this.find(generateKeys.getInt(1));
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(DAOQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    
    }

    @Override
    public void delete(Question obj) {
        String sql= "DELETE FROM " +table+ " WHERE id_question=?";
        try {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            pstmt.setInt(1, obj.getId_question());
            int nb_ligne = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

@Override
    public Question update(Question obj) {
        Question retObj = null;
        String sql= " UPDATE " + table + " SET question=?, " 
                +" answer=?,"
                +" level=?, "
                +" WHERE id_question=? ";
        
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
      
      pstmt.setString(1,obj.getQuestion());
      pstmt.setString(2,obj.getAnswer());
      pstmt.setInt(3,obj.getLevel());

      pstmt.setInt(4,obj.getId_question());
      pstmt.executeUpdate();
      
      retObj=find(obj.getId_question());
      
      
        } catch (SQLException ex) {
            Logger.getLogger(DAOQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    }

    @Override
    public List<Question> findAll() {
        ArrayList<Question> retObj= new ArrayList<>(); 
       String sql = "SELECT * FROM "
               + table;
        try
        {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            while (result.next())
            {
                retObj.add(new Question(result.getInt("id_question"), result.getString("question"),
                        result.getString("answer"),result.getInt("level")));
            }
        } catch (SQLException ex)
            {
               Logger.getLogger(DAOQuestion.class.getName()).log(Level.SEVERE, null, ex);
            }
        return retObj;
    }

    @Override
    public List<Question> findByLevel(Integer lvl) {
               ArrayList<Question> retObj= new ArrayList<>(); 
       String sql = "SELECT * FROM "
               + table
               + " WHERE level <= ? ";
                
           try {
              PreparedStatement pstmt = connection.prepareStatement(sql);
              pstmt.setInt(1, lvl);
              ResultSet result = pstmt.executeQuery();
              while (result.next())
            {
                retObj.add(new Question(result.getInt("id_question"), result.getString("question"),
                        result.getString("answer"),result.getInt("level")));
            }
           } catch (SQLException ex) {
               Logger.getLogger(DAOQuestion.class.getName()).log(Level.SEVERE, null, ex);
           }
           return retObj;
    }
    

    
}
