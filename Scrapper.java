/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruitment.bricktest;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author rezaadrean
 */
public class Scrapper {
    public static void main(String[] args) throws Exception {

        Document document = Jsoup.connect("https://www.tokopedia.com/search?component_id=02.02.01.01&navsource=home&q=mobile%20phone&source=universe&st=product").timeout(7000)
                .get();
         List<Phone> list = new ArrayList<Phone>();

         String title = null;
         String price = null;
         String image = null;
         String rating = null;
         String store = null;
         Phone p = new Phone();
        for (Element row : document.select("div.css-akzs43")) {                        
            p.setName(row.select("div.css-1f4mp12").text());
            p.setPrice(row.select("div.css-rhd610").text());
            p.setImage(row.select("div.css-10xc038 img").attr("src"));            
            for (Element rw : row.select("div.css-zqy2fu")) {                
                p.setRating(rw.select(".css-etd83i").text());
            }
            
            for (Element r : row.select("div.css-1rn0irl")) {                
                p.setStore(r.select(".css-qjiozs").text());
            }            
            
            list.add(p);
        }
        System.out.println("size "+list.size());
                          
    }
}
