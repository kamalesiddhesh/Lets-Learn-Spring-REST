package in.datar.rest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import in.datar.rest.entity.Book;

@RepositoryRestResource(path = "books", collectionResourceRel="a1",itemResourceRel = "a2")
public interface BookRepository extends JpaRepository<Book,Integer>{
	
	public List<Book> findByNameContaining(@Param("name") String name);
	
}
