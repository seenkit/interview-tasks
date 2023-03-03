import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Stream;

public class GetUserListForGroupFirstSymbol {
    public static void main(String[] args) {
        Group group1 = new Group("Test", "test");
        Group group2 = new Group("Xfactor", "test");
        Group group3 = new Group("Xce", "test");
        Group group4 = new Group("Test2", "test");

        List<Group> groupList1 = List.of(group1, group2);
        List<Group> groupList2 = List.of(group2, group3, group4);
        List<Group> groupList3 = List.of(group1, group4);

        User user1 = new User("Nikita", 30, groupList1);
        User user2 = new User("Oleg", 40, groupList2);
        User user3 = new User("Ignat", 50, groupList3);

        Stream<User> userStream = Stream.of(user1, user2, user3).filter(user -> user.getUsername().contains("t"));
        SomeConsumer.consume(userStream).forEach(user -> System.out.println(user));

    }
}

@Data
@AllArgsConstructor
class User {
    private String username;
    private Integer age;
    private List<Group> groups;
}

@Data
@AllArgsConstructor
class Group {
    private String name;
    private String description;
}

class SomeConsumer {
    /**
     * получить список пользователей которые состоят в группе начинающейся на "X"
     */
    public static List<User> consume(Stream<User> userStream) {
      return userStream.filter(user -> user.getGroups().stream().anyMatch(group -> group.getName().charAt(0) == 'X'))
               .toList();
    }
}
