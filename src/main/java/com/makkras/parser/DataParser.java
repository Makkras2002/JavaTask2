package com.makkras.parser;


import com.makkras.entity.impl.Sphere;

import java.util.List;

public interface DataParser {
    List<Sphere> extractToList(List<String> list);
}
