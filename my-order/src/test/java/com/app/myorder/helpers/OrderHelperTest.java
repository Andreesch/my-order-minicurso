package com.app.myorder.helpers;

import com.app.myorder.api.dtos.OrderItemCreationDto;
import com.app.myorder.entities.Product;
import com.app.myorder.helper.OrderHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class OrderHelperTest {

    @Test
    public void calculateTotalValueTest() {

        List<OrderItemCreationDto> orderItemCreationDtos = Arrays.asList(
                new OrderItemCreationDto().setQuantity(1).setItemId(1),
                new OrderItemCreationDto().setQuantity(2).setItemId(2)
        );

        List<Product> products = Arrays.asList(
                new Product().setId(1).setValue(2d),
                new Product().setId(2).setValue(3d)
        );

        Double totalValue = OrderHelper.calculateTotalValue(orderItemCreationDtos, products);
        assertEquals(8d, totalValue.doubleValue());
    }

    @Test
    public void calculateItemValueTest() {
        Product product = Mockito.mock(Product.class);
        Mockito.when(product.getValue()).thenReturn(2d);

        Double itemValue = OrderHelper.calculateItemValue(2, product);

        assertNotNull(itemValue);
        assertEquals(4d, itemValue.doubleValue());
    }

}
