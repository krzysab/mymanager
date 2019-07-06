package pl.sda.eventmanager.mymanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.sda.eventmanager.mymanager.model.User;
import pl.sda.eventmanager.mymanager.repository.UserRepository;

import java.io.BufferedReader;
import java.io.FileReader;

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

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\krzysiek\\IdeaProjects\\mymanager\\src\\main\\resources\\templates\\testUsers.csv"));
        String readLine = bufferedReader.readLine();
        String[] string = readLine.split(" ");
        int id = Integer.parseInt(string[0]);
        String email = string[1];
        String nick = string[2];
        User user = new User(email, nick);



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
    }
}
