package br.com.gerenciador.pedidos.demo.view.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    private String name;
    private String placeholder;
    private String type;
    private String options;

    public Field(String name, String type) {
        this.name = name;
        this.placeholder = name;
        this.type = type;
    }

    public Field(String name, String placeholder, String type) {
        this.name = name;
        this.placeholder = placeholder;
        this.type = type;
    }

    public Object getAttribute(Object object, String name) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        return PropertyUtils.getProperty(object, name);
    }
}
