package logic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Pablo Ampie
 */
public class FileCsv {

    public  FileCsv(){
        
    }

    private void crearArchivoCSV(String nombreDeArchivo) {
        // this also can be "\t" for tab delimitador
        crearArchivoCSV(nombreDeArchivo, ",");
    }

    private void crearArchivoCSV(String file, String delim) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeCsvFile( ArrayList<Long[]> array,String pFile, String delimiter){
        String nextLine ="\n";
        try{
          FileWriter file=new FileWriter(pFile);
          file.append("X").append(delimiter);
          file.append("CountLeaf").append(delimiter);
          file.append("TimeInitial").append(delimiter);
          file.append("TimeFinal").append(delimiter);
          file.append("DistanceTotal").append(nextLine);
          for(int i=0;i<array.size();i++){
              String var1=Long.toString(array.get(i)[0]);
              String var2=Long.toString(array.get(i)[1]);
              String var3=Long.toString(array.get(i)[2]);
              String var4=Long.toString(array.get(i)[3]);
              String var5=Long.toString(array.get(i)[4]);
              file.append(var1).append(delimiter);
              file.append(var2).append(delimiter);
              file.append(var3).append(delimiter);
              file.append(var4).append(delimiter);
              file.append(var5).append(nextLine);
          }
          file.flush();
          file.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
