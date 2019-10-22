package test.threads;

import java.io.*;
import java.util.Date;

public class Writer {

    public Writer(String file) throws FileNotFoundException {
     stream = new FileOutputStream(new File(file));
    }


    private OutputStream stream;

    public void append(String data) throws IOException {
        stream.write(data.getBytes());
    }
    public void flush() throws IOException {
        stream.flush();
    }

    public void close() throws IOException {
        stream.close();

    }

    public static void main(String[] args) throws FileNotFoundException {
        String text =  "...........................................................................";
        String fileName = "xx.txt";
        int n =100000;
        Writer w =new Writer(fileName);
        long startTime = System.currentTimeMillis();

        for(int i=0 ; i<n;i++){
            try {
                w.append(text);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    w.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        w = null;
        System.gc();


        long endTime = System.currentTimeMillis();
        System.out.println("wih one connection:  "+(endTime-startTime));

//
//        try {
//          //  w.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        startTime = System.currentTimeMillis();
        for(int i=0 ; i<n;i++){
            OutputStream outputStream = null;
            try {
               outputStream = new FileOutputStream(fileName+1);
                outputStream.write(text.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("many one connection:  "+(endTime-startTime));


    }
}
