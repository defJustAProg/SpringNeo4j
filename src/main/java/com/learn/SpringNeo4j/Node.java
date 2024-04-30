
package com.learn.SpringNeo4j;


public class Node {
    public int code;
    public String name;
    public String country;
    public String lastCheckUpDate;
    
    public Node(){
        
    }
    
    public Node(int code, String name, String country, String lastCheckUpDate){
        this.code=code;
        this.name=name;
        this.country=country;
        this.lastCheckUpDate=lastCheckUpDate;
    }
}
