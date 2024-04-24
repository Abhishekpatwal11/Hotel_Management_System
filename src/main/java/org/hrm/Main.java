package org.hrm;
import java.sql.*;
import java.util.Scanner;

class Main extends QueryDetail {
    public static void main(String[] args)throws Exception{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "aBHISHEKWINS@1234");
        boolean a=true;
            while (a) {
                System.out.println("press 1 for reserving the room ");
                System.out.println("press 2 for view the reservation ");
                System.out.println("press 3 for update in reservation");
                System.out.println("press 4 for getting the room no detail ");
                System.out.println("press 5 for delete the reservation");
                System.out.println("press 6 to exit from hotel management system");
                System.out.print("choose from the following: ");
                Scanner sc = new Scanner(System.in);
                int choose = sc.nextInt();
                switch (choose) {
                    case 1:
                        reservation(conn);
                        break;
                    case 2:
                        viewreservation(conn);
                        break;
                    case 3:
                        updatereservation(conn);
                        break;
                    case 4:
                        getroomno(conn);
                        break;
                    case 5:
                        deletereservation(conn);
                        break;
                    case 6:
                        exit_from_system();
                        a=false;
                        break;
                    default:
                        break;
                }
            }
    }

    private static void reservation(Connection con) throws SQLException {

        QueryDetail Q=new QueryDetail();
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name=sc.next();
        Q.setName(name);
        System.out.println("Enter the roomno: ");
        int roomno=sc.nextInt();
        Q.setRoomno(roomno);
        System.out.println("Enter the contactno: ");
        int contactno=sc.nextInt();
        Q.setContactno(contactno);
        String query2="Insert into H_M_S values(" + "'" + Q.getName() +"'" + "," + Q.getRoomno() + "," + Q.getContactno() +")";

        Statement stmt=con.createStatement();
        stmt.execute(query2);
        System.out.println("Reservation get succesfully...");

    }

    private static void viewreservation(Connection con)throws Exception {
        QueryDetail Q=new QueryDetail();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name= sc.next();
        Q.setName(name);

        String query = "select * from h_m_s where name = '" + name + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            System.out.println("name : " + rs.getString("name") + " roomno : " + rs.getInt("roomno") + " contactno : " + rs.getInt("contactno"));
        } else {
            System.out.println("No data found for name: " + name);
        }
    }

    public static void updatename(Connection conn) throws Exception
    {
        Statement stmt = conn.createStatement();
        QueryDetail q=new QueryDetail();
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the newname: ");
        String newname = Sc.next();
        q.setNewName(newname);
        System.out.println("Enter the oldname: ");
        String oldname = Sc.next();
        q.setOldName(oldname);

        String query = "update H_M_S set name=" + "'" + q.newName + "'" + "where name=" + "'" + q.oldName + "'";
        stmt.execute(query);
        System.out.println("name update succesfully...");
    }

    public static void roomno(Connection conn) throws Exception
    {
        Statement stmt = conn.createStatement();
        QueryDetail q=new QueryDetail();
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the newroomno: ");
        int newroomno=Sc.nextInt();
        q.setNewroomno(newroomno);
        System.out.println("Enter the oldroomno: ");
        int oldroomno=Sc.nextInt();
        q.setOldroomno(oldroomno);
        stmt.execute("SET SQL_SAFE_UPDATES = 0");
        String query1 = "update H_M_S set roomno=" + q.newroomno + " where roomno = " + q.oldroomno;
        stmt.execute(query1);
        System.out.println("roomno update succesfully...");
    }

    public static void contactno(Connection conn) throws Exception
    {
        Statement stmt = conn.createStatement();
        QueryDetail q=new QueryDetail();
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the newcontactno: ");
        int newcontactno=Sc.nextInt();
        q.setNewcontactno(newcontactno);
        System.out.println("Enter the oldcontactno: ");
        int oldcontactno=Sc.nextInt();
        q.setOldcotactno(oldcontactno);
        stmt.execute("SET SQL_SAFE_UPDATES = 0;");
        String query2 = "update H_M_S set contactno=" + q.newcontactno + " where contactno = " + q.oldcotactno;
        stmt.execute(query2);
        System.out.println("contact update succesfully...");
    }

    private  static void updatereservation(Connection conn) throws Exception {
        Statement stmt = conn.createStatement();
        Scanner Sc=new Scanner(System.in);
        QueryDetail q=new QueryDetail();
        System.out.println("press 1 for updateing the name");
        System.out.println("press 2 for updateing the roomno");
        System.out.println("press 3 for updateing the contactno");
        int num=Sc.nextInt();
        q.setNum(num);

        if(num==1) {
            updatename(conn);
        }
        else if(num==2) {
            roomno(conn);
        }
        else if (num==3) {
            contactno(conn);
        }
    }

    private static void getroomno(Connection conn)throws Exception
    {
        Statement stmt=conn.createStatement();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name=sc.next();
        String query="select roomno from h_m_s where name=" + "'" + name + "'";
        ResultSet rs=stmt.executeQuery(query);
        if(rs.next())
        {
            System.out.println("The room number of person is: " + rs.getString("roomno"));
        }
    }

    private static void deletereservation(Connection conn)throws Exception
    {
        Statement stmt=conn.createStatement();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name=sc.next();
        String query="delete from h_m_s where name=" + "'" + name + "'";
        System.out.println("record has been deleted...");
        stmt.execute(query);
    }
    private static void exit_from_system()
    {
        System.out.println(" Thank you for visiting the hotel... ");
    }
}