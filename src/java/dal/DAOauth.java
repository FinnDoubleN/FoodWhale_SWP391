/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.regex.Pattern;

/**
 *
 * @author This PC
 */
public class DAOauth {

    public boolean AdAuth(String user, String pattern) {
        Pattern p = Pattern.compile(pattern);
        //[a-zA-Z][a-zA-Z0-9]+@[a] -> admin
        //[a-zA-Z][a-zA-Z0-9]+@[m] ->manager
        //[a-zA-Z][a-zA-Z0-9]+@[s] ->staff
        if (p.matcher(user).find()) {
            return true;
        }
        return false;
        //if return false -> user
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
}
