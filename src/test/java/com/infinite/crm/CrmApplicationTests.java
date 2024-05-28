package com.infinite.crm;

import com.infinite.crm.model.Products;
import com.infinite.crm.repository.ProductRepository;
import com.infinite.crm.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CrmApplicationTests {

    @Autowired
    private ProductService service;

    @MockBean
    private ProductRepository repository;

    @Test
    public void saveProducts2(){
        when(repository.findAll()).thenReturn(Stream.of (new Products(2L,"Samsung","4",20000L,"samsung"),
                new Products(4L,"Realme","5",20000L,"realme")) .collect(Collectors.toList()));

        assertEquals(2,service.productList().size());

    }

    @Test
    public void getallProducts() {
        when(repository.findAll()).thenReturn(Stream.of (new Products(2L,"Samsung","4",20000L,"samsung"),
                new Products(4L,"Realme","5",20000L,"realme")) .collect(Collectors.toList()));
        System.out.println(service.productList());

        assertEquals(2,service.productList().size());
    }

    @Test
    public void getProductbyId() {
        Long id = 2L;

        when(repository.findById(id)).thenReturn(Optional.of(new
                Products(2L,"Samsung","4",20000L,"samsung")));

        assertEquals("Samsung",service.productById(id).getPname());
        assertNotEquals(4000L,service.productById(id).getPrice());
    }

    @Test
    public void updateProductbyid(){
        Long id=2L;

        when(repository.findById(id)).thenReturn(Optional.of(new
                Products(2L,"Samsung","4",20000L,"samsung")));

        repository.findById(id).map(product->{
            product.setPrice(400L);
            return repository.save(product);
        });

        assertNotEquals(20000L,service.productById(id).getPrice());
        assertEquals(400L,service.productById(id).getPrice());

    }

    @Test
    public void deleteproductbyid(){

        ProductRepository repository = Mockito.mock(ProductRepository.class);

        List<Products> products = Arrays.asList(
                new Products(2L,"Samsung","4",20000L,"samsung"),
                new Products(4L, "Realme", "5", 20000L, "realme")
        );

        Mockito.when(repository.findAll()).thenReturn(products);

        long id = 4L;
        repository.deleteById(id);

        Mockito.verify(repository).deleteById(id);

        assertNull(repository.findById(id).orElse(null));
    }
}