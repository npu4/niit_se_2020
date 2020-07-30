package com;

import java.util.ArrayList;
import java.util.List;

public class AnnotationWarning {


/*
    static class MyArrayList extends ArrayList {


        @Override
        public int size() {
            return 0;
        }
    } */



    @SuppressWarnings({"unchecked","rawtypes"})
    private List<String> getStringArray() {

        final ArrayList arrayList = new ArrayList();
        return (List<String>) arrayList;
    }

}
