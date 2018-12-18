package util;

import app.Book;
import app.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class DAOManager {

    public static int assignBook(String studentID, String bookID){

        try{
            Connection conn = dbManager.getConnection();
            String sql = "insert into student_book values(?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,studentID);
            pst.setString(2,bookID);
            pst.setObject(3,LocalDate.now().plusDays(7));
            return pst.executeUpdate();

        }
        catch (Exception ex){
            ex.printStackTrace();
            System.err.println(ex.getClass().getName()+": "+ex.getMessage());
            return -1;
        }
    }

    public static int reissueBook(String book_isbn){
        try{
            Connection conn = dbManager.getConnection();
            String sql = "update student_book set returnByDate = ? where isbn = ? ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setObject(1,LocalDate.now().plusDays(7));
            pst.setString(2,book_isbn);
            return pst.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.err.println(ex.getClass().getName()+": "+ex.getMessage());
            return -1;
        }

    }

    public static int getFine(String book_isbn){
        try{
            Connection conn = dbManager.getConnection();
            String sql = "select (current_date - (select returnbydate from student_book where isbn = ?)) as result ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,book_isbn);
            ResultSet rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);

        }
        catch (Exception ex){
            ex.printStackTrace();
            System.err.println(ex.getClass().getName()+": "+ex.getMessage());
            return -1;
        }
    }

    public static int returnBook(String book_isbn){
        try{
            Connection conn = dbManager.getConnection();
            String sql = "delete from student_book where isbn = ? ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,book_isbn);
            return pst.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.err.println(ex.getClass().getName()+": "+ex.getMessage());
            return -1;
        }
    }

    public static ArrayList<Student> getDefaulters(){
        try{
            ArrayList<Student> studentList = new ArrayList<Student>();
            Student s ;
            Connection conn = dbManager.getConnection();
            String sql = "select * from student where rno in (select distinct(rno) from student_book where returnbydate < ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setObject(1,LocalDate.now());
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                s = new Student();
                s.setRollNumber(rs.getString(1));
                s.setName(rs.getString(2));
                s.setStudentClass(rs.getString(3));
                s.setEmail(rs.getString(4));
                s.setContact(rs.getString(5));
                studentList.add(s);
            }

            return studentList;
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.err.println(ex.getClass().getName()+": "+ex.getMessage());
            return null;
        }
    }

    public static int checkforDues(String student_rno){
        try{
            Connection conn = dbManager.getConnection();
            String sql = "select count(*) from student_book where rno = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,student_rno);
            ResultSet rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.err.println(ex.getClass().getName()+": "+ex.getMessage());
            return -1;
        }
    }

    public static ArrayList<Book> getDues(String student_rno){
        try{
            ArrayList<Book> bookList = new ArrayList<Book>();
            Book b;

            Connection conn = dbManager.getConnection();
            String sql = "select * from book where isbn in (select isbn from student_book where rno = ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,student_rno);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                b = new Book();
                b.setIsbn(rs.getString(1));
                b.setName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getDouble(4));
                bookList.add(b);
            }

            return bookList;
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.err.println(ex.getClass().getName()+": "+ex.getMessage());
            return null;
        }
    }

    public static int clearDues(String student_rno){
        try{
            Connection conn = dbManager.getConnection();
            String sql = "delete from student_book where rno = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,student_rno);
            return pst.executeUpdate();
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.err.println(ex.getClass().getName()+": "+ex.getMessage());
            return -1;
        }
    }

    public static int addBook(String isbn,String name,String author,Double price){
        try{
            Connection conn = dbManager.getConnection();
            String sql = "insert into Book values(?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,isbn);
            pst.setString(2,name);
            pst.setString(3,author);
            pst.setDouble(4,price);
            return pst.executeUpdate();
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.err.println(ex.getClass().getName()+": "+ex.getMessage());
            return -1;
        }
    }

    public static int addStudent(String rollNumber,String name,String studentClass,String email,String contact){
        try{
            Connection conn = dbManager.getConnection();
            String sql = "insert into Student values(?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,rollNumber);
            pst.setString(2,name);
            pst.setString(3,studentClass);
            pst.setString(4,email);
            pst.setString(5,contact);
            return pst.executeUpdate();
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.err.println(ex.getClass().getName()+": "+ex.getMessage());
            return -1;
        }
    }

    public static void main(String[] args){
        //System.out.println("result"+" : "+ TesTsetDatex());
        //ReadDatex();
        System.out.println(LocalDate.now().plusDays(7));
    }
}
