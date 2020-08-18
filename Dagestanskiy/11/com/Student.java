package com;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
    List<Lection> lectionList;
    String name;
    Set <Lection> lections;

    public Student(List<Lection> lectionList, String name) {
        this.lectionList = lectionList;
        this.name = name;
        this.lections = initLections(lectionList);
    }
    private Set<Lection> initLections( List<Lection> lections){
        Set<Lection> lections1 = new HashSet<>();
        for (int i = 0; i < lections.size(); i++) {
            // считаем, что в среднем студент не посещает половину лекций из расписания
            if(2 > rndIn(0, 3)) lections1.add(lections.get(i));
        }
        return lections1;
    }

    public List<Lection> getLectionList() {
        return lectionList;
    }

    public String getName() {
        return name;
    }

    public Set<Lection> getLections() {
        return lections;
    }

    public int getLectionsSize() {
        return lections.size();
    }

    static int rndIn(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lectionList=" + lectionList +
                ", name='" + name + '\'' +
                ", lections=" + lections +
                '}';
    }
}
