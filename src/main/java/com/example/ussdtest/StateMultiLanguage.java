/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ussdtest;

import java.util.HashMap;

/**
 *
 * @author halt14
 */
public class StateMultiLanguage {

    private int id;
    /**
     * ban tin ussd tra ve cho nguoi dung khi den trang thai nay
     */
    private HashMap<Integer, Content> contents;

    public StateMultiLanguage(int id, HashMap<Integer, Content> contents) {
        this.id = id;
        this.contents = contents;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the contents
     */
    public HashMap<Integer, Content> getContents() {
        return contents;
    }

    /**
     * @param contents the contents to set
     */
    public void setContents(HashMap<Integer, Content> contents) {
        this.contents = contents;
    }
}
