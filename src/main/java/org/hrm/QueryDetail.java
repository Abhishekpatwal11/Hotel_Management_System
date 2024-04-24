package org.hrm;

public class QueryDetail {
    String name;
    int roomno;
    int contactno;
    int num;
    String newName;
    String oldName;

    int newroomno;
    int oldroomno;
    int newcontactno;
    int oldcotactno;

    public int getNewroomno()
    {
        return newroomno;
    }

    public int getOldroomno()
    {
        return oldroomno;
    }

    public int getNewcontactno() {
        return newcontactno;
    }

    public int getOldcotactno() {
        return oldcotactno;
    }

    public void setNewcontactno(int newcontactno) {
        this.newcontactno = newcontactno;
    }

    public void setOldcotactno(int oldcotactno) {
        this.oldcotactno = oldcotactno;
    }

    public void setNewroomno(int newroomno)
    {
        this.newroomno=newroomno;
    }

    public void setOldroomno(int oldroomno)
    {
        this.oldroomno=oldroomno;
    }
    public String getNewName()
    {
        return getNewName();
    }

    public String getOldName()
    {
        return getOldName();
    }

    public void setNewName(String newName)
    {
        this.newName=newName;
    }

    public void setOldName(String oldName)
    {
        this.oldName=oldName;
    }


    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public int getRoomno() {
        return roomno;
    }

    public int getContactno() {
        return contactno;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }
    public void setContactno(int contactno) {
        this.contactno = contactno;
    }
    public void setNum(int num)
    {
        this.num=num;
    }

}
