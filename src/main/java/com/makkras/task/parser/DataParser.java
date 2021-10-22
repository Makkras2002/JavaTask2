package com.makkras.task.parser;


import com.makkras.task.entity.impl.Sphere;

import java.util.List;

public interface DataParser {
    List<Sphere> extractToList(List<String> list);
}
