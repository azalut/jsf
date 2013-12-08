package com.maciej.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "order")
@SessionScoped
public class OrderBean implements Serializable{
    private List<String> lista = new ArrayList<String>();

    public String getNapis() {
        return napis;
    }

    private String napis = "WITAM ZIOMEK";

    public OrderBean() {
        lista.add("maciek");
        lista.add("wojtek");
        lista.add("daniel");
        lista.add("karolina");
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }
}
