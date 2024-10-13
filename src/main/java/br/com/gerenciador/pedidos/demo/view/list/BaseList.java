package br.com.gerenciador.pedidos.demo.view.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseList<T> {
    private String title;
    private List<String> columns;
    private T data;
    private String baseUrl;
}
