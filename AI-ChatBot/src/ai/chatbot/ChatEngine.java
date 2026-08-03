
package ai.chatbot;
import java.util.ArrayList;
import java.util.List;
 
public class ChatEngine {
 
    private List<ResponseRule> rules;
 
    public ChatEngine() {
        rules = new ArrayList<>();
        loadRules();
    }
 
    private void loadRules() {
 
        // Greetings
        rules.add(new ResponseRule("Greeting",
            new String[]{"hello", "hi", "hey", "howdy", "greetings", "good morning", "good evening"},
            new String[]{
                "Hello! How can I help you today? 😊",
                "Hey there! What's on your mind?",
                "Hi! Great to see you. Ask me anything!"
            }
        ));
 
        // Farewells
        rules.add(new ResponseRule("Farewell",
            new String[]{"bye", "goodbye", "see you", "take care", "farewell", "quit", "exit"},
            new String[]{
                "Goodbye! Have a wonderful day! 👋",
                "Take care! Come back anytime.",
                "See you later! Stay awesome 😄"
            }
        ));
 
        // How are you
        rules.add(new ResponseRule("Status",
            new String[]{"how are you", "how do you do", "how's it going", "what's up"},
            new String[]{
                "I'm doing great, thanks for asking! How about you?",
                "All systems running smoothly! What can I do for you?",
                "I'm just a chatbot, but I'm feeling fantastic! 😄"
            }
        ));
 
        // Name
        rules.add(new ResponseRule("Identity",
            new String[]{"your name", "who are you", "what are you", "what's your name"},
            new String[]{
                "I'm JavaBot — a friendly AI assistant built in Java! 🤖",
                "My name is JavaBot. Nice to meet you!",
                "You can call me JavaBot. I'm here to help!"
            }
        ));
 
        // Java questions
        rules.add(new ResponseRule("Java",
            new String[]{"java", "jvm", "spring", "maven", "gradle", "class", "object oriented"},
            new String[]{
                "Java is a powerful, object-oriented programming language. It runs on the JVM, making it platform-independent.",
                "Java was created by James Gosling at Sun Microsystems in 1995. It follows the OOP paradigm.",
                "Java supports multithreading, garbage collection, and a rich standard library — perfect for enterprise apps!"
            }
        ));
 
        // Weather
        rules.add(new ResponseRule("Weather",
            new String[]{"weather", "temperature", "rain", "sunny", "forecast"},
            new String[]{
                "I don't have real-time weather data, but you can check weather.com for accurate forecasts! 🌤️",
                "For weather updates, try Google Weather or a local weather app!",
                "I wish I could check outside! Try a weather website for current conditions. ☔"
            }
        ));
 
        // Time / Date
        rules.add(new ResponseRule("DateTime",
            new String[]{"time", "date", "today", "what day", "current time"},
            new String[]{
                "The current date and time is: " + new java.util.Date(),
                "Right now it's: " + new java.util.Date()
            }
        ));
 
        // Math / calculate
        rules.add(new ResponseRule("Math",
            new String[]{"calculate", "math", "compute", "equation", "solve"},
            new String[]{
                "I can do simple math! Just type something like '5 + 3' and I'll calculate it for you.",
                "Give me a math expression like '10 * 4' or '20 / 5' and I'll solve it!"
            }
        ));
 
        // Joke
        rules.add(new ResponseRule("Joke",
            new String[]{"joke", "funny", "laugh", "humor"},
            new String[]{
                "Why do Java developers wear glasses? Because they don't see sharp! 😂",
                "Why did the programmer quit? Because they didn't get arrays! 🤣",
                "A SQL query walks into a bar, walks up to two tables and asks... 'Can I JOIN you?' 😄"
            }
        ));
 
        // Thank you
        rules.add(new ResponseRule("Gratitude",
            new String[]{"thank", "thanks", "appreciate", "grateful"},
            new String[]{
                "You're welcome! 😊 Happy to help.",
                "Anytime! That's what I'm here for.",
                "Glad I could help! Let me know if you need anything else."
            }
        ));
 
        // Help
        rules.add(new ResponseRule("Help",
            new String[]{"help", "what can you do", "commands", "options", "features"},
            new String[]{
                "I can chat with you, answer questions about Java, tell jokes, show the time, and more! Just ask. 😊",
                "Try asking me: 'Tell me a joke', 'What is Java?', 'What time is it?', or just say hello!"
            }
        ));
    }
 
    public ChatResponse processInput(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return new ChatResponse("empty", "Please type something! I'm listening. 👂", "Unknown");
        }
 
        // Try to detect simple math expression first
        if (isMathExpression(userInput.trim())) {
            return evaluateMath(userInput.trim());
        }
 
        // Match against rules
        for (ResponseRule rule : rules) {
            if (rule.matches(userInput)) {
                return new ChatResponse(userInput, rule.getRandomResponse(), rule.getCategory());
            }
        }
 
        // Default fallback
        return new ChatResponse(userInput,
            "Hmm, I'm not sure about that. Could you rephrase? Or type 'help' to see what I can do! 🤔",
            "Unknown"
        );
    }
 
    private boolean isMathExpression(String input) {
        return input.matches("[\\d\\s+\\-*/().]+");
    }
 
    private ChatResponse evaluateMath(String expression) {
        try {
            // Basic eval using Java's ScriptEngine
            javax.script.ScriptEngineManager manager = new javax.script.ScriptEngineManager();
            javax.script.ScriptEngine engine = manager.getEngineByName("JavaScript");
            Object result = engine.eval(expression);
            return new ChatResponse(expression, "🧮 Result: " + expression + " = " + result, "Math");
        } catch (Exception e) {
            return new ChatResponse(expression, "I couldn't calculate that. Please check the expression.", "Math");
        }
    }
}