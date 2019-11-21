/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author javith
 */
public class conectionFTP {

    FTPClient client = new FTPClient();
    String sFTP = "files.000webhost.com";
    String sUser = "federated-breaths";
    String sPassword = "SoloYo20";

    public void conect() {
        try {
            client.connect(sFTP);
            boolean login = client.login(sUser, sPassword);
        } catch (IOException ioe) {
        }
    }

    public void uploadFile(String routeFile, String routeInFTP) throws IOException {
        FileInputStream fis = new FileInputStream(routeFile);

        client.appendFile(routeInFTP, fis);

    }

    public void deleteFile(String route) {
        try {
            client.deleteFile(route);
        } catch (IOException ex) {
            Logger.getLogger(conectionFTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconect() {
        try {
            client.logout();
            client.disconnect();
        } catch (IOException ioe) {
        }
    }

    public static void changeDataFTP() {
        try {
            conectionFTP a = new conectionFTP();
            a.conect();
            a.deleteFile("public_html/bd1.csv");
            a.deleteFile("public_html/bd2.csv");
            a.uploadFile("Archivo.csv", "public_html/bd1.csv");
            a.uploadFile("Archivo2.csv", "public_html/bd2.csv");
            a.disconect();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }


}
