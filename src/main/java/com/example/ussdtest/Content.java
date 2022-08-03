/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ussdtest;

/**
 *
 * @author sonbc2
 */
public class Content {

    private int key;
    private String language;
    private String value;
    private int charset;
//
//    public Content(int key, String language, String value) {
//        this.key = key;
//        this.language = language;
//        this.value = value;
//    }

    public Content(int key, String language, String value, int charset) {
        this.key = key;
        this.language = language;
        this.value = value;
        this.charset = charset;
    }

    public int getCharset() {
        return charset;
    }

    public void setCharset(int charset) {
        this.charset = charset;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Content(int key, String language, String value) {
        this.key = key;
        this.language = language;
        this.value = value;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString(){
//        System.out.println(value +":" + language + ":" + key+ ":" + charset);
        return value ;
    }
}
