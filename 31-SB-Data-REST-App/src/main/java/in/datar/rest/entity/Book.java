package in.datar.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book_tbl")
@Data
public class Book {
	@Id
	private Integer id;
	private String name;
	private Double price;
}
