package com.springboot.usermanager.User;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserLogic logic;

    @PostMapping
    @Operation(
            summary = "this endpoint is used to create new user"
    )
    public UserTable addUser(@RequestBody UserDTO user){
        UserTable userTable = new UserTable();
        userTable.setFirstname(user.getFirstname());
        userTable.setLastname(user.getLastname());
        userTable.setEmail(user.getEmail());
        return logic.CreateUser(userTable);

    }
    @GetMapping
    @Operation(
            summary = "this endpoint is used to retrieve all data from table"
    )
    public List<UserTable> getAllUsers(){
        return logic.GetAllUsers();
    }
    @DeleteMapping("/{id}")
    @Operation(
            summary = "this endpoint is used to delete/remove user"
    )
    public void deleteTask(@PathVariable long id){
        logic.Delete(id);
    }
    @PutMapping("/{id}")
    @Operation(
            summary = "this endpoint is used to update user"
    )
    public UserTable updateUser(@PathVariable long id, @RequestBody UserDTO user){
        UserTable userTable = new UserTable();
        userTable.setFirstname(user.getFirstname());
        userTable.setLastname(user.getLastname());
        userTable.setEmail(user.getEmail());
        return logic.Update(id,userTable);
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "this endpoint is used to get user by its id"
    )
    public UserTable GetUserById(@PathVariable long id){
        return logic.GetUserById(id);
    }

}
