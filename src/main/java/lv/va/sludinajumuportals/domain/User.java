package lv.va.sludinajumuportals.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String surename;
    String type;

public User() {
}

public User(Long id, String name, String surename, String type) {
        this.id = id;
        this.name = name;
        this.surename = surename;
        this.type = type;

}
public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}