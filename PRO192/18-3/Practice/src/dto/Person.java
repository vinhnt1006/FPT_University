package dto;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NK
 */
public class Person {
    private String code;
    private String name;
    private String address;

    public Person(String code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }

    public Person() {
        code = "";
        name = "";
        address = "";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    @Override
    public String toString() {
        return "Student:\n" + "code: " + code + "\nname: " + name + "\naddress: " + address;
    }
    
    
}
