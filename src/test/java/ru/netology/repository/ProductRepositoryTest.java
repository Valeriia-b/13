package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(1, "book1", 100, "author", 20, 2020);
    private Book book2 = new Book(2, "book2", 200, "author", 25, 2002);
    private TShirt tshirt = new TShirt(3, "tshirt", 300, "black", "M");

    @BeforeEach
    public void shouldAdd (){
        repository.save(book1);
        repository.save(book2);
        repository.save(tshirt);
    }

    @Test
    public void shouldDeleteIfExists(){
        Product[] expected = new Product[]{book2, tshirt};
        Product[] actual = repository.removeById(1);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteIfNotExists(){
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }
}