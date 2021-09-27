package com.example.tickednow;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Contato implements Serializable {

    public String _nome;
    public String _email;

    public Contato(String _nome, String _email){
        this._nome = _nome;
        this._email = _email;
    }

    public String get_nome(){
        return _nome;
    }

    public void set_nome(String _nome){
        this._nome = _nome;
    }

    public String get_email(){
        return _email;
    }

    public void set_email(String _email){
        this._email = _email;
    }

    public JSONObject getJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("Nome", this._nome);
            obj.put("Email", this._email);
        } catch (JSONException e) {

        }
        return obj;
    }
}
