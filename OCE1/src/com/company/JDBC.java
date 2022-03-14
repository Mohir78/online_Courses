package com.company;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.sql.*;
    import java.io.IOException;
    import java.util.ArrayList;

public class JDBC {
    ArrayList<UserInformation> usersInformation = new ArrayList<>();

    public void getUserInformation() throws IOException, ClassNotFoundException {
        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "Polo11loop");
            ps = con.prepareStatement("SELECT * FROM users");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id=rs.getInt("user_id");
                String ismi = rs.getString("Ismi");
                String familiyasi = rs.getString("Familiyasi");
                String telefon = rs.getString("Telefon");
                String email = rs.getString("Email");
                String parol = rs.getString("Parol");
                String statusi = rs.getString("Statusi");

                usersInformation.add(new UserInformation(id, ismi, familiyasi, telefon, email, parol, statusi));
            }
            rs.close();

        } catch(SQLException e) {
            System.out.println();
        }
    }

    public ArrayList<UserInformation> getUsersInformation() {
        return usersInformation;
    }



    ArrayList<AdminInformation> adminsInformation = new ArrayList<>();

    public void getAdminInformation() throws IOException, ClassNotFoundException {
        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "Polo11loop");

            ps = con.prepareStatement("SELECT * FROM Admin");
            rs = ps.executeQuery();

            while (rs.next()) {
                String login = rs.getString("Login");
                String parol = rs.getString("Parol");
                String ismi = rs.getString("Ismi");
                String familiyasi = rs.getString("Familiyasi");

                adminsInformation.add(new AdminInformation(ismi, familiyasi, login, parol));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println();
        }
    }

    public ArrayList<AdminInformation> getAdminsInformation() {
        return adminsInformation;
    }



    public void courseAdd() throws IOException, ClassNotFoundException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String nomi;
            int narxi;
            String davomiyligi;
            String oqituvchi;

            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "Polo11loop");

            System.out.print("Kurs nomini kiriting: ");
            nomi = bufferedReader.readLine();

            System.out.print("Kurs narxini kiriting: ");
            narxi = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Kurs davomiyligini kiriting: ");
            davomiyligi = bufferedReader.readLine();

            System.out.print("O'qituvchi ism - familiyasini kiriting: ");
            oqituvchi = bufferedReader.readLine();

            ps = con.prepareStatement("INSERT INTO courses (Nomi, Narxi, Davomiyligi, Oqituvchi) VALUES (?, ?, ?, ?)");

            ps.setString(1, nomi);
            ps.setInt(2, narxi);
            ps.setString(3, davomiyligi);
            ps.setString(4, oqituvchi);
            ps.executeUpdate();

            System.out.println("\nMA'LUMOT QO'SHILDI\n");

        } catch(SQLException e) {
            System.out.println();
        }
    }

    public void courseDelete() throws IOException, ClassNotFoundException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String nomi;

            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "Polo11loop");

            System.out.print("O'chirmoqchi bo'lgan kurs nomini kiriting: ");
            nomi = bufferedReader.readLine();

            ps = con.prepareStatement("DELETE FROM courses WHERE nomi = ?");
            ps.setString(1, nomi);
            ps.executeUpdate();
            System.out.println("\nKURS MA'LUMOTLARI O'CHIRILDI !!!\n");

        } catch (SQLException e) {
            System.out.println();
        }
    }

    public void courseUpdate() throws IOException, ClassNotFoundException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String oldName;
            String newName;
            int newPrice;
            String newDuration;
            String newTeacher;

            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "Polo11loop");

            System.out.print("Yangilamoqchi bo'lgan kurs nomini kiriting: ");
            oldName = bufferedReader.readLine();

            System.out.println("\nYANGI MA'LUMOTLARNI KIRITING\n");

            System.out.print("Nomi: ");
            newName = bufferedReader.readLine();

            System.out.print("Narxi: ");
            newPrice = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Davomiyligi: ");
            newDuration = bufferedReader.readLine();

            System.out.print("O'qituvchi ism - familiyasi: ");
            newTeacher = bufferedReader.readLine();

            ps = con.prepareStatement("UPDATE courses SET Nomi = ?, Narxi = ?, Davomiyligi = ?, Oqituvchi = ? WHERE Nomi = ?");
            ps.setString(1, newName);
            ps.setInt(2, newPrice);
            ps.setString(3, newDuration);
            ps.setString(4, newTeacher);
            ps.setString(5, oldName);
            ps.executeUpdate();

            System.out.println("\nKURS MA'LUMOTLARI YANGILANDI !!!\n");

        } catch (SQLException e) {
            System.out.println();
        }
    }

    ArrayList<Courses> couesesInformation = new ArrayList<>();

    public void getCourseInformation() throws IOException, ClassNotFoundException {
        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "Polo11loop");

            ps = con.prepareStatement("SELECT * FROM courses");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("CourseId");
                String nomi = rs.getString("Nomi");
                int narxi = rs.getInt("Narxi");
                String davomiyligi = rs.getString("Davomiyligi");
                String oqituvchi = rs.getString("Oqituvchi");

                couesesInformation.add(new Courses(id, nomi, narxi, davomiyligi, oqituvchi));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println();
        }
    }

    public ArrayList<Courses> getCoursesInformation() {
        return couesesInformation;
    }



    public void addUser() throws IOException, ClassNotFoundException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String ismi;
            String familiyasi;
            String telefon;
            String email;
            String parol;
            String statusi = "Student";

            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "Polo11loop");

            System.out.print("Ismingizni kiriting: ");
            ismi = bufferedReader.readLine();

            System.out.print("Familiyangizni kiriting: ");
            familiyasi = bufferedReader.readLine();

            System.out.print("Telefon raqamingizni kiriting: ");
            telefon = bufferedReader.readLine();

            System.out.print("Mail pochtangizni kiriting: ");
            email = bufferedReader.readLine();

            System.out.print("Parol o'ylab toping: ");
            parol = bufferedReader.readLine();

            ps = con.prepareStatement("INSERT INTO users (Ismi, Familiyasi, Telefon, Email, Parol, Statusi) VALUES (?, ?, ?, ?, ?, ?)");

            ps.setString(1, ismi);
            ps.setString(2, familiyasi);
            ps.setString(3, telefon);
            ps.setString(4, email);
            ps.setString(5,parol);
            ps.setString(6, statusi);
            ps.executeUpdate();

            System.out.println("\nRO'YHATDAN O'TISH MUVAFFAQIYATLI BAJARILDI\n");

        } catch(SQLException e) {
            System.out.println();
        }
    }

    public void deleteUser() throws IOException, ClassNotFoundException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String email;

            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "Polo11loop");

            System.out.print("O'chirmoqchi bo'lgan foydalanuvchi emailini kiriting: ");
            email = bufferedReader.readLine();

            ps = con.prepareStatement("DELETE FROM users WHERE Email = ?");
            ps.setString(1, email);
            ps.executeUpdate();
            System.out.println("\nFOYDALANUVCHI MA'LUMOTLARI O'CHIRILDI !!!\n");

        } catch (SQLException e) {
            System.out.println();
        }
    }

    public ArrayList<Integer> showFollowCourses(int id) throws IOException, ClassNotFoundException{
        ArrayList<Integer> follow = new ArrayList<Integer>();
        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "Polo11loop");
            ps = con.prepareStatement("select Kurs from followers where user_id=?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int course_id = rs.getInt("Kurs");
                follow.add(course_id);
            }
        }catch(SQLException e) {
            System.out.println("aaa");
        }
        return follow;
    }

    public void followCourse(int user_id, int course_id) throws IOException, ClassNotFoundException{
        try {
            Connection con;
            PreparedStatement ps;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "Polo11loop");
            ps = con.prepareStatement("INSERT INTO followers(user_id,Kurs) value(?,?)");
            ps.setInt(1,user_id);
            ps.setInt(2,course_id);
            ps.executeUpdate();
            System.out.println("Siz kursga muvaffaqiyatli yozildingiz!!!");
        }catch(SQLException e) {
            System.out.println("aaa");
        }
    }

    public void unFollowCourse(int user_id, int course_id) throws IOException, ClassNotFoundException{
        try {
            Connection con;
            PreparedStatement ps;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oce", "root", "Polo11loop");
            ps = con.prepareStatement("DELETE from followers where user_id=? and Kurs=?");
            ps.setInt(1,user_id);
            ps.setInt(2,course_id);
            ps.executeUpdate();
            System.out.println("Siz kursdan muvaffaqiyatli chiqdingiz!!!");
        }catch(SQLException e) {
            System.out.println("aaa");
        }
    }
 }
