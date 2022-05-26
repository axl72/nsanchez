package model;

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


    public String getNextToken(){
        token = new StringBuffer();

        currentChar = sourceString.charAt(index);

        if(currentChar > 'a' && currentChar <'z' || currentChar >'A' && currentChar < 'Z'){
            nextChar();

            while(currentChar >= 'a' && currentChar <='z' || currentChar >= 'A' && currentChar <= 'Z' || currentChar >= '0' && currentChar <= '9' || currentChar == '-' || currentChar == '_'){
                nextChar();
            }

        }

        else if(currentChar > '0' && currentChar <'9'){
            nextChar();
            while(currentChar > 0 && currentChar < '9'){
                nextChar();
            }

        }

        else if(currentChar == '-' || currentChar == '*' || currentChar == '/' || currentChar == '+'){
            nextChar();
        }
        else if(currentChar == '\\'){
            if(sourceString.charAt(index+1) == '0')
                return "\\0";
        }

        else
            nextChar();

        currentToken = token.toString();
        return currentToken;
    }

    private void nextChar(){
        token.append(currentChar);
        currentChar = sourceString.charAt(++index);
    }


    public static void main(String[]args){
        LexicalAnalyzer lex = new LexicalAnalyzer("HolaMUndo321-123;3");
        System.out.println(lex.getNextToken());
        System.out.println(lex.getNextToken());
        System.out.println(lex.getNextToken());
        System.out.println(lex.getNextToken());
    }



}
