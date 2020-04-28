package com.NetliDev.Beans;

import com.NetliDev.R;

import java.util.ArrayList;
import java.util.List;

public class Salesman {
    private String name;
    private long phone;
    private String email;
    private int idImagen;

    public Salesman(String name, long phone, String email, int idImagen) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.idImagen = idImagen;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public long getphone() {
        return phone;
    }

    public void setphone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static final List<Salesman> SALESMAN_LIST = new ArrayList<>();

    static {
        SALESMAN_LIST.add(new Salesman("Fernando", 998199011, "Fernando@hotmail.com", R.drawable.imagen2));
        SALESMAN_LIST.add(new Salesman("Diego", 998199011, "Diego@hotmail.com", R.drawable.imagen4));
        SALESMAN_LIST.add(new Salesman("Gabriela", 998199011, "Gabriela@hotmail.com", R.drawable.imagen1));
        SALESMAN_LIST.add(new Salesman("Mariana", 998199011, "Mariana@hotmail.com", R.drawable.imagen2));
        SALESMAN_LIST.add(new Salesman("Jhonatan", 998199011, "Jhonatan@hotmail.com", R.drawable.imagen4));
        SALESMAN_LIST.add(new Salesman("Rolando", 998199011, "Rolando@hotmail.com", R.drawable.imagen5));
    }

}
