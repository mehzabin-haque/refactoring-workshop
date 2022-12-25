package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {
    String source;
    int i;
    List<String> result;
    List<String> convertedLine;
    String characterToConvert;

    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    protected String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get("sample.txt")));
    }



    private String basicHtmlEncode(String source) {
        this.source = source;
        i = 0;
        result = new ArrayList<>();
        convertedLine = new ArrayList<>();
        characterToConvert = stashNextCharacterAndAdvanceThePointer();

        while (i <= this.source.length()) {

            for(Character c : Character.values()){
                if(characterToConvert.equals(c.symbol)) {
                    convertedLine.add(c.output);
                }
                
            }

            if(checkIfNotInEnum(characterToConvert) == false){
                convertedLine.add(characterToConvert);
            }


            if (i >= source.length()) break;

            characterToConvert = stashNextCharacterAndAdvanceThePointer();
        }
        
        addANewLine();
        String finalResult = String.join("<br />", result);
        return finalResult;
    }


    private String stashNextCharacterAndAdvanceThePointer() {
        char c = source.charAt(i);
        i += 1;
        return String.valueOf(c);
    }

    private void addANewLine() {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
    }

    private boolean checkIfNotInEnum(String input){
       
        for(Character c : Character.values()){
            if(input.equals(c.symbol)){
                return true;
            }
        }

        return false;
    }
}
