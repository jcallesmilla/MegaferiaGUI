package core.controller;

import core.model.Publisher;
import core.model.Stand;
import core.model.storage.PublisherStorage;
import core.model.storage.StandStorage;
import core.controller.util.Response;
import core.controller.util.Status;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CompraController {

    private final StandStorage standStorage;
    private final PublisherStorage publisherStorage;

    public CompraController(StandStorage standStorage, PublisherStorage publisherStorage) {
        this.standStorage = standStorage;
        this.publisherStorage = publisherStorage;
    }

    public Response<List<String>> agregarStandALista(List<String> actuales, String standId) {
        if (standId == null || standId.isEmpty()) {
            return new Response<>(Status.BAD_REQUEST, "Debes seleccionar un stand.");
        }
        List<String> nueva = new ArrayList<>(actuales);
        if (nueva.contains(standId)) {
            return new Response<>(Status.BAD_REQUEST, "El stand ya fue agregado.", nueva);
        }
        nueva.add(standId);
        return new Response<>(Status.OK, "Stand agregado.", nueva);
    }

    public Response<List<String>> eliminarStandDeLista(List<String> actuales, String standId) {
        List<String> nueva = new ArrayList<>(actuales);
        nueva.remove(standId);
        return new Response<>(Status.OK, "Stand removido.", nueva);
    }

    public Response<List<String>> agregarEditorialALista(List<String> actuales, String editorialTexto) {
        if (editorialTexto == null || editorialTexto.isEmpty()) {
            return new Response<>(Status.BAD_REQUEST, "Debes seleccionar una editorial.");
        }
        List<String> nueva = new ArrayList<>(actuales);
        if (nueva.contains(editorialTexto)) {
            return new Response<>(Status.BAD_REQUEST, "La editorial ya fue agregada.", nueva);
        }
        nueva.add(editorialTexto);
        return new Response<>(Status.OK, "Editorial agregada.", nueva);
    }

    public Response<List<String>> eliminarEditorialDeLista(List<String> actuales, String editorialTexto) {
        List<String> nueva = new ArrayList<>(actuales);
        nueva.remove(editorialTexto);
        return new Response<>(Status.OK, "Editorial removida.", nueva);
    }

    public Response<String> comprarStands(List<String> idsStands, List<String> editorialesTexto) {
        if (idsStands == null || idsStands.isEmpty() || editorialesTexto == null || editorialesTexto.isEmpty()) {
            return new Response<>(Status.BAD_REQUEST, "Debes seleccionar al menos un stand y una editorial.");
        }
        Set<Long> idsSinRepetir = new HashSet<>();
        List<Stand> stands = new ArrayList<>();
        for (String idTexto : idsStands) {
            try {
                long id = Long.parseLong(idTexto);
                if (idsSinRepetir.contains(id)) {
                    return new Response<>(Status.BAD_REQUEST, "Hay stands repetidos en la compra.");
                }
                idsSinRepetir.add(id);
                Stand stand = standStorage.buscarPorId(id);
                if (stand == null) {
                    return new Response<>(Status.NOT_FOUND, "El stand con ID " + id + " no existe.");
                }
                stands.add(stand);
            } catch (NumberFormatException e) {
                return new Response<>(Status.BAD_REQUEST, "Los IDs de stands deben ser numéricos.");
            }
        }
        List<Publisher> editoriales = new ArrayList<>();
        Set<String> nits = new HashSet<>();
        for (String texto : editorialesTexto) {
            String nit = texto.contains("(") ? texto.substring(texto.indexOf("(") + 1, texto.indexOf(")")) : texto;
            if (nits.contains(nit)) {
                return new Response<>(Status.BAD_REQUEST, "Hay editoriales repetidas en la compra.");
            }
            nits.add(nit);
            Publisher editorial = publisherStorage.buscarPorNit(nit);
            if (editorial == null) {
                return new Response<>(Status.NOT_FOUND, "La editorial con NIT " + nit + " no existe.");
            }
            editoriales.add(editorial);
        }
        for (Stand stand : stands) {
            List<Publisher> actuales = stand.getEditoriales();
            for (Publisher editorial : editoriales) {
                if (!actuales.contains(editorial)) {
                    actuales.add(editorial);
                }
                List<Stand> standsEditorial = editorial.getStands();
                if (!standsEditorial.contains(stand)) {
                    standsEditorial.add(stand);
                }
                editorial.setStands(standsEditorial);
            }
            stand.setEditoriales(actuales);
        }
        standStorage.notifyObservers();
        publisherStorage.notifyObservers();
        return new Response<>(Status.OK, "Compra realizada con éxito.");
    }
}