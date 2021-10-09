package com.makkras.parser;


import com.makkras.entity.impl.SphereRepo;

import java.util.List;

public interface DataParser {
    SphereRepo extractToRepo(List<String> list);
}
