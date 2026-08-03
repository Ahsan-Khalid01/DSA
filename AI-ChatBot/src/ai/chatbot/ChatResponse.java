/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ai.chatbot;

/**
 *
 * @author Ahsan Khalid
 */
public class ChatResponse {
    private String matchedKeyword;
    private String responseText;
    private String category;
 
    public ChatResponse(String matchedKeyword, String responseText, String category) {
        this.matchedKeyword = matchedKeyword;
        this.responseText = responseText;
        this.category = category;
    }
 
    public String getMatchedKeyword() { return matchedKeyword; }
    public String getResponseText()   { return responseText; }
    public String getCategory()       { return category; }

}
