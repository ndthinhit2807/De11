/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de11;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ndthi
 */
public class ChucNang {
    
    public String content1;
    public String content2;
    

    public void encrypt() {

    }

    public void decrypt() {

    }

    public void docFile(String path,String content1,String content2) {
try {
                        FileReader fr = new FileReader(new File(path));
                        StringBuffer sb = new StringBuffer();
                        char ca[] = new char[5];
                        while (fr.ready()) {
                                int leng = fr.read(ca);
                                sb.append(ca, 0, leng);
                            }
                        fr.close();
                        content1 =(sb + "");
            
                        ArrayList<String> mauso = new ArrayList<String>();
                        String a = sb.toString();
                        for (int i = 0; i < 10 ; i++) {
                                String[] parts = a.split("\\n");
                                String mau = parts[i];//split lấy trước enter
                                System.out.println(mau);
                                mauso.add(mau);
                            }
            
                        ArrayList<String> psnguyento = new ArrayList<String>();
                        ArrayList<String> pskhongnguyento = new ArrayList<String>();
//                        SoNguyenTo snt = new SoNguyenTo();
                        String maus = null;
                        for (int i = 0; i < mauso.size(); i++) {
                                String[] b = mauso.get(i).split("/");
                                maus = b[1];
                                if ((Integer.parseInt(maus)) >1 &&kiemtranguyento(Integer.parseInt(maus)) == true) {
                                        psnguyento.add(mauso.get(i)+"\n");
                                    } else {
                                        pskhongnguyento.add(mauso.get(i)+"\n");
                    
                                    }
                            }
                        String custompsnguyento = psnguyento.toString();
                        custompsnguyento = custompsnguyento.substring(1, custompsnguyento.length() - 1).replaceAll(",","").replaceAll(" ","");
                        content1 = ("Các phân số có mẫu\n là nguyên tố:\n"+custompsnguyento);
                        String custompsknguyento = pskhongnguyento.toString();
                        custompsknguyento = custompsknguyento.substring(1, custompsknguyento.length() - 1).replaceAll(",","").replaceAll(" ","");
                        content2 =("Các phân số có mẫu\nkhông là nguyên tố:\n"+custompsknguyento);
                        
                        this.content1 = content1;
                        this.content2 = content2;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                JOptionPane.showMessageDialog(null, "thanh cong");
    }

    public void ghiFile(String path,String content1) {
        try {

            FileWriter fw = new FileWriter(new File(path));
            fw.write(content1);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "thanh cong");
    }
    
    public boolean kiemtranguyento(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
