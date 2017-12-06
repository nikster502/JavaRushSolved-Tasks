package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by nik on 22.11.2017.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable,Cloneable,Set<E>{
    private static final Object PRESENT = new Object();

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public void clear() {
     map.clear();
    }

    @Override
    public Object clone() {
        AmigoSet amigoSet = new AmigoSet<>();
        try {
            amigoSet.addAll(this);
            amigoSet.map.putAll((Map) this.map.clone());
        } catch (Exception e) {
            throw new InternalError();
        }
        return amigoSet;
    }

    private final void writeObject(ObjectOutputStream x) throws IOException {

        x.defaultWriteObject();

        x.writeObject(map.size());
        for(E e:map.keySet()){
            x.writeObject(e);
        }
        x.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        x.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
    }

    private final void readObject(ObjectInputStream x) throws IOException, ClassNotFoundException {
        x.defaultReadObject();

        Set<E> set = new HashSet<>();
        for (int i = 0; i < x.readInt(); i++) {
            set.add((E) x.readObject());
        }
        int capacity = x.readInt();
        float loadFactor = x.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        for (E e : set) {
            map.put(e, PRESENT);
    }
    }
    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>(Math.max((int) (collection.size() / .75f) + 1, 16));
        addAll(collection);
    }

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }


    private transient HashMap<E,Object> map;
    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }
}
