/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package davoudr.dvdlibrary;

import davoudr.dvdlibrary.controller.DVDLibraryController;

/**
 *
 * @author davoudramezanikermani
 */
public class App {

    public static void main(String[] args) {
        
        DVDLibraryController controller = new DVDLibraryController();
        controller.run();
        
    }
}
