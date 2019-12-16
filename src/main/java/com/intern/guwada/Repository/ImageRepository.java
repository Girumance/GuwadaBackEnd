package com.intern.guwada.Repository;

import com.intern.guwada.Domain.ImageStorage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<ImageStorage,String> {

    public ImageStorage findImageStorageByOwnerId(String id);
}
