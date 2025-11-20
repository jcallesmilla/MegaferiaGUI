/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.util.ArrayList;

public class Stand implements Cloneable {

    private long id;
    private double price;
    private ArrayList<Publisher> publishers;

    public Stand(long id, double price) {
        this.id = id;
        this.price = price;
        this.publishers = new ArrayList<>();
    }

    // ← SOLO AÑADIDO: clone() obligatorio para Storage
    @Override
    public Stand clone() {
        try {
            Stand cloned = (Stand) super.clone();
            cloned.publishers = new ArrayList<>(this.publishers);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    // ← TUS MÉTODOS ORIGINALES SIN CAMBIOS
    public void addPublisher(Publisher publisher) {
        this.publishers.add(publisher);
    }

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<Publisher> getPublishers() {
        return new ArrayList<>(publishers);  // ← devuelve copia segura
    }
    
    public int getPublisherQuantity() {
        return this.publishers.size();
    }

    public boolean isPurchased() {
        return !publishers.isEmpty();
    }
}
