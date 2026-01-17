package com.example.springboottutorial.repository;

import com.example.springboottutorial.DTO.UserDTO;
import com.example.springboottutorial.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

//    Page<User> findByAge(Integer age, Pageable pageable, Sort sort);

    @Query(value = """
            SELECT new com.example.springboottutorial.DTO.UserDTO(u.name, ad.state)
            FROM User u
            JOIN u.address ad
            WHERE u.name = :userFirstName
            """)
    List<UserDTO> findUserDTO(@Param("userFirstName") String userName);

}


// phone
// age
// phoneNumber


//query = Select * from user phone='';
// Select * from user phone='' and age=;
