package it.sevenbits.practice5;

import java.util.List;

public class ListOperator {

    public <E extends Comparable<E>> E max(List<E> list, int start, int end) {
        E max = list.get(start);
        for (int i = start + 1; i <= end; i++) {
            E current = list.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }

    public <E> void changeElementsPosition(List<E> list, int first, int second) {
        if (first > second) {
            int temp = second;
            second = first;
            first = temp;
        }
        E t = list.get(first);
        list.remove(first);
        list.add(first, list.get(second - 1));
        list.add(second, t);
        list.remove(second + 1);
    }
}
