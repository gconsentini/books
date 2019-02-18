package com.gconsentini.books.crawler;

import com.gconsentini.books.model.entity.BookEntity;
import com.gconsentini.books.repository.BookRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksCrawler {

    @Autowired
    private BookRepository bookRepository;

    public void collectBooks(String url) {
        Document document;
        Connection connection = Jsoup.connect(url);
        try {
            document = connection.get();

            List<String> titles = getTitles(document);
            List<String> descriptions = getDescriptions(document);
            List<String> languages = getLanguages(document);
            List<String> links = getLinks(document);
            
            postBooks(titles, descriptions, languages, links);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void postBooks(List<String> titles, List<String> descriptions, List<String> languages, List<String> links) {
        descriptions.remove(1);
        descriptions.remove(2);
        if(titles.size() == descriptions.size() && titles.size() == languages.size() && titles.size() == links.size()){
            for (int i = 0; i < titles.size(); i++){
                BookEntity bookEntity = new BookEntity();
                bookEntity.setTitle(titles.get(i));
                bookEntity.setDescription(descriptions.get(i));
                bookEntity.setLanguage(languages.get(i));
                bookEntity.setIsbn(getIsbnFromLink(links.get(i)));
                bookRepository.save(bookEntity);
            }
        }
    }

    private String getIsbnFromLink(String link) {
        if (link.contains("amazon.com")) {
            List<String> elements = Arrays.asList(link.split("/"));
            return elements.get(elements.size()-1);
        }else {
            Document documentLink;
            Connection connection = Jsoup.connect(link);
            try {
                documentLink = connection.get();
                Elements isbn = documentLink.getElementsByAttributeStarting("isbn");
                if (isbn.size()>0)
                    return isbn.first().attr("isbn");
                return "Unavailable";
            } catch (IOException e) {
                e.printStackTrace();
                return "Unavailable";
            }
        }
    }

    private List<String> getTitles(Document document) {
        return document.select("article > h2")
                .stream().map(Element::text)
                .collect(Collectors.toList());
    }

    private List<String> getDescriptions(Document document) {
        return document.select("article > p")
                .stream().map(Element::text)
                .collect(Collectors.toList());
    }

    private List<String> getLanguages(Document document) {
        return document.select(".book-lang")
                .stream().map(e -> e.text().toUpperCase())
                .collect(Collectors.toList());
    }

    private List<String> getLinks(Document document) {
        return document.select("article > a")
                .stream().map(element -> element.attr("href"))
                .collect(Collectors.toList());
    }

}
