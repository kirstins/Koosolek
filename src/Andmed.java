import java.util.ArrayList;

/**
 * Created by kirstin on 03/02/2017.
 */
public class Andmed {
    ArrayList<String>teemad=new ArrayList<>();
    ArrayList<Integer>aeg=new ArrayList<>();
    ArrayList<String>ajas=new ArrayList<>();
    ArrayList<String>otsusega=new ArrayList<>();
    String jah="jah";
    String ei="ei";
    double onnestunud=0;
   double efektiivsus=0;

    public void lisaAndmed(String a, int b){
        teemad.add(a);
        aeg.add(b);

        for (int i=0; i<teemad.size(); i++){
            System.out.println("Teema: "+teemad.get(i)+", planeeritud aeg: "+aeg.get(i));
        }

    }

    public void lisaKokkuvote (String a, String b){
        ajas.add(a);
        otsusega.add(b);
        for (int i=0; i<teemad.size(); i++){
            System.out.println("Koosolek mahtus aega: "+ajas.get(i)+", koosolekul võeti vastu otsus: "+otsusega.get(i));
        }
    }

    public String peetudKoosolekud(){
        int mitu=teemad.size();
        String koosolekud=new String("Peetud koosolekute arv: "+mitu);
        return koosolekud;
    }
    public String onnestunud(String a, String b){
        if(a==jah&&b==jah){
            onnestunud++;
        }
        String edukad=new String("Õnnestunud koosolekute arv: "+onnestunud);
        return edukad;
    }

    public String efektiivsus(){
        double mitu=teemad.size();
        efektiivsus=(onnestunud/mitu)*100;
        System.out.println(efektiivsus);

        if(efektiivsus>70){
            String edukus= new String("Firma koosolekute efektiivsus on: "+efektiivsus+". Kõik on super!");
            return edukus;
        }
        else {
            String edukus= new String("Firma koosolekute efektiivsus on: "+efektiivsus+". Proovi efektiivsemalt");
            return edukus;
        }

    }

}
