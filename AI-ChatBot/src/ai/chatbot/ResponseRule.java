/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ai.chatbot;

/**
 *
 * @author Ahsan Khalid
 */
public class ResponseRule {
     private String[] keywords;   // any of these trigger this rule
    private String[] responses;  // randomly picks one of these
    private String category;
 
    public ResponseRule(String category, String[] keywords, String[] responses) {
        this.category  = category;
        this.keywords  = keywords;
        this.responses = responses;
    }
 
    public boolean matches(String input) {
        String lower = input.toLowerCase();
        for (String keyword : keywords) {
            if (lower.contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
 
    // Pick a random response from the available options
    public String getRandomResponse() {
        int index = (int) (Math.random() * responses.length);
        return responses[index];
    }
 
    public String getCategory() { return category; }
    public String[] getKeywords() { return keywords; }

}
