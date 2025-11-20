/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// src/main/Main.java
package main;

import com.formdev.flatlaf.FlatDarkLaf;
import core.views.MegaferiaFrame;

import javax.swing.*;

 /*
 * Parcial 3 – Programación Orientada a Objetos
 * Jonathan Calles, Jairo Molina, Santiago Florez
 * NRC: 2461
 * Universidad del Norte – 2025
 */
public class Main {

    public static void main(String[] args) {

        System.setProperty("flatlaf.useNativeLibrary", "false");

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("No se pudo cargar FlatDarkLaf. Se usará el tema por defecto.");
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new MegaferiaFrame().setVisible(true);
        });
    }
}
