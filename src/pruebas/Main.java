/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dgonzalez
 */


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Prueba> test=new ArrayList<Prueba>();
        System.out.println("Ingrese el total de la prueba : ");
        int totaltest = Integer.parseInt(br.readLine());
        System.out.println("Ingrese el total de la muestra : ");
        int sizesample=Integer.parseInt(br.readLine());
        for(int i=1;i<=totaltest;i++){
            Prueba prueba=new Prueba();
            prueba.setId(i);
            for(int j=1;j<=sizesample;j++){
                System.out.println("Ingrese valores de prueba : ");
                Float number=Float.parseFloat(br.readLine());
                prueba.getNumeros().add(number);
            }
            test.add(prueba);
        }
        System.out.println("\n Tabla de resultados \n");
        System.out.println("\n numero prueba | Varianza  | Frecuencia\n");
        for(Prueba prueba:test){
            prueba.setMedia(calculateVariance(prueba.getNumeros()));
            prueba.setFrecuenciaChi(calculateFrecuenciaChi(prueba.getNumeros()));
            System.out.println("\n "+prueba.getId()+" | "+prueba.getMedia()+" | "+prueba.getFrecuenciaChi()+" \n");
            
        }
        for(Prueba prueba:test){
            Float media=calculateVariance(prueba.getNumeros());
            Float limSup=calculateDevStandar(prueba.getNumeros(),media);
            Float limInf=calculateLimInf(limSup,media);
            System.out.println("\n Limite superior "+limSup+" de la prueba "+prueba.getId()+"\n");
            System.out.println("\n Limite Inferior "+limInf+" de la prueba "+prueba.getId()+" \n");
        }
    }
    
    
    public static Float calculateVariance(List<Float> numbers){
        Float promedio=0f;
        for(Float number:numbers){
            promedio=promedio+number;
        }
        promedio=promedio/numbers.size();
        return promedio;
    }
    
    public static Float calculateFrecuenciaChi(List<Float> numbers){
        Map<Float,Float> frecuencias=calculateAbsFrecuency(numbers);
        Float frecuenciachi=0f;
        for(Float number:numbers){
            frecuenciachi=frecuenciachi+((frecuencias.get(number)-(frecuencias.get(number)/numbers.size())))/(frecuencias.get(number)/numbers.size());
        }
        return frecuenciachi;
    } 
    
    public static Map<Float,Float> calculateAbsFrecuency(List<Float> numbers){
        Map<Float,Float> frecuencias=new HashMap<Float,Float>();
        Float sig=numbers.get(0);
        frecuencias.put(numbers.get(0), 0f);
        for(Float numb:numbers){
            if(sig!=numb){
                frecuencias.put(numb, 0f);
                sig=numb;
            }
        }
        for(Float key:frecuencias.keySet()){
            int frec=0;
            for(Float num:numbers){
                if(key.equals(num)){
                    frec++;
                }
            }
            frecuencias.put(key,new Float(frec));
        } 
        return frecuencias;
    }
    
    public static Float calculateDevStandar(List<Float> numbers,Float media){
        Float promedio=0f;
        for(Float number:numbers){
            promedio=promedio+(number-media)*(number-media);
        }
        promedio=promedio/numbers.size();
        promedio=new Float(Math.sqrt(promedio));
        return promedio;
    }
    
    
    public static Float calculateSupLimit(List<Float> numbers){
        Float media=calculateVariance(numbers);
        Float desvstand=calculateDevStandar(numbers,media);
        Float limsup=desvstand*3+media;
        return limsup;
    }
    public static Float calculateLimInf(Float limsup,Float media){
        return media-limsup;
    }
}
