package uz.pdp.apprailwayapi.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apprailwayapi.user.service.UserService;
import uz.pdp.model.response.ApiResponse;
import uz.pdp.model.user.UserLoginDTO;
import uz.pdp.model.user.UserReceiveDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUsers(
            @Valid @RequestBody UserReceiveDTO userReceiveDTO
    ) {
        return ResponseEntity.ok(userService.addUser(userReceiveDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getUser() {
        ApiResponse apiResponse = userService.getUserList();
        return ResponseEntity.ok(apiResponse.getData());
    }

    @GetMapping("/{phone}")
    public ResponseEntity<?> checkUserByPhoneNumber(
            @PathVariable("phone") String phoneNumber
    ){
        return ResponseEntity.ok(userService.checkUserPhoneNumber(phoneNumber));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody UserLoginDTO userReceiveDTO
    ){
        return ResponseEntity.ok(userService.login(userReceiveDTO));
    }


}
