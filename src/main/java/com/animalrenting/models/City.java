package com.animalrenting.models;

public enum City {
    Sarajevo,
    Tuzla,
    Mostar,
    Zenica,
    Bihac,
    Trebinje,
    Prijedor,
    Doboj,
    Zavidovici,
    Visoko,
    Cazin,
    Livno,
    Gracanica,
    Gorazde,
    Srebrenik,
}


//package com.hero.controllers;
//
//        import com.hero.util.JwtUtil;
//        import org.springframework.web.bind.annotation.GetMapping;
//        import org.springframework.web.bind.annotation.RequestHeader;
//        import org.springframework.web.bind.annotation.RequestMapping;
//        import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//
//    private final JwtUtil jwtTokenUtil;
//
//    public UserController(JwtUtil jwtTokenUtil) {
//        this.jwtTokenUtil = jwtTokenUtil;
//    }
//
//    @GetMapping("/whoami")
//    public String getUser(@RequestHeader(name = "Authorization") String token) {
//        String username = jwtTokenUtil.extractUsername(token.substring(7));
//        // get user from the DB by this username from token
//        // and return the user as a DTO to the FE
//        return username;
//    }
//
//}