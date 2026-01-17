package com.example.springboottutorial;

import com.example.springboottutorial.entities.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> hasName(String name) {
        return (root, query, cb) ->
                cb.equal(root.get("name"), name);
    }

    public static Specification<User> hasAge(Integer age) {
        return (root, query, cb) ->
                cb.equal(root.get("age"), age);
    }


}
