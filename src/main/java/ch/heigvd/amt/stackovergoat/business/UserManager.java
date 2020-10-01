package ch.heigvd.amt.stackovergoat.business;

import ch.heigvd.amt.stackovergoat.model.User;

import java.util.LinkedList;

public class UserManager {
    private LinkedList<User> users = new LinkedList<>();

    public UserManager() {
        users.add(new User(0, "Lagier", "Elodie", "Lolo", "elo.lag@gmail.com", "1234"));
        users.add(new User(1, "Massaoudi", "Walid", "Wawa", "wal.id@gmail.com", "qwer"));
        users.add(new User(2, "Hardrick", "Baptiste", "Baba", "hardtiste@mail.com", "asdf"));
        users.add(new User(3, "Fleurimont", "Clarisse", "Clacla", "cla.cla@heig-vd.ch", "yxcv"));
        users.add(new User(4, "Liechti", "Olivier", "wasadigi", "oliechti@gmail.com", "sdfg"));
        users.add(new User(5, "Moi", "Toi", "Toto", "nous@vous.com", "fghj"));
        users.add(new User(6, "Alex", "Terieur", "alex", "rauss@mail.com", "3456"));
        users.add(new User(7, "Dupond", "Dupont", "dudu", "dudu@gmail.com", "fgjhd"));
    }

    public User getUser(int id) {
        for (User user :
                users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String username) {
        for (User user :
                users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
