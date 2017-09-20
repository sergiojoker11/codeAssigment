package sj11.priceBasket.till;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class AbstractBeanGetter {

    private static final String CONFIG_PACKAGE = "sj11.priceBasket.config";

    private AnnotationConfigApplicationContext context;

    protected Object getBean(Class clazz){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan(CONFIG_PACKAGE);
        ctx.refresh();
        return ctx.getBean(clazz);
    }
}
