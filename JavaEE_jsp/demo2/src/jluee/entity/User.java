package jluee.entity;

public class User {
    private int id1;
    private String name1;
    private String passwd1;

    public int getid1(){
        return id1;
    }
    public String getName1(){
        return name1;
    }
    public String  getpasswd1(){
        return passwd1;
    }

    public void setId1(int id){
        id1=id;
    }

    public  void setName1(String name){
        name1=name;
    }

    public void setPasswd1(String passwd1) {
        this.passwd1 = passwd1;
    }
}
