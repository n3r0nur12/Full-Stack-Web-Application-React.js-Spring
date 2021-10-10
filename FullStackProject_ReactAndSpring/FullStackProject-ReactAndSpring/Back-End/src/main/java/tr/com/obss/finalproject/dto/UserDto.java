package tr.com.obss.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tr.com.obss.finalproject.model.User;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String password;
    public User convertToRealObject(){
        return new User(name,surname,address,email,password);
    }

    public static UserDto convertToDtoObject(User user){
        return new UserDto(user.getId(),user.getName(),user.getSurname(),user.getAddress(),user.getEmail(),user.getPassword());
    }
}
