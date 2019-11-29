package com.company.dao;

import java.util.List;

public interface ElementDAO<E> {

    void addElement(E element);

    void updateElement(E element);

    E getElementByID(int elementId);

    List<E> getAllElements();

    void deleteElement(E element);
}
