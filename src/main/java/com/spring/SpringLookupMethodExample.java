package com.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLookupMethodExample {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        try {
/*            PizzaShop pizzaShop = (PizzaShop) context.getBean("pizzaShop");
            Pizza firstPizza = pizzaShop.makePizza();
            System.out.println("First Pizza: " + firstPizza);

            Pizza secondPizza = pizzaShop.makePizza();
            System.out.println("Second Pizza: " + secondPizza);
            
            Pizza veggiePizza = pizzaShop.makeVeggiePizza();
            System.out.println("Veggie Pizza: " + veggiePizza);*/

            RequestProcessor processor = (RequestProcessor)context.getBean("processor");
            for (int i=0;i<3;i++){
                ResourceA resource = processor.getResourceA();
                System.out.println("resource A:" +resource );
            }
            for (int i=0;i<3;i++){
                ResourceB resource = processor.getResourceB();
                System.out.println("resource B:" +resource );
            }
        } finally {
            context.close();
        }
    }
}
