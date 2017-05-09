import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scraper {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }





         static class MainFrame extends JFrame {
            public MainFrame() {

                setSize(500, 500);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(null);


                final JButton positiveNews = new JButton("good news");
                final JButton wired = new JButton("top wired posts");

                positiveNews.setSize(250,100);
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
                add(positiveNews);
                add(wired);


            }






            public static void scrapePostive() throws Exception {
                Document doc = Jsoup.connect("https://www.positive.news/").get();
                Document doc1 = Jsoup.connect("http://www.sunnyskyz.com/good-news").get();
                Elements temp1 = doc1.select("div.leftcol");
                Elements temp = doc.select("div.item-wrapper");
                int i = 0;
                int j = 0;

                for (Element titleList : temp){
                    i++;
                    System.out.println(i+ " " + titleList.getElementsByTag("a").first().text());
                }
                

            }
        }


}


