package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.*;
// import play.libs.Json;
import play.libs.*;
import play.mvc.*;
import play.api.*;
import play.http.*;
import play.libs.F;
import play.mvc.Action;
import java.lang.reflect.Method;
import java.util.Map;

import play.libs.Json;
import play.libs.Json.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// import play.mvc.Http.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

public class TestController extends Controller {

    // Http.Request request
    public Result index(Http.Request request) {
        // return ok("hi");
        String fileCount = "";
        String prettyJson = "";
        JsonNode json = request.body().asJson();
        ObjectMapper mapper = new ObjectMapper();
        if (json == null) {
            return badRequest("Expecting Json data");
        } else {
            String id = json.findPath("id").textValue();
            String message = json.findPath("message").textValue();
            int count = countWords(message);

            
            JsonNode rootNode = mapper.createObjectNode();
            ((ObjectNode) rootNode).put("count", count);

            if (id == null) {
                return badRequest("Missing parameter [id]");
            } else {
                
                ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
                try {

                    String jsonStringCount = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
                    writer.writeValue(new File(
                            "/Users/thomasward/code/play-samples-play-java-hello-world-tutorial/app/common/count.json"),
                            jsonStringCount);
                } catch (Exception e) {

                }

                return ok("id: " + id + " count: " + String.valueOf(count));
            } // end if else
        }

    }// end index

    // method to count words in string
    public static int countWords(String s) {

        int wordCount = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            // if the char is a letter, word = true.
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
                // if char isn't a letter and there have been letters before,
                // counter goes up.
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
                // last word of String; if it doesn't end with a non letter, it
                // wouldn't count without this.
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }

}// end class
