package Goorm.sec4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2
{
    static class Product
    {
        String name;
        int price;

        Product(String name, int price)
        {
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        Product[] products = new Product[t];

        for(int i = 0; i < t; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            products[i] = new Product(name, price);
        }

        Arrays.sort(products, (p1, p2) -> p1.price - p2.price);

        System.out.println(products[products.length - 1].name + " " + products[products.length - 1].price);
        System.out.println(products[0].name + " " + products[0].price);
    }
}
