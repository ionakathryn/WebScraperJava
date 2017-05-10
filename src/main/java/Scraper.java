import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scraper {
    static String[] content = new String[500];
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }





         static class MainFrame extends JFrame {
            public MainFrame() {

                setSize(500, 500);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(null);



                final JButton positiveNews = new JButton("top good news posts");
                final JButton wired = new JButton("top wired posts");
                final JButton stackOverflow = new JButton("top stack overflow posts");

                wired.setSize(200,50);
                wired.setLocation(150,50);
                positiveNews.setLocation(150,150);
                stackOverflow.setSize(200,50);
                stackOverflow.setLocation(150,250);

                positiveNews.setSize(200,50);

                positiveNews.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == positiveNews) {
                            try {
                                scrapePostive();
                                JOptionPane.showMessageDialog(null,"***scraping***");
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }


                    }

                });

                wired.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == wired) {
                            try {
                                scrapeWired();
                                JOptionPane.showMessageDialog(null,"***scraping***");
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }


                    }

                });

                stackOverflow.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == stackOverflow) {
                            try {
                                scrapeStackOverflow();
                                JOptionPane.showMessageDialog(null,"***scraping***");
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }


                    }

                });

                add(positiveNews);
                add(wired);
                add(stackOverflow);


            }






            public static void scrapePostive() throws Exception {
                Document doc = Jsoup.connect("https://www.positive.news/").get();
                Elements temp = doc.select("div.item-wrapper");
                int i = 0;

                for (Element titleList : temp){
                    i++;
                    System.out.println(i+ " " + titleList.getElementsByTag("a").first().text());
                }


            }

             public static void scrapeWired() throws Exception {
                 Document doc = Jsoup.connect("http://www.wired.co.uk/").get();
                 Elements temp = doc.select("div.c-card-section__constrain");
                 int i = 0;

                 System.out.println("Results of wired news scrape");

                 for (Element titleList : temp){
                     i++;
                     System.out.println(i+ " " + titleList.getElementsByTag("a").first().text());
                 }


             }

             public static void scrapeStackOverflow() throws Exception {
                 Document doc = Jsoup.connect("http://stackoverflow.com/").get();
                 Elements temp = doc.select("div.summary");
                 int i = 0;

                 System.out.println("Results of stack overflow news scrape");

                 for (Element titleList : temp){
                    i++;
                    content[i] = titleList.getElementsByTag("a").first().text();
                 }

                 fileWrite(content);


             }
        }

        static public void fileWrite(String[] content){
            final String FILENAME = "/home/iiiiiii/IdeaProjects/WebScraperJava/src/main/java/File.txt";
            BufferedWriter bw = null;
            FileWriter fw = null;

            try{
                fw = new FileWriter(FILENAME);
                bw = new BufferedWriter(fw);
                for (int a = 0; a < 10; a++) {
                    bw.write(content[a]);
                }
                System.out.println("done");
            }

            catch (IOException e){
                e.printStackTrace();
            }

            finally {
                try{
                    if(bw!=null)
                        bw.close();

                    if(fw!= null)
                        fw.close();
                    }
                    catch(IOException e){
                    e.printStackTrace();

                    }
                }
            }
        }




