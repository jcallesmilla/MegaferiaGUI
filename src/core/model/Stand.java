package core.model;

import core.model.interfaces.IStand;
import core.model.interfaces.IPublisher;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un stand en la feria.
 */
public class Stand implements IStand {

    private long id;
    private double precio;
    private List<IPublisher> editoriales;

    public Stand(long id, double precio) {
        this.id = id;
        this.precio = precio;
        this.editoriales = new ArrayList<>();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public List<IPublisher> getEditoriales() {
        return editoriales;
    }

    @Override
    public void setEditoriales(List<IPublisher> editoriales) {
        this.editoriales = editoriales;
    }

    @Override
    public IStand copiar() {
        Stand copia = new Stand(this.id, this.precio);
        
        List<IPublisher> copiasEditoriales = new ArrayList<>();
        if (this.editoriales != null) {
            for (IPublisher editorial : this.editoriales) {
                
                IPublisher copiaEditorial = new Publisher(
                        editorial.getNit(),
                        editorial.getNombre(),
                        editorial.getDireccion(),
                        null 
                );
                
                copiasEditoriales.add(copiaEditorial);
            }
        }
        copia.setEditoriales(copiasEditoriales);
        return copia;
    }
}