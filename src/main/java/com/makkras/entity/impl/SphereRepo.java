package com.makkras.entity.impl;

import com.makkras.entity.CustomRepo;
import com.makkras.service.spherecomparator.CustomComparator;
import com.makkras.service.spherecomparator.impl.SphereComparatorById;
import com.makkras.service.spherecomparator.impl.SphereComparatorByName;
import com.makkras.service.spherecomparator.impl.SphereComparatorByRadius;
import com.makkras.service.spherecomparator.impl.SphereComparatorByXCordOfCenter;
import com.makkras.specification.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SphereRepo implements CustomRepo{
    private List<Sphere> sphereRepo;
    public SphereRepo(){
        sphereRepo = new ArrayList<>();
    }
    public void addSphere(Sphere sphere){
        sphereRepo.add(sphere);
    }
    public List<Sphere> getList(){
        return sphereRepo;
    }
    public void removeSphere(Sphere sphere){
        sphereRepo.remove(sphere);
        WareHouse.getInstance().removeData(sphere.getId());
    }
    public List<Sphere> query(Specification specification){
        List<Sphere> sphereList = sphereRepo.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());
        return sphereList;
    }
    public void sortRepoByName(){
        CustomComparator comparator = new SphereComparatorByName();
        sphereRepo.sort(comparator);
    }
    public void sortRepoById(){
        CustomComparator comparator = new SphereComparatorById();
        sphereRepo.sort(comparator);
    }
    public void sortRepoByRadius(){
        CustomComparator comparator = new SphereComparatorByRadius();
        sphereRepo.sort(comparator);
    }
    public void sortRepoByXCordOfCenter(){
        CustomComparator comparator = new SphereComparatorByXCordOfCenter();
        sphereRepo.sort(comparator);
    }
}
