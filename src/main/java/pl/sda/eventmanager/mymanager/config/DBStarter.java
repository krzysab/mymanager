package pl.sda.eventmanager.mymanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.sda.eventmanager.mymanager.model.User;
import pl.sda.eventmanager.mymanager.repository.UserRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

@Component
public class DBStarter implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    protected DBStarter(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /*@Override
    public void run(ApplicationArguments args) throws Exception {

        Fairy fairy = Fairy.create();

        for(int i = 0; i < 10; i++){
            Person person = fairy.person();
            User user = new User();
            user.setNick(person.getUsername());
            user.setEmail(person.getEmail());
            userRepository.save(user);
            System.out.println(user.toString());
        }

    }*/

    public void run(ApplicationArguments args) throws Exception{
        userRepository.save(new User("adam", "adam@gmail.com"));
        userRepository.save(new User("kasia", "kasia@yahoo.com"));
        userRepository.save(new User("marcin", "marcin@yahoo.com"));
        userRepository.save(new User("monika", "monika@yahoo.com"));
        userRepository.save(new User("jakub", "jakub@yahoo.com"));
        userRepository.save(new User("agnieszka", "agnieszka@mail.com"));
        userRepository.save(new User("kamil", "kamil@mail.com"));
        userRepository.save(new User("iza", "iza@yahoo.com"));
        userRepository.save(new User("adrian", "adrian@gmail.com"));
        userRepository.save(new User("renata", "ranata@yahoo.com"));

        /**
         *
         *         1 adam@mail.com adam
         *         2 kasia@yahoo.com kasia
         *         3 marcin@yahoo.com marcin
         *         4 monika@yahoo.com monika
         *         5 jakub@yahoo.com jakub
         *         6 agnieszka@mail.com agnieszka
         *         7 kamil@mail.com kamil
         *         8 iza@yahoo.com iza
         *         9 adrian@gmail.com adrian
         *         10 ranata@yahoo.com renata
         *
         * */

    }

//    public void run(ApplicationArguments args) throws Exception{

//        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\krzysiek\\IdeaProjects\\mymanager\\src\\main\\resources\\templates\\testUsers.csv"));
        /*String readLine = bufferedReader.readLine();
        String[] string = readLine.split(" ");
        int id = Integer.parseInt(string[0]);
        String email = string[1];
        String nick = string[2];
        User user = new User(nick, email);
        userRepository.save(user);
        System.out.println(user.toString());*/

        /**czytanie z pliku testUsers.csv danych przykladowych userow*/

        /*for (int i = 0; i < 10; i++) {
            String readLine = bufferedReader.readLine();
            String[] string = readLine.split(" ");
            int id = Integer.parseInt(string[0]);
            String email = string[1];
            String nick = string[2];
            User user = new User(nick, email);
            userRepository.save(user);
            System.out.println(user.toString());
        }*/

        /*BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\krzysiek\\IdeaProjects\\mymanager\\src\\main\\resources\\templates\\testUsers.csv"));
            String readLine;
            do {
                readLine = bufferedReader.readLine();
                String[] string = readLine.split(" ");
                int id = Integer.parseInt(string[0]);
                String email = string[1];
                String nick = string[2];
                User user = new User(nick, email);
                userRepository.save(user);
                System.out.println(user.toString());
            } while (readLine != null);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
*/







        /*Connection conn = null;
        Statement stmt = null;

        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        stmt = conn.createStatement();

        stmt.execute("drop table if exists users");
        stmt.execute("create table users (id int primary key, nick varchar(100), email varchar (100))");
        stmt.execute("insert into users ( id, nick, email )     select (\"id\", \"nick\", \"email\")   from CSVREAD( 'C:\\Users\\krzysiek\\IdeaProjects\\mymanager\\src\\main\\resources\\templates\\testUsers.csv', 'id,nick,email', null ) ");
        ResultSet rs = stmt.executeQuery("select * from users");

        while (rs.next()) {
            System.out.println("id " + rs.getInt("id") + " nick " + rs.getString("nick") + " email " + rs.getInt("email") );
        }
        stmt.close();*/
//    }
}
