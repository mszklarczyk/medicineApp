//package com.drugsDB;
//
//import com.mongodb.client.*;
//import org.bson.Document;
//
//import static com.drugsDB.UserHelperMethod.*;
//import static com.mongodb.client.model.Filters.eq;
//
//import java.util.Arrays;
//import java.util.Date;
//
//public class App {
//    public static void main( String args[] ) {
//        //addDrug();
//        //searchDrug();
//        //addPerson();
//        //searchPerson("Igor");
//        //addPersonDrug();
////        dateAdd(new Date(),2);
//        addPersonDrug();
//    }
//
//
//    public static void searchDrug(){
//        MongoDatabase db=DBconnection.DBconnect();
//        MongoCollection<Document> collection = db.getCollection("drugDB");
//        //Document myDoc = collection.find(eq("type", "przeciwzapalny")).first();
//        //System.out.println(myDoc.toJson());
//
//        MongoCursor<Document> cursor = collection.find(eq("type", "przeciwzapalny")).iterator();
//            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
//            }
//    }
//
//    public static void addPersonDrug(){
//        MongoDatabase db=DBconnection.DBconnect();
//        MongoCollection<Document> collection = db.getCollection("PersonDrug");
//
//        Document doc = new Document("personName", getPersonID("Igor"))
//                .append("drugName", "Nurofen")
//                .append("active", true)
//                .append("startDate", dateAdd(new Date(),0))
//                .append("endDate",null)
//                .append("addDay",getDayNumber(new Date()))
//                .append("dosageDay",1)
//                .append("dosageHour", Arrays.asList(8,13,19));
//        collection.insertOne(doc);
//
//        Document doc1 = new Document("personName", getPersonID("Igor"))
//                .append("drugName", "Ibuprom")
//                .append("active", true)
//                .append("startDate", dateAdd(new Date(),0))
//                .append("endDate",null)
//                .append("addDay",getDayNumber(new Date()))
//                .append("dosageDay",2)
//                .append("dosageHour", Arrays.asList(8,19));
//        collection.insertOne(doc1);
//
//        Document doc2 = new Document("personName", getPersonID("Igor"))
//                .append("drugName", "Magne B6")
//                .append("active", true)
//                .append("startDate", dateAdd(new Date(),0))
//                .append("endDate",dateAdd(new Date(),14))
//                .append("addDay",getDayNumber(new Date()))
//                .append("dosageDay",1)
//                .append("dosageHour", Arrays.asList(8));
//        collection.insertOne(doc2);
//
//    }
//
//    public static void addPerson(){
//        MongoDatabase db=DBconnection.DBconnect();
//        MongoCollection<Document> collection = db.getCollection("PersonInfo");
//
//        Document doc = new Document("personName", "Jan")
//                .append("defTime", new Document("morning", 7).append("noon", 13).append("evening",19));
//        collection.insertOne(doc);
//
//        Document doc1 = new Document("personName", "Igor")
//                .append("defTime", new Document("morning", 8).append("noon", 13).append("evening",18));
//        collection.insertOne(doc1);
//
//        Document doc2 = new Document("personName", "Kuba")
//                .append("defTime", new Document("morning", 7).append("noon", 12).append("evening",17));
//        collection.insertOne(doc2);
//    }
//
//    public static void addDrug(){
//        MongoDatabase db=DBconnection.DBconnect();
//        if (!DBconnection.collectionExist(db,"drugDB")) {
//            db.createCollection("drugDB");
//        }
//
//        MongoCollection<Document> collection = db.getCollection("drugDB");
//
//        Document doc = new Document("drugName", "Metafen")
//                .append("type", Arrays.asList("przeciwbólowy", "przeciwgorączkowy"))
//                .append("activeSubstance", new Document("Ibuprofenum", 200).append("Paracetamolum", 325))
//                .append("excipient", Arrays.asList( "powidon", "skrobia żelowana", "celuloza mikrokrystaliczna", "magnezu stearynian"))
//                .append("info", "https://www.doz.pl/apteka/p5235-Metafen_tabletki_20_szt.");
//        collection.insertOne(doc);
//
//        Document doc1 = new Document("drugName", "Laboratoria PolfaŁódź Paracetamol")
//                .append("type", Arrays.asList("przeciwbólowy", "przeciwgorączkowy"))
//                .append("activeSubstance", new Document("Paracetamolum", 500))
//                .append("excipient", Arrays.asList("sorbitol", "skrobia ziemniaczana", "powidon", "magnezu stearynian"))
//                .append("info", "https://www.doz.pl/apteka/p5241-Laboratoria_PolfaLodz_Paracetamol_500_mg_tabletki_10_szt.");
//        collection.insertOne(doc1);
//
//        Document doc2 = new Document("drugName", "Paracetamol Accord")
//                .append("type", Arrays.asList("przeciwbólowy", "przeciwgorączkowy"))
//                .append("activeSubstance", new Document("Paracetamolum", 500))
//                .append("excipient", Arrays.asList("skrobia kukurydziana", "żelatyna", "krzemionka koloidalna bezwodna", "talk", "karboksymetyloskrobia sodowa (typ A)", "magnezu stearynian"))
//                .append("info", "https://www.doz.pl/apteka/p133223-Paracetamol_Accord_500_mg_tabletki_50_szt.");
//        collection.insertOne(doc2);
//
//        Document doc3 = new Document("drugName", "Ibuprofen")
//                .append("type", Arrays.asList("przeciwbólowy", "przeciwgorączkowy","przeciwzapalny"))
//                .append("activeSubstance", new Document("Ibuprofenum", 200))
//                .append("excipient", Arrays.asList("celuloza proszek", "skrobia kukurydziana", "skrobia żelowana", "guma Guar", "talk", "krospowidon (typ A)", "krzemionka koloidalna uwodniona", "olej roślinny utwardzony", "hydroksypropyloceluloza", "makrogol 400", "talk", "żelatyna", "sacharoza", "kaolin", "cukier konfekcjonowany (mieszanina sacharozy i skrobi kukurydzianej)", "węglan wapnia", "guma akacjowa", "tytanu dwutlenek (E 171)", "barwnik biały - Opalux White AS 7000", "wosk Carnauba", "tusz czarny - Opacode Black S-1-17823"))
//                .append("info", "https://www.doz.pl/apteka/p7374-Ibuprom_200_mg_tabletki_powlekane_50_szt.");
//        collection.insertOne(doc3);
//
//        Document doc4 = new Document("drugName", "Ibum")
//                .append("type", Arrays.asList("przeciwbólowy", "przeciwgorączkowy","przeciwzapalny"))
//                .append("activeSubstance", new Document("Ibuprofenum", 200))
//                .append("excipient", Arrays.asList("makrogol 400", "potasu wodorotlenek 50%", "żelatyna", "sorbitol ciekły częściowo odwodniony", "woda oczyszczona", "żółcień chinolinowa E 104", "błękit patentowy E 131"))
//                .append("info", "https://www.doz.pl/apteka/p1937-Ibum_200_mg_kapsulki_elastyczne_10_szt.");
//        collection.insertOne(doc4);
//
//        Document doc5 = new Document("drugName", "Ibupar")
//                .append("type", Arrays.asList("przeciwbólowy", "przeciwgorączkowy","przeciwzapalny"))
//                .append("activeSubstance", new Document("Ibuprofenum", 200))
//                .append("excipient", Arrays.asList("skrobia ziemniaczana", "laktoza jednowodna", "powidon 25", "krzemionka koloidalna bezwodna", "magnezu stearynian", "talk", "sacharoza", "talk", "guma arabska (suszona rozpyłowo)", "czerwień koszenilowa (E 124)", "work Carnauba", "wosk biały"))
//                .append("info", "https://www.doz.pl/apteka/p5253-Ibupar_200_mg_tabletki_drazowane_10_szt.");
//        collection.insertOne(doc5);
//    }
//
//}
