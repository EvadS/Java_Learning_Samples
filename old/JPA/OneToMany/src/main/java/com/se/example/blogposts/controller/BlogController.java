package com.se.example.blogposts.controller;


import com.se.example.blogposts.entity.Blog;
import com.se.example.blogposts.models.BlogModel;
import com.se.example.blogposts.repository.BlogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

    Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    BlogRepository blogRespository;

    @GetMapping("/blog")
    public List<Blog> index() {
       // logger.info("find all");
        return blogRespository.findAll();
    }



    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id) {
        int blogId = Integer.parseInt(id);

        return blogRespository.findById(blogId)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return blogRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body) {
        String title = body.get("title");
        String content = body.get("content");
        Blog blog = new Blog(title, content);

        logger.warn("A WARN Message----------------");
        logger.debug("try to create new blog " + blog.toString() );

        return blogRespository.save(blog);
    }

    @PostMapping("/create")
    public Blog createBlog(@RequestBody @Valid BlogModel body) {
         Blog blog = body.toEntity();

        logger.warn("A WARN Message----------------");
        logger.debug("try to create new blog " + blog.toString() );

        return blogRespository.save(blog);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int blogId = Integer.parseInt(id);
        // getting blog

        Blog blog = blogRespository.findById(blogId)
                .orElseThrow(() -> new EntityNotFoundException(id));

        blog.setTitle(body.get("title"));
        blog.setContent(body.get("content"));
        return blogRespository.save(blog);
    }

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        blogRespository.deleteById(blogId);
        return true;
    }

}