package model;

import javafx.util.Pair;

public class SymbolTable {
    short level;
    Node []table;
    public static int sizeGenerator(int size){
        return size;
    }

    public int hashGenerator(String key){
        int result = 0;
        for(int i=0; i<key.length(); i++)
            result += key.charAt(i);

        return ((int)(result*Math.PI))%getSize();
    }

    public int getSize(){
        return table.length;
    }

    public SymbolTable(int size, short level){
        this.table = new Node[sizeGenerator(size)];
        this.level = level;
    }

    public boolean addSymbol(Pair<String, Short> token){
        int pos = hashGenerator(token.getKey());

        if(table[pos] == null){
            table[pos] = new Node(token);
            return true;
        }else{
            //Cuando los tokens no son iguales
            if(!table[pos].token.getKey().equals(token.getKey())){
                //Metodo de resolucion de colisiones
            }
        }

        return false;
    }

    class Node{
        private Node previus;
        private Node next;
        private Pair<String, Short> token;

        public Node(Pair token){
            this.token = token;
            this.previus = null;
            this.next = null;
        }
    }
}
