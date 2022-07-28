package com.prac.mybatis.controller;

import com.prac.mybatis.mapper.UserProfileMapper;
import com.prac.mybatis.model.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileMapper mapper;
//    @PostConstruct를 사용하면, 빈(bean)이 초기화 됨과 동시에 의존성을 확인할 수 있다.
//    bean lifecycle에서 오직 한 번만 수행된다는 것을 보장할 수 있다.
//    (WAS가 올라가면서 bean이 생성될 때 딱 한 번 초기화함)
//    그래서 @PostConstruct를 사용하면 bean이 여러번 초기화되는 것을 방지할 수 있다.
//    @PostConstruct
//    public void init() {
//        userMap = new HashMap<String, UserProfile>();
//        userMap.put("1", new UserProfile("1", "김승민", "111-1111","안산시"));
//        userMap.put("2", new UserProfile("2", "김승현", "222-2222","안양시"));
//        userMap.put("3", new UserProfile("3", "김아연", "333-3333","서울시"));
//    }

    @GetMapping("user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id){
        return mapper.getUserProfile(id);
    }

    @GetMapping("user/all")
    public List<UserProfile> getUserProfileList(){
        return mapper.getUserProfileList();
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
                                @RequestParam("phone") String phone, @RequestParam("address") String address) {
        mapper.insertUserProfile(id, name, phone, address);
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
                               @RequestParam("phone") String phone, @RequestParam("address") String address) {
        mapper.updateUserProfile(id, name, phone, address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        mapper.deleteUserProfile(id);
    }


}
