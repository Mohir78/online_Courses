package com.company;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JDBC db = new JDBC();
        db.getUserInformation();
        db.getAdminInformation();
        db.getCourseInformation();

        ArrayList<UserInformation> usersInformation = db.getUsersInformation();
        ArrayList<AdminInformation> adminsInformation = db.getAdminsInformation();
        ArrayList<Courses> coursesInformation = db.getCoursesInformation();

        File myFile = new File("C:\\Users\\Mohir\\Desktop\\OCE1\\OCE1\\src\\com\\company\\aboutUs.txt");
        Scanner menuScanner = new Scanner(System.in);
        Scanner loginScanner = new Scanner(System.in);
        Scanner passwordScanner = new Scanner(System.in);
        Scanner followScanner = new Scanner(System.in);
        Scanner chooseCourseScanner = new Scanner(System.in);

        int option;
        boolean isLogged = true;
        boolean log=false;
        boolean isLog = true;
        boolean followers = false;


        System.out.println("\n" + "ONLAYN KURSLARGA RO'YHATDAN O'TISH DASTURIGA XUSH KELIBSIZ !!!");
        while (true) {
            mainMenuOuter: {
                if (isLog) {
                    System.out.println("\n" + "*** ASOSIY MENYU ***" + "\n");
                    System.out.println("1. Kirish/Registratsiya");
                    System.out.println("2. Kurslar haqida ma'lumot olish");
                    System.out.println("3. Kurslarga yozilish");
                    System.out.println("4. Tariflar haqida");
                    System.out.println("5. Biz haqimizda");
                    System.out.println("0. Dasturdan chiqish");
                    System.out.print("\n" + "MENYULARDAN BIRINI TANLANG: ");

                    option = menuScanner.nextInt();
                }else {
                    option = 1;
                    isLog = true;
                }
                if (isLog) {
                    switch (option) {
                        case 1:
                            System.out.println("\n" + "KIRISH/REGISTRATSIYA MENYUSI." + "\n");
                            System.out.println("1. Dasturga kirish uchun 1 ni bosing");
                            System.out.print("2. Ro'yhatdan o'tish uchun 2 ni bosing: ");
                            while (true) {
                                registrMenuOuter:
                                {
                                    option = menuScanner.nextInt();
                                    switch (option) {
                                        case 1:
                                            while (true) {
                                                loginMenuOuter:
                                                {
                                                    System.out.println("\nDASTURGA KIRISH\n");
                                                    System.out.println("1. Admin sifatida kirish uchun 1 ni bosing");
                                                    System.out.println("2. Foydalanuvchi sifatida kirish uchun 2 ni bosing");

                                                    option = menuScanner.nextInt();

                                                    switch (option) {
                                                        case 1:
                                                            System.out.println("\nADMIN SIFATIDA KIRISH\n");
                                                            System.out.print("Login: ");
                                                            String login = loginScanner.nextLine();
                                                            System.out.print("Parol: ");
                                                            String parol = passwordScanner.nextLine();

                                                            for (AdminInformation admin : adminsInformation) {
                                                                if (admin.getLogin().equals(login) && admin.getParol().equals(parol)) {

                                                                    while (true) {
                                                                        adminMenuOuter:
                                                                        {
                                                                            System.out.println("\n*** ADMIN MODULI ***\n");
                                                                            System.out.println("1. Kurslarni boshqarish");
                                                                            System.out.println("2. Foydalanuvchilarni boshqarish");
                                                                            System.out.println("0. Asosiy menyuga qaytish");
                                                                            System.out.print("\n" + "MENYULARDAN BIRINI TANLANG: ");
                                                                            option = menuScanner.nextInt();

                                                                            if (option == 0) {
                                                                                break mainMenuOuter;
                                                                            }

                                                                            switch (option) {
                                                                                case 1:
                                                                                    while (true) {
                                                                                        courseControllOuter:
                                                                                        {
                                                                                            System.out.println("\nKURSLARNI BOSHQARISH\n");
                                                                                            System.out.println("1. Yangi kurs qo'shish");
                                                                                            System.out.println("2. Kurs ma'lumotlarini o'chirish");
                                                                                            System.out.println("3. Kurs ma'lumotlarini yangilash");
                                                                                            System.out.println("4. Kurs ma'lumotlarini ko'rish");
                                                                                            System.out.println("0. Ortga qaytish");
                                                                                            System.out.print("\n" + "MENYULARDAN BIRINI TANLANG: ");
                                                                                            option = menuScanner.nextInt();
                                                                                            if (option == 0) {
                                                                                                break adminMenuOuter;
                                                                                            }

                                                                                            switch (option) {
                                                                                                case 1:
                                                                                                    System.out.println("\nYANGI KURS QO'SHISH\n");
                                                                                                    db.courseAdd();

                                                                                                    System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                                    option = menuScanner.nextInt();

                                                                                                    if (option == 0) {
                                                                                                        break courseControllOuter;
                                                                                                    }

                                                                                                    break;
                                                                                                case 2:
                                                                                                    System.out.println("\nKURS MA'LUMOTLARINI O'CHIRISH\n");
                                                                                                    db.courseDelete();

                                                                                                    System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                                    option = menuScanner.nextInt();

                                                                                                    if (option == 0) {
                                                                                                        break courseControllOuter;
                                                                                                    }

                                                                                                    break;
                                                                                                case 3:
                                                                                                    System.out.println("\nKURS MA'LUMOTLARINI YANGILASH\n");
                                                                                                    db.courseUpdate();

                                                                                                    System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                                    option = menuScanner.nextInt();

                                                                                                    if (option == 0) {
                                                                                                        break courseControllOuter;
                                                                                                    }

                                                                                                    break;
                                                                                                case 4:
                                                                                                    System.out.println("\nKURS MA'LUMOTLARINI KO'RISH\n");

                                                                                                    for (Courses courses : coursesInformation) {
                                                                                                        courses.showCourses();
                                                                                                    }

                                                                                                    System.out.print("\nOrtga qaytish uchun 0 ni bosing: ");
                                                                                                    option = menuScanner.nextInt();

                                                                                                    if (option == 0) {
                                                                                                        break courseControllOuter;
                                                                                                    }

                                                                                                    break;
                                                                                                default: {
                                                                                                    System.out.print("\n" + "MENYU RAQAMINI TO'GRI KIRITING !" + "\n");
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }

                                                                                case 2:
                                                                                    System.out.println("\nFOYDALANUVCHILARNI BOSHQARISH\n");
                                                                                    System.out.println("1. Yangi foydalanuvchini qo'shish");
                                                                                    System.out.println("2. Foydalanuvchi ma'lumotlarini o'chirish");
                                                                                    System.out.println("3. Foydalanuvchi ma'lumotlarini ko'rish");
                                                                                    System.out.println("0. Ortga qaytish");
                                                                                    System.out.print("\n" + "MENYULARDAN BIRINI TANLANG: ");
                                                                                    option = menuScanner.nextInt();

                                                                                    if (option == 0) {
                                                                                        break adminMenuOuter;
                                                                                    }

                                                                                    switch (option) {
                                                                                        case 1:
                                                                                            System.out.println("\nYANGI FOYDALANUVCHINI QO'SISH\n");
                                                                                            db.addUser();

                                                                                            System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                            option = menuScanner.nextInt();

                                                                                            if (option == 0) {
                                                                                                break;
                                                                                            }

                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.println("\nFOYDALANUVCHI MA'LUMOTLARINI O'CHIRISH\n");
                                                                                            db.deleteUser();

                                                                                            System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                            option = menuScanner.nextInt();
                                                                                            if (option == 0) {
                                                                                                break;
                                                                                            }
                                                                                        case 3:
                                                                                            System.out.println("\nFOYDALANUVCHI MA'LUMOTLARINI KO'RISH\n");
                                                                                            for (int i = 0; i < usersInformation.size(); i++) {
                                                                                                usersInformation.get(i).showUsersInformation();
                                                                                            }
                                                                                            System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                            option = menuScanner.nextInt();
                                                                                            if (option == 0) {
                                                                                                break;
                                                                                            }
                                                                                        default: {
                                                                                            System.out.print("\n" + "MENYU RAQAMINI TO'GRI KIRITING !" + "\n");
                                                                                            break;
                                                                                        }
                                                                                    }

                                                                                    break;
                                                                                default: {
                                                                                    System.out.print("\n" + "MENYU RAQAMINI TO'GRI KIRITING !" + "\n");
                                                                                    break;
                                                                                }

                                                                            }

                                                                        }
                                                                    }

                                                                } else {
                                                                    isLogged = false;
                                                                    System.out.println("\nOOPS, LOGIN YOKI PAROL XATO :(");
                                                                }
                                                            }
                                                            if (!isLogged) {
                                                                System.out.println("\nOOPS, LOGIN YOKI PAROL XATO :(");
                                                                break loginMenuOuter;
                                                            }

                                                            break;
                                                        case 2:
                                                            System.out.println("\nFOYDALANUVCHI SIFATIDA KIRISH\n");
                                                            System.out.print("Email: ");
                                                            String email = loginScanner.nextLine();
                                                            System.out.print("Parol: ");
                                                            parol = passwordScanner.nextLine();
                                                            for (UserInformation user : usersInformation) {
                                                                if (user.getEmail().equals(email) && user.getParol().equals(parol)) {
                                                                    while (true) {
                                                                        userMenuOuter:
                                                                        {
                                                                            log = true;
                                                                            ArrayList<Integer> follow = db.showFollowCourses(user.getId());
                                                                            System.out.println("\n*** FOYDALANUVCHI MODULI ***\n");
                                                                            System.out.println("1. Profil");
                                                                            System.out.println("2. Yangi kursga yozilish");
                                                                            System.out.println("3. Kurslardan chiqish");
                                                                            System.out.println("0. Asosiy menyuga qaytish");
                                                                            option = menuScanner.nextInt();

                                                                            switch (option) {
                                                                                case 1:
                                                                                    System.out.println("---Profil---");
                                                                                    user.showUsersInformation();
                                                                                    System.out.println("Siz a'zo bo'lgan kurslar:");
                                                                                    for (int i = 0; i < follow.size(); i++) {
                                                                                        for (int j = 0; j < coursesInformation.size(); j++) {
                                                                                            if (follow.get(i).equals(coursesInformation.get(j).getId())) {
                                                                                                System.out.println((i + 1) + ". " + coursesInformation.get(j).nomi);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                    option = menuScanner.nextInt();
                                                                                    if (option == 0) {
                                                                                        break userMenuOuter;
                                                                                    }
                                                                                case 2:
                                                                                    System.out.println("---Kursga yozilish---");
                                                                                    if (follow.toArray().length >= 3) {
                                                                                        System.out.println("Siz 3 ta kursga yozilgansiz!!!");
                                                                                    } else {
                                                                                        System.out.print("Kurs nomini kiriting: ");
                                                                                        String courseName = followScanner.nextLine();
                                                                                        for (int i = 0; i < coursesInformation.toArray().length; i++) {
                                                                                            if (courseName.equals(coursesInformation.get(i).nomi)) {
                                                                                                db.followCourse(user.getId(), coursesInformation.get(i).id);
                                                                                                followers = true;
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        if (!followers) {
                                                                                            System.out.println(":( BUNDAY KURS MAVJUD EMAS");
                                                                                        }
                                                                                    }
                                                                                    followers = false;
                                                                                    System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                    option = menuScanner.nextInt();
                                                                                    if (option == 0) {
                                                                                        break userMenuOuter;
                                                                                    }
                                                                                case 3:
                                                                                    System.out.println("---Kurslardan chiqish---");
                                                                                    System.out.println("Chiqmoqchi bo'lgan kurs nomini kiriting: ");
                                                                                    String name = chooseCourseScanner.nextLine();
                                                                                    for (int i = 0; i < coursesInformation.toArray().length; i++) {
                                                                                        if (name.equals(coursesInformation.get(i).nomi)) {
                                                                                            db.unFollowCourse(user.getId(), coursesInformation.get(i).id);
                                                                                            followers = true;
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    if (!followers) {
                                                                                        System.out.println(":( BUNDAY KURS MAVJUD EMAS");
                                                                                    }
                                                                                    System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                                                                    option = menuScanner.nextInt();
                                                                                    if (option == 0) {
                                                                                        break userMenuOuter;
                                                                                    }
                                                                                case 0:
                                                                                    for (int i = 0; i < follow.size(); i++) {
                                                                                        follow.remove(i);
                                                                                    }
                                                                                    break mainMenuOuter;
                                                                                default:
                                                                                    System.out.print("\n" + "MENYU RAQAMINI TO'GRI KIRITING !" + "\n");
                                                                                    break;
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    isLogged = false;
                                                                }
                                                            }
                                                            if (!isLogged) {
                                                                System.out.println("\nOOPS, EMAIL YOKI PAROL XATO :(");
                                                                break loginMenuOuter;
                                                            }

                                                            break;
                                                        default: {
                                                            System.out.print("\n" + "MENYU RAQAMINI TO'GRI KIRITING !" + "\n");
                                                            break;
                                                        }
                                                    }
                                                }
                                            }

                                        case 2:
                                            System.out.println("\n" + "RO'YHATDAN O'TISH" + "\n");
                                            db.addUser();

                                            System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                            option = menuScanner.nextInt();

                                            if (option == 0) {
                                                break;
                                            }

                                            break registrMenuOuter;
                                        default:
                                            System.out.print("\n" + "MENYU RAQAMINI TO'GRI KIRITING !" + "\n");
                                            break registrMenuOuter;
                                    }
                                }
                            }
                        case 2:
                            System.out.println("\n" + "KURSLAR HAQIDA MA'LUMOT OLISH MENYUSI." + "\n");
                            for (int i = 0; i < coursesInformation.toArray().length; i++) {
                                coursesInformation.get(i).showCourses();
                            }
                            System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                            while (true) {
                                option = menuScanner.nextInt();
                                if (option == 0) {
                                    break;
                                } else {
                                    System.out.println("Sonni to'g'ri kiriting!!! ");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("\n" + "KURSLARGA YOZILISH MENYUSI." + "\n");
                            System.out.println("Yozilmoqchi  bo'lgan kursingiz nomimni kiriting:");
                            String courseName = followScanner.nextLine();

                            for (int i = 0; i < coursesInformation.toArray().length; i++) {
                                if (courseName.equals(coursesInformation.get(i).nomi)) {
                                    if (log) {
                                        break;
                                    } else {
                                        System.out.println("Siz hali kirish yoki registratsiyadan o'tmagansiz!!!");
                                        isLog = false;
                                        break;
                                    }
                                }
                            }
                            System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                            while (true) {
                                option = menuScanner.nextInt();
                                if (option == 0) {
                                    break;
                                } else {
                                    System.out.println("Sonni to'g'ri kiriting!!! ");
                                }
                            }
                            break;
                        case 4:
                            System.out.println("\n" + "TARIFLAR HAQIDA MENYUSI." + "\n");
                            System.out.println("1. Silver");
                            System.out.println("2. Gold");
                            System.out.println("3. Platinum");
                            System.out.print("\nQaysi tarif haqida ma'lumot olishni istaysiz: ");
                            option = menuScanner.nextInt();
                            switch (option) {
                                case 1:
                                    System.out.println("\nSILVER TARIFI HAQIDA\n");
                                    System.out.println("Silver - bu tarif barcha kurslarga 20% lik chegirmani taqdim etadi." +
                                            "Kurslarni tugatgandan so'ng takrorlash uchun 3 oy imkoniyati bo'ladi.");
                                    System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                    option = menuScanner.nextInt();
                                    if (option == 0) {
                                        break;
                                    }
                                case 2:
                                    System.out.println("\nGOLD TARIFI HAQIDA\n");
                                    System.out.println("Gold - bu tarif barcha kurslarga 20% lik chegirmani taqdim etadi." +
                                            "Telegramda yopiq guruhga qoshilish, qoshimcha bonus darslar, vebinarlarga kirish imkoniyati mavjud." +
                                            "Kurslarni tugatgandan so'ng takrorlash uchun 6 oy imkoniyati bo'ladi.");
                                    System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                    option = menuScanner.nextInt();
                                    if (option == 0) {
                                        break;
                                    }
                                case 3:
                                    System.out.println("\nPLATINUM TARIFI HAQIDA\n");
                                    System.out.println("Platinum - bu tarif barcha kurslarga 30% lik chegirmani taqdim etadi." +
                                            "Telegramda yopiq guruhga qoshilish, qoshimcha bonus darslar, vebinarlarga kirish va portfolio uchun proyekt bajarish imkoniyati mavjud." +
                                            "Kurslarni tugatgandan so'ng takrorlash uchun 12 oy imkoniyati bo'ladi.");
                                    System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                                    option = menuScanner.nextInt();
                                    if (option == 0) {
                                        break;
                                    }
                                default:
                                    System.out.print("\n" + "MENYU RAQAMINI TO'GRI KIRITING !" + "\n");
                                    break;

                            }
                            System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                            while (true) {
                                option = menuScanner.nextInt();
                                if (option == 0) {
                                    break;
                                } else {
                                    System.out.println("Sonni to'g'ri kiriting!!! ");
                                }
                            }
                            break;
                        case 5:
                            System.out.println("\n" + "BIZ HAQIMIZDA MENYUSI." + "\n");
                            FileReader fileReader = new FileReader(myFile);
                            char symbol = ' ';
                            while (fileReader.ready()){
                                symbol = (char) fileReader.read();
                                System.out.print(symbol);
                            }

                            fileReader.close();
                            System.out.println("\n");
                            System.out.print("Ortga qaytish uchun 0 ni bosing: ");
                            while (true) {
                                option = menuScanner.nextInt();
                                if (option == 0) {
                                    break;
                                } else {
                                    System.out.println("Sonni to'g'ri kiriting!!! ");
                                }
                            }
                            break;
                        case 0:
                            System.out.println("\n*** DASTUR TUGATILDI ***");
                            System.exit(0);
                        default:
                            System.out.print("\n" + "MENYU RAQAMINI TO'GRI KIRITING !" + "\n");
                            break;

                    }
                }
            }
        }
    }
}
