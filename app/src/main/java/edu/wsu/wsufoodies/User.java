package edu.wsu.wsufoodies;

public class User {

    String firstName;
    String lastName;
    String password;
    String email;

    int age;

    Standing standing;

    //Constructor with age given
    User(String fn, String ln, String pw, String em, Standing s, int bd){
        firstName = fn;
        lastName = ln;
        password = pw;
        email = em;
        age = bd;
        standing = s;
    }

    //constructor without age
    User(String fn, String ln, String pw, String em, Standing s){
        firstName = fn;
        lastName = ln;
        password = pw;
        email = em;
        standing = s;
    }

    // Getters
    String getFirstName(){
        return firstName;
    }

    String getLastName(){
        return lastName;
    }

    String getPassword(){
        return password;
    }

    String getEmail(){
        return email;
    }

    Standing getStanding(){

        return standing;
    }

    // Setters
    void setFirstName(String f){
        firstName= f;
    }

    void setLastName(String l){
        lastName = l;
    }

    boolean newPassword(String old, String n){
        if (old == password){
            password = n;
            return true;
        }
        return false;
            
    }

    void setEmail(String e){
        email = e;
    }

    void setStanding(Standing s){
        standing = s;
    }

    void setAge(int age)
    {
        this.age= age;
    }

    void setPassword(String password)
    {
        this.password=password;
    }
}
