package com.ecommerce.ebookapi.repositories;

import com.ecommerce.ebookapi.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User,String> {
}
