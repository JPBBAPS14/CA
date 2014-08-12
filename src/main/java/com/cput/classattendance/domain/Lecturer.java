/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.classattendance.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author 211064084
 */
@Entity
public class Lecturer implements Serializable {

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String officeRoom;
    private long telephone_no;
    private String email;
    @OneToMany
    private List<Class> classId;

    private Lecturer(Builder builder) {
        id = builder.id;
        name=builder.name;
        officeRoom=builder.officeRoom;
        telephone_no=builder.telephone_no;
        email=builder.email;
        classId = builder.classId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecturer)) {
            return false;
        }
        Lecturer other = (Lecturer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cput.classattendance.domain.Lecturer[ id=" + id + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeRoom() {
        return officeRoom;
    }

    public void setOfficeRoom(String officeRoom) {
        this.officeRoom = officeRoom;
    }

    public long getTelephone_no() {
        return telephone_no;
    }

    public void setTelephone_no(long telephone_no) {
        this.telephone_no = telephone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Class> getClassId() {
        return classId;
    }


    public static class Builder {

        private Long id;
        private String name;
        private String officeRoom;
        private long telephone_no;
        private String email;
        private List<Class> classId;

        public Builder() {
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder officeRoom(String value) {
            this.officeRoom = value;
            return this;
        }

        public Builder telephone_no(long value) {
            this.telephone_no = value;
            return this;
        }

        public Builder email(String value) {
            this.email = value;
            return this;
        }

        public Builder classId(List<Class> value) {
            this.classId = value;
            return this;
        }

        public Builder Lecturer(Lecturer value) {
            id = value.getId();
            name = value.getName();
            officeRoom = value.getOfficeRoom();
            telephone_no = value.getTelephone_no();
            email = value.getEmail();
            classId = value.getClassId();

            return this;
        }

        public Lecturer build() {
            return new Lecturer(this);
        }

    }

}
