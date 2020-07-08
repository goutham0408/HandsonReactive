package com.bezkoder.spring.data.cassandra.repository;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.data.cassandra.model.Notestable;

@Repository
public interface NotesLibRepository extends CassandraRepository<Notestable> {

  Optional<Notestable> findByNotename(String notename);

  Optional<Notestable> deleteByNotename(String notename);


  
 
  

}
