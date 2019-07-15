package pl.sda.eventmanager.mymanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.eventmanager.mymanager.entity.Event;
import pl.sda.eventmanager.mymanager.entity.User;
import pl.sda.eventmanager.mymanager.repository.EvetnRepository;
import pl.sda.eventmanager.mymanager.repository.UserRepository;

import java.time.LocalDate;

@Component
public class DBStarter implements ApplicationRunner {

    private UserRepository userRepository;
    private EvetnRepository evetnRepository;

//    @Autowired
//    protected DBStarter(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }

    @Autowired
    public DBStarter(UserRepository userRepository, EvetnRepository evetnRepository) {
        this.userRepository = userRepository;
        this.evetnRepository = evetnRepository;
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

        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

        userRepository.save(new User("admin", "admin@gmail.com", bCrypt.encode("1111")));
        userRepository.save(new User("kasia", "kasia@yahoo.com", bCrypt.encode("2222")));
        userRepository.save(new User("marcin", "marcin@yahoo.com", bCrypt.encode("3333")));
        userRepository.save(new User("monika", "monika@yahoo.com", bCrypt.encode("4444")));
        userRepository.save(new User("jakub", "jakub@yahoo.com", bCrypt.encode("5555")));
        userRepository.save(new User("agnieszka", "agnieszka@mail.com", bCrypt.encode("6666")));
        userRepository.save(new User("kamil", "kamil@mail.com", bCrypt.encode("7777")));
        userRepository.save(new User("iza", "iza@yahoo.com", bCrypt.encode("8888")));
        userRepository.save(new User("adrian", "adrian@gmail.com", bCrypt.encode("9999")));
        userRepository.save(new User("renata", "ranata@yahoo.com", bCrypt.encode("0000")));

        /**
         *
         *         1 adam@mail.com adam 1111
         *         2 kasia@yahoo.com kasia 2222
         *         3 marcin@yahoo.com marcin 3333
         *         4 monika@yahoo.com monika 4444
         *         5 jakub@yahoo.com jakub 5555
         *         6 agnieszka@mail.com agnieszka 6666
         *         7 kamil@mail.com kamil 7777
         *         8 iza@yahoo.com iza 8888
         *         9 adrian@gmail.com adrian 9999
         *         10 ranata@yahoo.com renata 0000
         *
         * */

        evetnRepository.save(
                new Event("runmageddon",
                        LocalDate.of(2019, 12, 20),
                        "43-100 Tychy Niepodleglosci 50"));
        evetnRepository.save(
                new Event("masakrator",
                        LocalDate.of(1999, 11, 03),
                "43-190 Laziska Gorne Orzeska 23"));
        evetnRepository.save(
                new Event("bieg komandosa",
                        LocalDate.of(2003, 04, 27),
                        "45-230 Warszawa Marszalkowska 45"));
        evetnRepository.save(
                new Event("masakrator",
                        LocalDate.of(2007, 05, 31),
                        "99-400 Krakow Wawelska 330"));


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
