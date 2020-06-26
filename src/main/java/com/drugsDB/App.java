package com.drugsDB;

import com.mongodb.client.*;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

import java.util.Arrays;

public class App {
    public static void main( String args[] ) {
        //addDrug();
        searchDrug();

        //String str = UserHelperMethod.parseDrugSubstance("powidon, skrobia żelowana, celuloza mikrokrystaliczna, magnezu stearynian");
        //System.out.println(str);
    }

    public static void searchDrug(){
        MongoDatabase db=DBconnection.DBconnect();
        MongoCollection<Document> collection = db.getCollection("drugDB");
        //Document myDoc = collection.find(eq("type", "przeciwzapalny")).first();
        //System.out.println(myDoc.toJson());

        MongoCursor<Document> cursor = collection.find(eq("type", "przeciwzapalny")).iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }

    public static void addDrug(){
        MongoDatabase db=DBconnection.DBconnect();
        if (!DBconnection.collectionExist(db,"drugDB")) {
            db.createCollection("drugDB");
        }

        MongoCollection<Document> collection = db.getCollection("drugDB");

        Document doc = new Document("drugName", "Metafen")
                .append("type", Arrays.asList("przeciwbólowy", "przeciwgorączkowy"))
                .append("activeSubstance", new Document("Ibuprofenum", 200).append("Paracetamolum", 325))
                .append("excipient", Arrays.asList("powidon", "skrobia żelowana", "celuloza mikrokrystaliczna", "magnezu stearynian"))
                .append("info", "https://www.doz.pl/apteka/p5235-Metafen_tabletki_20_szt.");
        collection.insertOne(doc);

        Document doc1 = new Document("drugName", "Laboratoria PolfaŁódź Paracetamol")
                .append("type", Arrays.asList("przeciwbólowy", "przeciwgorączkowy"))
                .append("activeSubstance", new Document("Paracetamolum", 500))
                .append("excipient", Arrays.asList("sorbitol", "skrobia ziemniaczana", "powidon", "magnezu stearynian"))
                .append("info", "https://www.doz.pl/apteka/p5241-Laboratoria_PolfaLodz_Paracetamol_500_mg_tabletki_10_szt.");
        collection.insertOne(doc1);

        Document doc2 = new Document("drugName", "Paracetamol Accord")
                .append("type", Arrays.asList("przeciwbólowy", "przeciwgorączkowy"))
                .append("activeSubstance", new Document("Paracetamolum", 500))
                .append("excipient", Arrays.asList("skrobia kukurydziana", "żelatyna", "krzemionka koloidalna bezwodna", "talk", "karboksymetyloskrobia sodowa (typ A)", "magnezu stearynian"))
                .append("info", "https://www.doz.pl/apteka/p133223-Paracetamol_Accord_500_mg_tabletki_50_szt.");
        collection.insertOne(doc2);

        Document doc3 = new Document("drugName", "Ibuprofen")
                .append("type", Arrays.asList("przeciwbólowy", "przeciwgorączkowy","przeciwzapalny"))
                .append("activeSubstance", new Document("Ibuprofenum", 200))
                .append("excipient", Arrays.asList("celuloza proszek", "skrobia kukurydziana", "skrobia żelowana", "guma Guar", "talk", "krospowidon (typ A)", "krzemionka koloidalna uwodniona", "olej roślinny utwardzony", "hydroksypropyloceluloza", "makrogol 400", "talk", "żelatyna", "sacharoza", "kaolin", "cukier konfekcjonowany (mieszanina sacharozy i skrobi kukurydzianej)", "węglan wapnia", "guma akacjowa", "tytanu dwutlenek (E 171)", "barwnik biały - Opalux White AS 7000", "wosk Carnauba", "tusz czarny - Opacode Black S-1-17823"))
                .append("info", "https://www.doz.pl/apteka/p7374-Ibuprom_200_mg_tabletki_powlekane_50_szt.");
        collection.insertOne(doc3);

        Document doc4 = new Document("drugName", "Ibum")
                .append("type", Arrays.asList("przeciwbólowy", "przeciwgorączkowy","przeciwzapalny"))
                .append("activeSubstance", new Document("Ibuprofenum", 200))
                .append("excipient", Arrays.asList("makrogol 400", "potasu wodorotlenek 50%", "żelatyna", "sorbitol ciekły częściowo odwodniony", "woda oczyszczona", "żółcień chinolinowa E 104", "błękit patentowy E 131"))
                .append("info", "https://www.doz.pl/apteka/p1937-Ibum_200_mg_kapsulki_elastyczne_10_szt.");
        collection.insertOne(doc4);

        Document doc5 = new Document("drugName", "Ibupar")
                .append("type", Arrays.asList("przeciwbólowy", "przeciwgorączkowy","przeciwzapalny"))
                .append("activeSubstance", new Document("Ibuprofenum", 200))
                .append("excipient", Arrays.asList("skrobia ziemniaczana", "laktoza jednowodna", "powidon 25", "krzemionka koloidalna bezwodna", "magnezu stearynian", "talk", "sacharoza", "talk", "guma arabska (suszona rozpyłowo)", "czerwień koszenilowa (E 124)", "work Carnauba", "wosk biały"))
                .append("info", "https://www.doz.pl/apteka/p5253-Ibupar_200_mg_tabletki_drazowane_10_szt.");
        collection.insertOne(doc5);
    }

}
