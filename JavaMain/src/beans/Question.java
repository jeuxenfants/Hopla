/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Sandra
 */
public class Question {
    private Integer id_question;
    private Integer level;
    private String question;
    private String answer;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    
    
    
    public Question(Integer id_question, String question, String answer, Integer level) {
        this.id_question = id_question;
        this.question = question;
        this.answer = answer;
        this.level= level;
    }
    
    public Integer getId_question() {
        return id_question;
    }

    public void setId_question(Integer id_question) {
        this.id_question = id_question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }    
    
}
