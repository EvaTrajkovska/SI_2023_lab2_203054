import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    public List<User> setUserList(){
    List<User> userList = new ArrayList<>();
    User user1 = new User("john", "Password123!", "john@gmail.com");
    User user2 = new User("jane", "Password ?", "jane@gmail.com");
    User user3 = new User("karl", "karl", "karl@gmailcom");
    User user4 = new User("kate", null, "kate@gmail.com");
    User user5 = new User("lora", "Pass", "lora@gmail.com");

    userList.add(user1);
    userList.add(user2);
    userList.add(user3);
    userList.add(user4);
    userList.add(user5);


        return userList;
    }
    @Test
    void everyBranchTest() {
        RuntimeException ex;
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(null,setUserList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!")); //ako user e null
        assertFalse(SILab2.function(new User("lora", "Pass", "lora@gmail.com"),setUserList())); //ako e-mail i username e ist
        assertFalse(SILab2.function(setUserList().get(0),setUserList())); // ako pass ima spec i nema " "
        assertFalse(SILab2.function(setUserList().get(1),setUserList())); // ako pass ima " "
        assertFalse(SILab2.function(setUserList().get(2),setUserList())); //ist pass i  username i pass.len<8
        assertFalse(SILab2.function(setUserList().get(2),setUserList())); // ako mail nema .
        assertTrue(SILab2.function(new User("ann", "Password123??", "ann@gmail.com"),setUserList())); //ako ne e vo listata pass>8 bez " " brz username so spec
    }
    @Test
    void multipleCondition(){
        RuntimeException ex;
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(null,setUserList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!")); //ako user e null
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(setUserList().get(3),setUserList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!")); //ako password e null
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(new User("jade", "Password???", null),setUserList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!")); //ako mail e null
        assertTrue(SILab2.function(new User("ann", "Password123??", "ann@gmail.com"),setUserList())); // koga e se vo red

    }

}