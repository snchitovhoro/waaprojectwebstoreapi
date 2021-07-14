package edu.miu.cs545.waaprojectwebstoreapi.service;

import edu.miu.cs545.waaprojectwebstoreapi.model.User;

public class UserDtoAdapter {

    public static UserDTO getDto(User user) {

        UserDTO UserDTO = new UserDTO();
        UserDTO.setId(user.getId());
        UserDTO.setFirstName(user.getFirstName());
        UserDTO.setLastName(user.getLastName());
        UserDTO.setUserName(user.getUserName());
        return UserDTO;

    }

    public static User getUser(UserDTO userDto) {
        User User = new User();
        User.setId(userDto.getId());
        User.setFirstName(userDto.getFirstName());
        User.setLastName(userDto.getLastName());
        User.setUserName(userDto.getUserName());
        return User;
    }
}
