package model;

import javafx.util.Pair;

public class LexicalAnalyzer {

    private StringBuffer sourceString;
    private int index;
    private StringBuffer token;
    private String currentToken;
    private char currentChar;

    public LexicalAnalyzer(String sourceString){
        this.sourceString = new StringBuffer(sourceString);

        this.sourceString.append("\\0");
        this.index = 0;
    }


    public Pair<String, Short> getNextToken(){
        token = new StringBuffer();
        Short value = 0;
        currentChar = sourceString.charAt(index);

        if(currentChar > 'a' && currentChar <'z' || currentChar >'A' && currentChar < 'Z'){
            value = 1;
            nextChar();
            while(currentChar >= 'a' && currentChar <='z' || currentChar >= 'A' && currentChar <= 'Z' || currentChar >= '0' && currentChar <= '9' || currentChar == '-' || currentChar == '_'){
                nextChar();
            }

        }

        else if(currentChar > '0' && currentChar <'9'){
            value = 2;
            nextChar();
            while(currentChar > 0 && currentChar < '9'){
                nextChar();
            }

        }

        else if(currentChar == '-' || currentChar == '*' || currentChar == '/' || currentChar == '+'){
            value = 3;
            nextChar();
        }
        else if(currentChar == '\\'){
            value = -1;
            if(sourceString.charAt(index+1) == '0')
                return new Pair<String, Short>("\\0", value);
        }

        else
            nextChar();

        currentToken = token.toString();
        return new Pair<String, Short>(currentToken, value);
    }

    private void nextChar(){
        token.append(currentChar);
        currentChar = sourceString.charAt(++index);
    }


    public static void main(String[]args){
        LexicalAnalyzer lex = new LexicalAnalyzer("HolaMUndo321-123;3");
        System.out.println(lex.getNextToken().getValue());
        System.out.println(lex.getNextToken().getValue());
        System.out.println(lex.getNextToken().getValue());
        System.out.println(lex.getNextToken().getValue());
        System.out.println(lex.getNextToken().getValue());
        System.out.println(lex.getNextToken().getValue());
        System.out.println(lex.getNextToken().getValue());
        System.out.println(lex.getNextToken().getValue());

    }



}
